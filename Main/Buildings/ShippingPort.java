package Main.Buildings;

import Main.City;
import Main.Vehicles.MarineVehicle;

import java.io.Serializable;
import java.util.ArrayList;

public class ShippingPort extends Terminal implements Serializable {

    private final ArrayList<MarineVehicle> MarineVehicles = new ArrayList<MarineVehicle>();
    private final int DocksNumber;

    public ShippingPort(double constructionCost, String cityName, String terminalName, String address, double area,
                        int vehiclesNumber, City getCity, int docksNumber) {
        super(constructionCost, cityName, terminalName, address, area, vehiclesNumber, getCity);
        DocksNumber = docksNumber;
    }

    public ArrayList<MarineVehicle> getMarineVehicles() {
        return MarineVehicles;
    }
}