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

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", customers=" + customers +
                '}';
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
    public void addTransaction(String name, double deposit){
        Customer customer = getCustomer(name);
        if(customer != null){
            customer.transactions().add(deposit);
        }
    }



    public void printStatement(String name){
        Customer customer = getCustomer(name);
        if(customer == null){
            return;
        }
        System.out.println("-".repeat(30));
        System.out.println(customer.name() + "'s transactions: ");

        for (double credit : customer.transactions()){
            System.out.printf("$%10.2f (%s)%n", credit, credit < 0 ? "debit" : "credit");
        }
    }
}
