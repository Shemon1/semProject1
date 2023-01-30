package java_gui;

import java.util.ArrayList;
import java_gui.new_customer;

public class customers {
    private ArrayList<Customer> customers;
    
    public customers() {
        customers = new ArrayList<>();
    }
    
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
}

class Customer {
    private int customerNumber;
    private String fullName;
    private int phoneNumber;
    private String address;
    private int zipCode;
    private String city;
    
    public Customer(int customerNumber, String fullName, int phoneNumber, String address, int zip, String city) {
        this.customerNumber = customerNumber;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.zipCode = zip;
        this.city = city;
    }
    
    // Getters for each field
    public String getName() {
        return fullName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public int getZip() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }
    
    
}

