package model.BankChallenge;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    public static void main(String[] args) {

        BankCustomer customer = new BankCustomer("Ann", 2440,2500);
        System.out.println(customer);

        List<BankAccount> accounts = customer.getAccounts();
        accounts.clear();
        System.out.println(customer);
        accounts.add(new BankAccount(BankAccount.Type.SAVINGS,25555));
        System.out.println(customer);

    }
}
