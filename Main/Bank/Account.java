package Main.Bank;

import Main.City;
import Main.Country;
import Main.Main;
import Main.Person;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Account implements Serializable, Runnable {
    private final ArrayList<Transaction> Transactions = new ArrayList<>();
    private final Person Owner;
    private final String UserName;
    private final String Password;
    public Country country;
    public Bank bank;
    public City city;
    private double Cash;
    private double TimeToProfit;

    public Account(double cash, Person owner, String userName, String password, Country country, Bank bank, City city) throws IOException {
        Cash = cash;
        Owner = owner;
        UserName = userName;
        Password = password;
        this.city = city;
        this.bank = bank;
        this.country = country;
        TimeToProfit = 60;
        Thread thread = new Thread(this);
        thread.start();
        Country.outputFile(this.country);
    }

    public double getCash() {
        return Cash;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void Deposit(double amount) {
        Cash += amount;
    }

    public void Withdraw(double amount) {
        Cash -= amount;
    }

    public ArrayList<Transaction> getTransactions() {
        return Transactions;
    }

    @Override
    public void run() {
        //noinspection InfiniteLoopStatement
        while (true) {
            try {
                for (int i = 0; i < 60; i++) {
                    Thread.sleep(1000);
                    TimeToProfit--;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            double profit = (18 / (double) 100) * Cash;
            Cash += profit;
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd   HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            Transaction transaction1 = new Transaction(profit, Transaction.TransactionType.Profit, dtf.format(now), this.bank, this.city);
            Transactions.add(transaction1);
            this.bank.setCirculationMoney(Cash);

            if (Main.isEntered) {
                Object[] objects = {Owner.getName(), Owner.getFamily(), Owner.getIDPersonal(), (int) this.bank.getCirculationMoney(), this.bank.getName(), this.city.getName(), (int) profit, dtf.format(now)};
                Main.financialManagement.defaultTableModel.addRow(objects);
                Main.financialManagement.label1.setText(String.valueOf(country.AllMoney()));
            }
        }
    }

    public double getTimeToProfit() {
        return TimeToProfit;
    }

    public void setTimeToProfit(double timeToProfit) {
        TimeToProfit = timeToProfit;
    }
}
