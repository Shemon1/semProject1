package java_gui;

import java.util.ArrayList;
import java_gui.NewCustomer;

public class Customers {
    private ArrayList<Customer> customers;
    
    public Customers() {
        customers = new ArrayList<>();
    }
    
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    
    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}

class Customer {
    private int customerNumber;
    private String fullName;
    private String phoneNumber;
    private String address;
    private String zipCode;
    private String city;
    
    public Customer(int customerNumber, String fullName, String phoneNumber, String address, String zip, String city) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getZip() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }
    
    
}

