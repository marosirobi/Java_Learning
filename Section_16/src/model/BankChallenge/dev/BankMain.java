package model.BankChallenge.dev;

import model.BankChallenge.Bank;
import model.BankChallenge.BankAccount;
import model.BankChallenge.BankCustomer;
import model.BankChallenge.dto.Transaction;

import java.util.List;
import java.util.Map;

public class BankMain {
    public static void main(String[] args) {

//        BankCustomer customer = new BankCustomer("Ann", 2440,2500);
//        System.out.println(customer);
//
//        List<BankAccount> accounts = customer.getAccounts();
//        accounts.clear();
//        System.out.println(customer);
//        accounts.add(new BankAccount(BankAccount.Type.SAVINGS,25555));
//        System.out.println(customer);
//        System.out.println("------------------------------------");
//        Transaction newTrans = new Transaction();
        Bank bank = new Bank(1);
        bank.addCustomer("Ann", 2440,2500);
//        System.out.println(bank);

        List<BankCustomer> customers = bank.getCustomers();
        BankCustomer customer = null;
        for(BankCustomer c : customers){
            if(c.getName().equals("Ann"))
                customer = c;
        }
        bank.doTransaction(customer.getCustomerId(), BankAccount.Type.SAVINGS, 6000);
        bank.doTransaction(customer.getCustomerId(), BankAccount.Type.SAVINGS, -40060);

        Map<Long, String> transactions = customer.getAccount(BankAccount.Type.SAVINGS).getTransactions();
        List<BankAccount> accounts = customer.getAccounts();

        System.out.println(customer.getAccounts());
        accounts.clear();
        System.out.println(customer.getAccounts());

//        System.out.println(bank.getCustomers());
//        customers.clear();
//        System.out.println(bank.getCustomers());
//        System.out.println(customer);
//        transactions.put(3L, new Transaction(1,1, Integer.parseInt(customer.getCustomerId()), 500));
        transactions.forEach((k,v) -> System.out.println(k + " : " + v));

        System.out.println("-------------------------");



    }
}
