package org.example;

public class Product {
    String prodName;
    int price;
    int quantity;

    public Product(){
        prodName="Temp";
        price=0;
        quantity=1;
    }
    public Product(String name,int p,int q){
        this.prodName=name;this.price=p;this.quantity=q;
    }

    public int getPrice(){
        return price;
    }
    int getQuantity(){
        return quantity;
    }
}
