package model.challenge3;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>(5000);

    public Bank(String name) {
        this.name = name;
    }

    private Customer getCustomer(String name){
        for (var customer : customers){
            if(customer.name().equalsIgnoreCase(name)){
                return customer;
            }
        }
        System.out.printf("Customer %s wasn't found %n",name);
        return null;
    }

    public void addCustomer(String name, double deposit){
        if(getCustomer(name) == null){
            Customer customer = new Customer(name, deposit);
            customers.add(customer);
            System.out.println("Customer was added: " + customer);
            return;
        }
        System.out.println("This customer already exists.");
    }

    public void printStatement(Customer c){
        System.out.println(c.name() + "'s transactions: ");

        for (double credit : c.transactions()){
            System.out.println(credit);
        }
    }
}
