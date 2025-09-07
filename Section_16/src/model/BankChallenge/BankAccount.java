package model.BankChallenge;

import model.BankChallenge.dto.Transaction;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class BankAccount {

    public enum Type{
        CHECKING, SAVINGS
    }

    private final Type accountType;
    private double balance;
    private final Map<Long, Transaction> transactions = new HashMap<>();

    BankAccount(Type accountType, double balance) {
        this.accountType = accountType;
        this.balance = balance;
    }

    public Map<Long, String> getTransactions() {
        Map<Long, String> txMap = new LinkedHashMap<>();
        for(var tx : transactions.entrySet()){
            txMap.put(tx.getKey(),tx.getValue().toString());
        }
        return txMap;
    }

    public Type getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    boolean commitTransaction(int routingNumber, long TransactionId, String customerId, double amount){
        double balanceCopy = balance;
        if(balanceCopy + amount >= 0){
            balance += amount;
            Transaction newTransaction = new Transaction(routingNumber,Integer.parseInt(customerId),TransactionId,amount);
            transactions.put(newTransaction.getTransactionId(), newTransaction);
//            System.out.println(newTransaction.getTransactionId());
            return true;
        }else if(balanceCopy + amount < 0){
            System.out.println("You cant go under $0.00");
        }
        return false;
    }

    @Override
    public String toString() {
        return "%s $%.2f".formatted(accountType,balance);
    }
}
