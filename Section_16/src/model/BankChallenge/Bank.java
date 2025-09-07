package model.BankChallenge;

import model.BankChallenge.dto.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {

    public final int routingNumber;
    private static long lastTransactionId = 1;
    private final Map<String, BankCustomer> customers;

    public Bank(int routingNumber) {
        this.routingNumber = routingNumber;
        this.customers = new HashMap<>();
    }

    public BankCustomer getCustomer(String id){
        return customers.get(id);
    }

    public List<BankCustomer> getCustomers() {
        return new ArrayList<>(customers.values());
    }


    public boolean addCustomer(String name, double checkingInitialDeposit,
                               double savingsInitialDeposit){
        BankCustomer newAcc = new BankCustomer(name, checkingInitialDeposit, savingsInitialDeposit);
        if(customers.put(newAcc.getCustomerId(), newAcc) == null){
            return true;
        }
        return false;
    }

    public void doTransaction(String id, BankAccount.Type type, double amount){
        BankCustomer customer = customers.get(id);
        if(customer != null){
            BankAccount account = customer.getAccount(type);
            double oldAmount = customer.getAccount(type).getBalance();
            boolean successfullTransaction = account.commitTransaction(routingNumber, lastTransactionId++, id, amount);
            if(successfullTransaction){
                System.out.println(customer.getAccount(type).getBalance() > oldAmount ? "Deposit made" : "Withdrawal made");
            }
        }else{
            System.out.println("Invalid customer id");
        }
    }

    @Override
    public String toString() {
        return "Bank{" +
                "routingNumber=" + routingNumber +
                ", customers=" + customers +
                ", " + lastTransactionId + '}';
    }
}
