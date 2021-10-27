package Main.Bank;

import java.io.Serializable;
import java.util.ArrayList;

public class Bank implements Serializable {
    private final ArrayList<Account> Accounts = new ArrayList<>();
    private final String Name;
    private double CirculationMoney = 0;
    private int ActiveAccounts = 0;

    public Bank(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public double getCirculationMoney() {
        return CirculationMoney;
    }

    public int getActiveAccounts() {
        return ActiveAccounts;
    }

    public ArrayList<Account> getAccounts() {
        return Accounts;
    }

    public void setActiveAccounts() {
        ActiveAccounts++;
    }

    public void setCirculationMoney(double circulationMoney) {
        CirculationMoney += circulationMoney;
    }
}
