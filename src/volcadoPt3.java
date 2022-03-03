import java.io.*;
import java.util.*;

public class volcadoPt3 {


        private String[] files;
        private HashMap<Integer,quintupla> data;
        private ArrayList<quintupla> quintuplaArrayList;
        private grafo grafo;


        public volcadoPt3(){
            files = new String[]{"./mx-shoes.csv"};
            grafo = new grafo();
            data =new HashMap<>();
            quintuplaArrayList = new ArrayList<>();
        }
        private boolean isNumeric(String string){
            try {
                Float.parseFloat(string);
                return true;
            } catch (NumberFormatException nfe){
                return false;
            }
        }
        private double[] sMaxp(ArrayList<Vector<String>> list, int n, int m){
            double[] starnmax= {0,0};
            if(list.get(n).size()>9) {
                if (!list.get(n).get(m).isEmpty()) {
                    if (isNumeric(list.get(n).get(m))) {
                        starnmax[0] = Double.parseDouble(list.get(n).get(m));
                        if (!list.get(n).get(m + 5).isEmpty()) {
                            starnmax[1] = Double.parseDouble(list.get(n).get(m + 5));
                        }
                    } else {
                        sMaxp(list, n, m + 1);
                    }
                }
            }
            return starnmax;
        }
        public void toBST() {

            try {
                BufferedReader reader;
                for (String fl : files) {

                    ArrayList<Vector<String>> dataset = new ArrayList<>();
                    String category = fl.substring(5, fl.length() - 4);
                    reader = new BufferedReader(new FileReader(fl));
                    String line = reader.readLine();

                    while (line != null) {
                        Vector<String> parsing1 = new Vector<>();

                        String[] row1;
                        row1 = line.split("\\|", -1);
                        for (String x : row1) {
                            parsing1.add(x);
                        }
                        dataset.add(parsing1);
                        line = reader.readLine();
                    }
                    for (int progress_index = 1; progress_index < dataset.size(); progress_index++) {

                        double[] pair = new double[2];
                        String prod_name = dataset.get(progress_index).get(3);
                        pair=sMaxp(dataset,progress_index,4);
                        boolean found = false;
                        for (quintupla search : quintuplaArrayList) {
                            if (search.getName().equals(prod_name)) {
                                found = true;
                                search.incQuantity(pair[0], pair[1]);
                            }
                        }
                        if (found != true) {
                            quintupla new_quintupla = new quintupla(prod_name, category,pair[0],pair[1]);
                            quintuplaArrayList.add(new_quintupla);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        public void toMap(){
            int count =0;
            for(quintupla q : quintuplaArrayList){
                data.put(count,q);
                count=count+1;
            }
        }
        public void print(){
            for (int i = 0; i < data.size();i++) {
                System.out.println(data.get(i).getCategory()+"||"+data.get(i).getName()+"||"+data.get(i).getQuantity()+"||"+data.get(i).getStars()+"||"+data.get(i).getMax_price());
            }
        }
        public void grafo(){
            grafo graph = new grafo(data);
            graph.create();
            this.grafo= graph;
        }
        public void prim(){
            this.grafo();
            Prim prim = new Prim(this.data);
            prim.prim(this.grafo.getCost());
        }
        public void dijsktra(){
            Dijskstra dijskstra = new Dijskstra(this.data);
            dijskstra.dijskstra(this.grafo.getCost());
        }
    }


