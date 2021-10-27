package Main.Buildings;

import Main.City;
import Main.Country;
import Main.Person;
import Main.Vehicles.CityBus;
import Main.Vehicles.PassengerPlane;
import Main.Vehicles.Vehicle;
import Travel.Safarebel;
import Travel.Travel;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

abstract public class Terminal implements Safarebel, Serializable {
    private final double ConstructionCost;
    private int VehiclesNumber;
    private final String CityName;
    private final String TerminalName;
    private final String Address;
    private final double Area;
    private final ArrayList<Person> Leaders = new ArrayList<>();
    private final ArrayList<Travel> inputTravels = new ArrayList<>();
    private final ArrayList<Travel> outputTravels = new ArrayList<>();
    private final City getCity;

    public Terminal(double constructionCost, String cityName, String terminalName, String address, double area,
                    int vehiclesNumber, City getCity) {
        ConstructionCost = constructionCost;
        CityName = cityName;
        TerminalName = terminalName;
        Address = address;
        Area = area;
        this.getCity = getCity;
        VehiclesNumber = 0;
    }

    public City getGetCity() {
        return getCity;
    }

    public double getConstructionCost() {
        return ConstructionCost;
    }

    public void AddVehiclesNumber() {
        VehiclesNumber += 1;
    }

    @Override
    public void newTravel(Terminal originTerminal, Terminal destinationTerminal, ArrayList<Person> Passengers, Person driver, Vehicle vehicle, int ID, String date, double cost) throws IOException {
        Travel travel = new Travel(originTerminal, destinationTerminal, Passengers, driver, vehicle, ID, date, cost);

        //add travel
        originTerminal.getOutputTravels().add(travel);
        destinationTerminal.getInputTravels().add(travel);

        //remove and add driver and vehicle
        originTerminal.getLeaders().remove(driver);
        destinationTerminal.getLeaders().add(driver);
        if (vehicle instanceof PassengerPlane) {
            ((Airport) originTerminal).getAirVehicles().remove((PassengerPlane) vehicle);
            ((Airport) destinationTerminal).getAirVehicles().add((PassengerPlane) vehicle);
        }
        if (vehicle instanceof CityBus) {
            ((BusTerminal) originTerminal).getCityBuses().remove((CityBus) vehicle);
            ((BusTerminal) destinationTerminal).getCityBuses().add((CityBus) vehicle);
        }

        //remove and add passengers and driver
        originTerminal.getGetCity().getPersons().remove(driver);
        destinationTerminal.getGetCity().getPersons().add(driver);
        for (Person passenger : Passengers) {
            originTerminal.getGetCity().getPersons().remove(passenger);
            destinationTerminal.getGetCity().getPersons().add(passenger);
        }

        //add cost to origin city money
        originTerminal.getGetCity().setMoney(travel.getCost());

        Country.outputFile(originTerminal.getGetCity().country);
    }

    @Override
    public void TravelSort() throws IOException {
        Collections.sort(getInputTravels());
        Collections.sort(getOutputTravels());
        Country.outputFile(getInputTravels().get(0).getOriginTerminal().getGetCity().country);
    }

    @Override
    public double TravelCost(ArrayList<Person> Passengers, Vehicle vehicle) {
        //5 in multiplication is payment for one passenger
        if (vehicle instanceof CityBus) {
            return ((Passengers.size() * 5) + 150);
        } else if (vehicle instanceof PassengerPlane) {
            return ((Passengers.size() * 5) + 400);
        }
        return 0;
    }

    @Override
    public void TravelHistory(String string) throws IOException {
        TravelSort();
        if (string.equals("Input")) {
            System.out.println("Input travels:");
            for (int i = 0; i < getInputTravels().size(); i++) {
                System.out.println("ID: " + getInputTravels().get(i).getID() + "\tDate: " + getInputTravels().get(i).getDate() + "\tCost" + getInputTravels().get(i).getCost());
            }
        } else if (string.equals("Output")) {
            System.out.println("Output travels:");
            for (int i = 0; i < getOutputTravels().size(); i++) {
                System.out.println("ID: " + getOutputTravels().get(i).getID() + "\tDate: " + getOutputTravels().get(i).getDate() + "\tCost" + getOutputTravels().get(i).getCost());
            }
        } else {
            System.out.println("Input travels:");
            for (int i = 0; i < getInputTravels().size(); i++) {
                System.out.println("ID: " + getInputTravels().get(i).getID() + "\tDate: " + getInputTravels().get(i).getDate() + "\tCost" + getInputTravels().get(i).getCost());
            }
            System.out.println("Output travels:");
            for (int i = 0; i < getOutputTravels().size(); i++) {
                System.out.println("ID: " + getOutputTravels().get(i).getID() + "\tDate: " + getOutputTravels().get(i).getDate() + "\tCost" + getOutputTravels().get(i).getCost());
            }
        }
        Country.outputFile(getInputTravels().get(0).getOriginTerminal().getGetCity().country);
    }

    public Vehicle getVehicle(int ID) {
        return null;
    }

    public ArrayList<Travel> getInputTravels() {
        return inputTravels;
    }

    public ArrayList<Travel> getOutputTravels() {
        return outputTravels;
    }

    public void showVehicle() {
    }

    public String getCityName() {
        return CityName;
    }

    public String getTerminalName() {
        return TerminalName;
    }

    public ArrayList<Person> getLeaders() {
        return Leaders;
    }

}
