
import java.util.ArrayList;
import java.util.HashMap;

public class hashMaps {
    private HashMap<String , ArrayList<BST>> data;
    public hashMaps(){
        this.data= new HashMap<String,ArrayList<BST>>();
    }
    public void put(String category, ArrayList<BST> trees){
        data.put(category,trees);
    }
    public ArrayList<BST> get(String category){
        return data.get(category);
    }
    public boolean containsKey(String category){
        return(data.containsKey(category));
    }
}
