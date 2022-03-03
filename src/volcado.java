import java.io.*;
import java.util.*;

public class volcado {
    private String[] files;
    private hashMaps data;
    private ArrayList<quintupla> quintuplaArrayList;


    public volcado(){
        files = new String[]{"./mx-amazon-devices.csv", "./mx-automotive.csv", "./mx-baby.csv", "./mx-books.csv",
                "./mx-digital-text.csv", "./mx-dvd.csv", "./mx-electronics.csv", "./mx-grocery.csv",
                "./mx-handmade.csv", "./mx-hpc.csv", "./mx-kitchen.csv", "./mx-music.csv",
                "./mx-musical-instruments.csv", "./mx-officeproduct.csv","./mx-pet-supplies.csv",
                "./mx-shoes.csv", "./mx-software.csv", "./mx-sports.csv", "./mx-tools.csv",
                "./mx-toys.csv", "./mx-videogames.csv"};

        data =new hashMaps();
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
    private double[] sMaxp(ArrayList<Vector<String>> list, int n,int m){
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
    private void toBST() {

        try {
            BufferedReader reader;
            for (String fl : files) {
                ArrayList<quintupla> quintuplas = new ArrayList<>();
                ArrayList<Vector<String>> dataset = new ArrayList<>();
                String category = fl.substring(5, fl.length() - 4);
                reader = new BufferedReader(new FileReader(fl));
                String line = reader.readLine();
                BST treeStars= new BST();
                BST treeMax_price = new BST();
                ArrayList<BST> trees = new ArrayList<>();

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
                    for (quintupla search : quintuplas) {
                        if (search.getName().equals(prod_name)) {
                            found = true;
                            search.incQuantity(pair[0], pair[1]);
                        }
                    }
                    if (found != true) {
                        quintupla new_quintupla = new quintupla(prod_name, category,pair[0],pair[1]);
                        quintuplas.add(new_quintupla);
                        quintuplaArrayList.add(new_quintupla);
                    }
                }
                for(quintupla q: quintuplas ){
                    treeStars.insertStar(q);
                    treeMax_price.insertMax_Price(q);
                }
                trees.add(treeStars);
                trees.add(treeMax_price);
                data.put(category, trees);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void toValcado(){
        this.toBST();
    }
    public hashMaps getData(){
        return this.data;
    }
    public void print(){
        for (quintupla t : this.quintuplaArrayList) {
            System.out.println(t.getCategory()+"||"+t.getName()+"||"+t.getQuantity()+"||"+t.getStars()+"||"+t.getMax_price());
        }
    }
}
