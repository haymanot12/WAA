package mvc;

public class ShoppingCart {

    private int quantity;
    private String number;
    private String name;
    private double price;
    private double total;

    public ShoppingCart() {
    }

    public ShoppingCart(int quantity,String number, String name,double price, double total) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity(){return quantity;  }

    public void setQuantity(int quantity){this.quantity = quantity;}
}
