package Main.Buildings;

import Main.City;
import Main.Vehicles.AirVehicle;
import Main.Vehicles.Vehicle;

import java.io.Serializable;
import java.util.ArrayList;

public class Airport extends Terminal implements Serializable {

    private ArrayList<AirVehicle> AirVehicles = new ArrayList<>();
    private final String AirportType;
    private final int RunwaysNumber;

    public Airport(double constructionCost, String cityName, String terminalName, String address, double area,
                   int vehiclesNumber, City getCity, String airportType, int runwaysNumber) {
        super(constructionCost, cityName, terminalName, address, area, vehiclesNumber, getCity);
        AirportType = airportType;
        RunwaysNumber = runwaysNumber;
    }

    @Override
    public Vehicle getVehicle(int ID) {
        for (int i = 0; i < getAirVehicles().size(); i++) {
            if (getAirVehicles().get(i).getID() == ID) {
                return getAirVehicles().get(i);
            }
        }
        return null;
    }

    @Override
    public void showVehicle() {
        for (int i = 0; i < getAirVehicles().size(); i++) {
            System.out.println(getAirVehicles().get(i).getClass().getSimpleName() + "\tID: " + getAirVehicles().get(i).getID() + "\tCapacity: " + getAirVehicles().get(i).getCapacity());
        }
    }

    @Override
    public String toString() {
        return "Airport{" +
                "AirVehicles=" + AirVehicles +
                '}';
    }

    public ArrayList<AirVehicle> getAirVehicles() {
        return AirVehicles;
    }

}