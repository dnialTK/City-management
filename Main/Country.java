package Main;

import java.io.*;
import java.util.ArrayList;

public class Country implements Serializable {
    private final ArrayList<City> Cities = new ArrayList<>();
    private int allPopulation = 0;
    private double allAvailableMoney = 0;

    public static void outputFile(Country country) throws IOException {
        File file = new File("file.txt");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(country);
        oos.close();
        fos.close();
    }

    public ArrayList<City> getCities() {
        return Cities;
    }

    public void addCity(String name, double money) throws IOException {
        City city = new City(name, money, this);
        Cities.add(city);
        Country.outputFile(this);
    }

    public void addCity(City city) throws IOException {
        Cities.add(city);
        Country.outputFile(this);
    }

    public void PrintCountry() {
        for (int i = 0; i < getCities().size(); i++) {
            System.out.println((i + 1) + "-" + getCities().get(i).getName() + "\tPopulation:" + getCities().get(i).getPopulation() + "\t\tAvailable money:" + getCities().get(i).getAvailableMoney());
        }
    }

    public void PrintCountryCities() {
        for (int i = 0; i < getCities().size(); i++) {
            System.out.println((i + 1) + "-" + getCities().get(i).getName());
        }
    }

    public void setPopulation() {
        for (City city : Cities) {
            allPopulation += city.getPopulation();
        }
    }

    public void setMoney() {
        for (City city : Cities) {
            allAvailableMoney += city.getAvailableMoney();
        }
    }

    public void PrintInfo() {
        System.out.println("\nMoney:" + allAvailableMoney + "\tNumber of cities:" + Cities.size() + "\tPopulation:" + allPopulation);
    }

    public double AllMoney() {
        double allMoney = 0;
        for (City city : Cities) {
            for (int j = 0; j < city.getBanks().size(); j++) {
                for (int k = 0; k < city.getBanks().get(j).getAccounts().size(); k++) {
                    allMoney += city.getBanks().get(j).getAccounts().get(k).getCash();
                }
            }
        }
        return allMoney;
    }
}