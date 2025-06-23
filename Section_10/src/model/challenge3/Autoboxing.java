package model.challenge3;

public class Autoboxing {

    public static void main(String[] args) {

        Customer Bob = new Customer("Bob S",1000.0);
        System.out.println(Bob);

        Bank bank = new Bank("Chase");
        bank.addCustomer("Jane A",500.0);
        System.out.println(bank);

        bank.addTransaction("Jane A", -10.25);
        bank.addTransaction("Jane A", -66.25);

        bank.printStatement("Jane A");

        bank.addCustomer("Bob S", 25);
        bank.addTransaction("Bob S", -50.4);
        bank.printStatement("Bob S");
    }
}
