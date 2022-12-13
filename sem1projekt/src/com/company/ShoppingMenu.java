package com.company;

import java.util.List;
import java.util.Vector;

public class ShoppingMenu {
    public ShoppingMenu(){
        System.out.println("Greetings customer");
        productList=new Vector<Product>() ;
        productList.add(new Product(0.6f, 500, "planks"));
        productList.add(new Product(1, 300, "bricks"));
        productList.add(new Product(2, 500, "nails"));
        productList.add(new Product(3, 300, "bolts"));
        productList.add(new Product(0.3f, 600, "clay"));
        productList.add(new Product(100, 505, "industrial vacuum cleaner"));
        productList.add(new Product(110, 303, "power washer"));
        for (int a = 0 ; a < productList.size() ; a++) {
            System.out.println("| stock: " + productList.get(a).numberInStock + "\t| " + productList.get(a).price + "\t | - " + productList.get(a).name.toUpperCase() + " |");
        }
    }
    public Vector<Product> productList;
}
