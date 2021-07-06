package mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {

    private int quantity;
    private String number;
    private String name;
    private double price;
    private double total;
    //public static double totalSum =0.0;
    //public static Map<String, ShoppingCart> cartList= new HashMap<>();

    public ShoppingCart() {
    }

    public ShoppingCart(String number, String name,double price){// Map<String,ShoppingCart>p) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.quantity++;
        this.setTotal();
        //this.cartList = p;
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

    public double getTotal(){ return total;}

    public void setTotal() { this.total = this.price*this.quantity; }

    public static double total(Map<String, ShoppingCart> cartlist){
        double totalSum = 0.0;
    for(ShoppingCart c : cartlist.values()){
            totalSum+=c.getTotal();
        }
        return totalSum;
    }
}
