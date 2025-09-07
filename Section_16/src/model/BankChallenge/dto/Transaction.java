package model.BankChallenge.dto;

import model.BankChallenge.BankCustomer;

public class Transaction {

    private final int routingNumber;
    private final int customerId;
    private final long transactionId;
    private final double transactionAmount;

    public Transaction(int routingNumber, int customerId, long transactionId, double transactionAmount) {
        this.routingNumber = routingNumber;
        this.customerId = customerId;
        this.transactionId = transactionId;
        this.transactionAmount = transactionAmount;
    }

    public int getRoutingNumber() {
        return routingNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }


    @Override
    public String toString() {
        return "%015d:%020d:%015d:%012.2f".formatted(routingNumber,customerId,transactionId,transactionAmount);
    }
}
