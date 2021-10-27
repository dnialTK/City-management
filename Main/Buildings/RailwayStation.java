package Main.Buildings;

import Main.City;
import Main.Vehicles.Train;

import java.io.Serializable;
import java.util.ArrayList;

public class RailwayStation extends Terminal implements Serializable {

    private ArrayList<Train> Trains = new ArrayList<>();
    private final int InputRailsNumber;
    private final int OutputRailsNumber;

    public RailwayStation(double constructionCost, String cityName, String terminalName, String address, double area,
                          int vehiclesNumber, City getCity, int inputRailsNumber, int outputRailsNumber) {
        super(constructionCost, cityName, terminalName, address, area, vehiclesNumber, getCity);
        InputRailsNumber = inputRailsNumber;
        OutputRailsNumber = outputRailsNumber;
    }

    public ArrayList<Train> getTrains() {
        return Trains;
    }

}