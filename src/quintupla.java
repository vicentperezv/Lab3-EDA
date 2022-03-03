public class quintupla {
    private String name;
    private String category;
    private int quantity;
    private double stars;
    private double max_price;


    public quintupla(String nombre, String categoria, double stars, double max_price){
        this.name = nombre;
        this.category = categoria;
        this.quantity = 1;
        this.stars=stars;
        this.max_price=max_price;
    }
    public String getName(){
        return this.name;
    }
    public String getCategory(){
        return this.category;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public double getStars(){
        return this.stars;
    }
    public double getMax_price(){
        return this.max_price;
    }
    public void incQuantity(double stars, double max_price){
        double aux = this.stars*this.quantity;
        double aux2= this.max_price*this.quantity;
        this.quantity = this.quantity + 1;
        this.stars=(aux +stars)/this.quantity;
        this.max_price=(aux2 + max_price)/this.quantity;


    }
}
