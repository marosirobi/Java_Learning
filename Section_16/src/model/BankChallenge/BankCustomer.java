package model.BankChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankCustomer {

    private static int LAST_ID = 10_000_000;

    private final String name;
    private final int id;
    private final List<BankAccount> accounts = new ArrayList<>();

    //package private
    BankCustomer(String name, double checkingAmount, double savingsAmount) {
        this.name = name;
        accounts.add(new BankAccount(BankAccount.Type.CHECKING,checkingAmount));
        accounts.add(new BankAccount(BankAccount.Type.SAVINGS,savingsAmount));
        this.id = LAST_ID++;
    }

    public String getName() {
        return name;
    }

    public List<BankAccount> getAccounts() {
        return new ArrayList<>(accounts);
    }

    public String getCustomerId() {
        return "%015d".formatted(id);
    }

    public BankAccount getAccount(BankAccount.Type type){
        for(BankAccount b : accounts){
            if(b.getAccountType() == type)
                return b;
        }
        return null;
    }

    @Override
    public String toString() {

        String[] accountStrings = new String[accounts.size()];
        Arrays.setAll(accountStrings, i -> accounts.get(i).toString());
        return "Customer: %s (id:%015d)%n\t%s%n".formatted(name, id, String.join("\n\t",accountStrings));
    }
}
