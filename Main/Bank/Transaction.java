package Main.Bank;

import Main.City;

import java.io.Serializable;

public class Transaction implements Serializable {
    private final double Amount;
    private final TransactionType transactionType;
    private final String Time;
    public Bank bank;
    public City city;

    public Transaction(double amount, TransactionType transactionType, String time, Bank bank, City city) {
        Amount = amount;
        this.transactionType = transactionType;
        Time = time;
        this.bank = bank;
        this.city = city;
    }

    public void PrintTransaction() {
        System.out.print("Amount:");
        System.out.printf("%.2f", Amount);
        System.out.println("\tTime:" + Time + "\tType:" + transactionType + "\n--------------------");
    }

    public enum TransactionType {
        Profit, Deposit, Withdraw;
    }
}
