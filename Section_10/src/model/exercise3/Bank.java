package model.exercise3;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branch) {

        if (findBranch(branch) == null) {
            branches.add(new Branch(branch));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double deposit){
        if(findBranch(branchName) != null){
            var branch = findBranch(branchName);
            if(branch.newCustomer(customerName,deposit)){
                return true;
            }
        }
        return false;

    }

    public boolean addCustomerTransaction(String branchName, String customerName,double deposit){
        if(findBranch(branchName) != null){
            var branch = findBranch(branchName);
            if(branch.addCustomerTransaction(customerName,deposit)){
                return true;
            }
        }
        return false;

    }

    public boolean listCustomers(String name, boolean printTrans){
        if(findBranch(name) != null){
            var branch = findBranch(name);
            var customers = branch.getCustomers();

            System.out.printf("Customer details for branch %s%n", branch.getName());
            int index = 1;
            for(var c : customers){
                System.out.printf("Customer: %s[%d]%n", c.getName(), index);
                if(printTrans) {
                    System.out.printf("Transactions%n");
                    for (int i = 0; i < c.getTransactions().size(); i++) {
                        System.out.printf("[%d] Amount %.2f%n", i+1, c.getTransactions().get(i));
                    }
                }
                index++;
            }
            return true;
        }
        return false;
    }

    private Branch findBranch(String name){
        for(var b : branches){
            if(b.getName().equals(name)){
                return b;
            }
        }
        return null;
    }

}
