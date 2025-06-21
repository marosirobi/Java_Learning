package model.challenge3;

import java.util.ArrayList;

record Customer(String name, ArrayList<Double> transactions) {

    public Customer(String name, double amount) {
        this(name.toUpperCase(), new ArrayList<Double>(500));
        transactions.add(amount);
    }

}
