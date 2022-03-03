import java.util.HashMap;

public class grafo {

    private double cost[][];
    private HashMap<Integer,quintupla> map;
    public grafo(){}
    public grafo(HashMap<Integer,quintupla>map){
        this.cost = new double[map.size()][map.size()];
        this.map = map;
    }
    public double[][] getCost(){
        return this.cost;
    }
    private void insert(int a, int b,double cost){
        this.cost[a][b]=cost;
        this.cost[b][a]=cost;
    }
    public void insert(int a, int b){
        double cost = map.get(a).getMax_price()-map.get(b).getMax_price();
        if(cost<0){
            cost = cost*-1;
        }
        insert(a,b,cost);
    }
    public void create(){
        for(int i = 0; i < this.map.size(); i++){
            for(int j = 0; j<this.map.size();j++){
                insert(i,j);
            }
        }
    }
}
