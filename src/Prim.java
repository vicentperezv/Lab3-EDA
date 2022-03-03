import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Prim {
    private HashMap<Integer, quintupla> map;
    public Prim(HashMap<Integer,quintupla> map){
        this.map=map;
    }
    public int minkey(double costos[], boolean visitado[]){
        double min = Integer.MAX_VALUE;
        int min_index = -1;
        for(int i = 0; i < costos.length; i++){
            if(visitado[i] == false && costos[i]< min){
                min = costos[i];
                min_index= i;
            }
        }
        return min_index;
    }
    void printMST(int parent[], double graph[][]){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Prim.txt",false));
            writer.write("Como resultado se obtuvo las diferencias de precio maximo entre" +"\n"+
                           "cada par de productos de la categoria SHOES, lo que significa haber"+"\n"+
                           "encontado el menor costo entre los precios, implementando el algoritmo"+"\n"+
                           "de Prim, donde encuentra el subconjunto de aristas que tienen la menor"+"\n"+
                           "diferencia de precio posible." +"\n"+"\n");

            writer.write("Producto 1"+ "\t|| "+"Producto 2"+"\t|| "+ "Diferencia de costo maximos"+ "\n");

            for (int i = 1; i < graph.length; i++) {
                writer.write(map.get(parent[i]).getName() + "  ||  " + map.get(i).getName() + "\t||" + graph[i][parent[i]] + "\n");
            }

            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public void prim(double grafo[][]){



        int padres[] = new int[grafo.length];
        double costos[]= new double[grafo.length];
        boolean visitado[]= new boolean[grafo.length];
        for(int i= 0; i< grafo.length;i++){
            costos[i]= Integer.MAX_VALUE;
            visitado[i]=false;
        }

        costos[0]=0;
        padres[0]=-1;
        for (int j = 0; j< grafo.length-1;j++){
            int u = minkey(costos, visitado);
            visitado[u] = true;

            for(int k = 0; k< grafo.length; k++){
                if(grafo[u][k] != 0 && visitado[k] == false && grafo[u][k] < costos[k]){
                    padres[k]= u;
                    costos[k]= grafo[u][k];

                }
            }

        }
        printMST(padres, grafo);
    }
}
