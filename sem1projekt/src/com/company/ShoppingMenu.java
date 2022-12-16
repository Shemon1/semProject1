package com.company;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class ShoppingMenu {
    public Vector<Product> productList;
    public Vector<Order> orderList;

    public ShoppingMenu() {
        System.out.println("Greetings customer");
        orderList = new Vector<Order>(); // Defined in Order.java
        productList = new Vector<Product>(); // Defined in Product.java
        productList.add(new Product(0.6f, 500, "planks"));
        productList.add(new Product(1, 300, "bricks"));
        productList.add(new Product(2, 500, "nails"));
        productList.add(new Product(3, 300, "bolts"));
        productList.add(new Product(0.3f, 600, "clay"));
        productList.add(new Product(100, 505, "industrial vacuum cleaner"));
        productList.add(new Product(110, 303, "power washer"));

        menu();
    }

    public void createOrder() {
        boolean customerExists = false;
        System.out.println("Hello there, are you an existing customer?");
        boolean validInput = false;
        while (!validInput) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("Are you an existing customer? Please write Y for yes, or N for no:");
                String userInput = input.nextLine().toLowerCase();
                if (userInput.equals("y") || userInput.equals("n")) {
                    validInput = true;
                    customerExists = userInput.equals("y"); // fancier way of seeing if user writes y or n
                } else {
                    throw new InputMismatchException("Please write either y or n.");
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
        if (customerExists) {
            String userName = "fancy pans"; // TODO delete this later
            System.out.println("Welcome " + userName + "!");
            System.out.println("Please tell us what you would like to order today! :)");
        } else {
            boolean accountCreation = false;
            validInput = false;
            while (!validInput) {
                try {
                    Scanner input = new Scanner(System.in);
                    System.out.println("Would like to create an account? Please write Y for yes, or N for no:");
                    String userInput = input.nextLine().toLowerCase();
                    if (userInput.equals("y") || userInput.equals("n")) {
                        validInput = true;
                        accountCreation = userInput.equals("y"); // fancier way of seeing if user writes y or n
                    } else {
                        throw new InputMismatchException("Please write either y or n.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println(e.getMessage());
                }
            }
            int customerId = 0;

            if (accountCreation) {

                // TODO: create account
            }
            System.out.println("Which product would you like to order?");
            for (int a = 0; a < productList.size(); a++) { // for loop, iterates through each item in stock
                System.out.println((a + 1) + ". | stock: " + productList.get(a).numberInStock + "\t| " +
                        productList.get(a).price + "\t | - " + productList.get(a).name.toUpperCase() + " |"); // We add 1 here for visuals
            }
            boolean correctInput = false;
            int userChoice = 0;
            Product selectedProduct = null;

            while (!correctInput) {

                Scanner myObj = new Scanner(System.in);  // Create a Scanner object (user input)
                System.out.println("Please input a number from 1 to " + productList.size() + ".");
                try { // Try-catch error, throws an error if below is not matched

                    userChoice = myObj.nextInt();  // Read user input
                    if (userChoice > productList.size() || userChoice < 1) {
                        throw new InputMismatchException();
                    } else {
                        correctInput = true;
                        selectedProduct = productList.get(userChoice - 1); // We subtract 1 here because we have visually added 1 earlier
                    }
                } catch (InputMismatchException e) {
                    System.out.println("You have to write an integer (1-" + productList.size() + ").");
                }
            }

            System.out.println("Order created for " + selectedProduct.name + ". ");  // Output user input
            LocalDateTime date = LocalDateTime.now();
            orderList.add(new Order(selectedProduct, customerId, date)); // Creates one order and adds it to the list of orders


        }
        menu(); // returns to menu, otherwise would just close and end application
    }

    public void cancelOrder() {
        for (int a = 0; a < orderList.size(); a++) { // TODO explain this
            Order thisOrder = orderList.get(a);
            System.out.println("Name of the product: " + thisOrder.product.name +
                    " | Customer ID: " + thisOrder.customerId +
                    " | Date of order: " + thisOrder.date.toString());
        }
        menu();

    }

    public void reviewStorage() {
        for (int a = 0; a < productList.size(); a++) { // for loop, iterates through each item in stock
            System.out.println("| stock: " + productList.get(a).numberInStock + "\t| " + productList.get(a).price +
                    "\t | - " + productList.get(a).name.toUpperCase() + " |");
        }
        menu();
    }

    public void cashierLogin() {

    }

    public void accountMenu() {

    }

    public void menu() {
        System.out.println("Welcome to the menu for order creation.");
        System.out.println("Please select what you would like to do:");
        System.out.println("1. Create a new order.");
        System.out.println("2. Cancel an order.");
        System.out.println("3. Review storage.");
        System.out.println("4. Cashier login.");
        System.out.println("5. Account menu.");

        boolean correctInput = false;
        int userChoice = 0;

        while (!correctInput) {

            Scanner myObj = new Scanner(System.in);  // Create a Scanner object (user input)
            System.out.println("Please input a number from 1 to 5.");
            try { // Try-catch error, throws an error if below is not matched

                userChoice = myObj.nextInt();  // Read user input
                if (userChoice > 5 || userChoice < 1) {
                    throw new InputMismatchException();
                } else {
                    correctInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("You have to write an integer (1-5).");
            }
        }

        System.out.println("You wrote: " + userChoice);  // Output user input

        switch (userChoice) { // switch case
            case 1:
                createOrder();
                break;
            case 2:
                cancelOrder();
                break;
            case 3:
                reviewStorage();
                break;
            case 4:
                cashierLogin();
                break;
            case 5:
            default:
                accountMenu();
                break;
        }
    }


}
