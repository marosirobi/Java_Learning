package model.exercise3;

import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String name, double deposit){
        if(findCustomer(name) == null){
            var newCustomer = new Customer(name, deposit);
            customers.add(newCustomer);
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String name, double transaction){
        var c = findCustomer(name);
        if(c != null){
            c.addTransaction(transaction);
            return true;
        }
        return false;
    }

    private Customer findCustomer(String name){
        for(var c : customers){
            if(c.getName().equalsIgnoreCase(name))
                return c;
        }
        return null;
    }
}
