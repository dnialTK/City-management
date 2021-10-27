package Main.Buildings;

import Main.City;
import Main.Vehicles.CityBus;
import Main.Vehicles.Vehicle;

import java.io.Serializable;
import java.util.ArrayList;

public class BusTerminal extends Terminal implements Serializable {

    private final ArrayList<CityBus> CityBuses = new ArrayList<>();

    public BusTerminal(double constructionCost, String cityName, String terminalName, String address, double area,
                       int vehiclesNumber, City getCity) {
        super(constructionCost, cityName, terminalName, address, area, vehiclesNumber, getCity);
    }

    public ArrayList<CityBus> getCityBuses() {
        return CityBuses;
    }

    @Override
    public void showVehicle() {
        for (int i = 0; i < getCityBuses().size(); i++) {
            System.out.println(getCityBuses().get(i).getClass().getSimpleName() + "\tID: " + getCityBuses().get(i).getID() + "\tCapacity: " + getCityBuses().get(i).getCapacity() + "\tColor: " + getCityBuses().get(i).getColor());
        }
    }

    @Override
    public Vehicle getVehicle(int ID) {
        for (int i = 0; i < getCityBuses().size(); i++) {
            if (getCityBuses().get(i).getID() == ID) {
                return getCityBuses().get(i);
            }
        }
        return null;
    }
}