import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Dijskstra {

    private HashMap<Integer, quintupla> map;
    public Dijskstra(HashMap<Integer,quintupla> map){
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
    void printDij(double costo[], double graph[][]){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Dijskstra.txt",false));
            writer.write("Como resultado se obtuvo las diferencias de precio maximo entre" +"\n"+
                    "entre el primer primer producto y los demas de la categoria SHOES, lo "+"\n"+
                    "que significa haber encontado el menor costo entre los precios, "+"\n"+
                    "implementando el algoritmo de Dijkstra, donde determina el camino menos "+"\n"+
                    "costoso dado un vertice de origen al resto de los vertices." +"\n"+"\n");

            writer.write("Producto "+"\t||"+ "\t Diferencia de costo con el primer producto"+"\n");

            for (int i = 0; i < graph.length; i++) {
                writer.write(map.get(i).getName() + "\t||" + costo[i] + "\n");
            }

            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public void dijskstra(double grafo[][]){

        double costos[]= new double[grafo.length];
        boolean visitado[]= new boolean[grafo.length];
        for(int i= 0; i< grafo.length;i++){
            costos[i]= Integer.MAX_VALUE;
            visitado[i]=false;
        }
        costos[0]=0;

        for (int j = 0; j< grafo.length;j++){
            int u = minkey(costos, visitado);
            visitado[u] = true;

            for(int k = 0; k< grafo.length; k++){
                if(grafo[u][k] != 0 && visitado[k] == false&&costos[u] != Integer.MAX_VALUE && grafo[u][k] + costos[u] < costos[k]){

                    costos[k]= grafo[u][k]+ costos[u];
                }
            }
        }
        printDij(costos,grafo);
    }
}
