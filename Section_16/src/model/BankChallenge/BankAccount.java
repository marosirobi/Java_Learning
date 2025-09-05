package model.BankChallenge;

public class BankAccount {

    enum Type{
        CHECKING, SAVINGS
    }

    private final Type accountType;
    private  final double balance;

    public BankAccount(Type accountType, double balance) {
        this.accountType = accountType;
        this.balance = balance;

    }

    public Type getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "%s $%.2f".formatted(accountType,balance);
    }
}
