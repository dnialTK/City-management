package Main;

import Main.Bank.Bank;
import Main.Buildings.*;
import Main.Vehicles.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class City implements Serializable {

    private final String Name;
    private final ArrayList<Person> Persons = new ArrayList<>();
    private final ArrayList<Hotel> Hotels = new ArrayList<>();
    private final ArrayList<Terminal> Terminals = new ArrayList<>();
    private final ArrayList<Bank> Banks = new ArrayList<>();
    public Country country;
    private int Population;
    private double AvailableMoney;

    public City(String Name, double AvailableMoney, Country country) {
        this.Name = Name;
        this.AvailableMoney = AvailableMoney;
        this.country = country;
    }

    public Person checkPerson(int id) {
        for (Person x : getPersons()) {
            if (x.getIDPersonal() == id) {
                return x;
            }
        }
        return null;
    }

    public String getName() {
        return Name;
    }

    public void AddBank(String Name) throws IOException {
        Bank bank = new Bank(Name);
        Banks.add(bank);
        System.out.println("Bank added!");
        Country.outputFile(country);
    }

    public void AddHotel(Hotel hotel) throws IOException {
        if (getAvailableMoney() > hotel.getConstructionCost()) {
            Hotels.add(hotel);
            Paymoney(hotel.getConstructionCost());
            System.out.println("Added successfully!");
        } else {
            System.out.println("AvailableMoney is not enough!");
        }
        Country.outputFile(country);
    }

    public void AddBusTerminal(BusTerminal busTerminal) throws IOException {
        if (getAvailableMoney() > busTerminal.getConstructionCost()) {
            Terminals.add(busTerminal);
            Paymoney(busTerminal.getConstructionCost());
            System.out.println("Added successfully!");
        } else {
            System.out.println("AvailableMoney is not enough!");
        }
        Country.outputFile(country);
    }

    public void AddAirport(Airport airport) throws IOException {
        if (getAvailableMoney() > airport.getConstructionCost()) {
            Terminals.add(airport);
            Paymoney(airport.getConstructionCost());
            System.out.println("Added successfully!");
        } else {
            System.out.println("AvailableMoney is not enough!");
        }
        Country.outputFile(country);
    }

    public void AddShippingPort(ShippingPort shippingPort) throws IOException {
        if (getAvailableMoney() > shippingPort.getConstructionCost()) {
            Terminals.add(shippingPort);
            Paymoney(shippingPort.getConstructionCost());
            System.out.println("Added successfully!");
        } else {
            System.out.println("AvailableMoney is not enough!");
        }
        Country.outputFile(country);
    }

    public void AddRailwayStation(RailwayStation railwayStation) throws IOException {
        if (getAvailableMoney() > railwayStation.getConstructionCost()) {
            Terminals.add(railwayStation);
            Paymoney(railwayStation.getConstructionCost());
            System.out.println("Added successfully!");
        } else {
            System.out.println("AvailableMoney is not enough!");
        }
        Country.outputFile(country);
    }

    public void BuyBus(CityBus cityBus, BusTerminal busTerminal) throws IOException {
        if (getAvailableMoney() > cityBus.getPurchasePrice()) {
            busTerminal.getCityBuses().add(cityBus);
            busTerminal.AddVehiclesNumber();
            Paymoney(cityBus.getPurchasePrice());
            System.out.println("Bought successfully!");
        } else {
            System.out.println("AvailableMoney is not enough!");
        }
        Country.outputFile(country);
    }

    public void BuyPassengerPlane(PassengerPlane passengerPlane, Airport airport) throws IOException {
        if (getAvailableMoney() > passengerPlane.getPurchasePrice()) {
            airport.getAirVehicles().add(passengerPlane);
            airport.AddVehiclesNumber();
            Paymoney(passengerPlane.getPurchasePrice());
            System.out.println("Bought successfully!");
        } else {
            System.out.println("AvailableMoney is not enough!");
        }
        Country.outputFile(country);
    }

    public void BuyCargoPlane(CargoPlane cargoPlane, Airport airport) throws IOException {
        if (getAvailableMoney() > cargoPlane.getPurchasePrice()) {
            airport.getAirVehicles().add(cargoPlane);
            airport.AddVehiclesNumber();
            Paymoney(cargoPlane.getPurchasePrice());
            System.out.println("Bought successfully!");
        } else {
            System.out.println("AvailableMoney is not enough!");
        }
        Country.outputFile(country);
    }

    public void BuyTrain(Train train, RailwayStation railwayStation) throws IOException {
        if (getAvailableMoney() > train.getPurchasePrice()) {
            railwayStation.getTrains().add(train);
            railwayStation.AddVehiclesNumber();
            Paymoney(train.getPurchasePrice());
            System.out.println("Bought successfully!");
        } else {
            System.out.println("AvailableMoney is not enough!");
        }
        Country.outputFile(country);
    }

    public void BuyShip(Ship ship, ShippingPort shippingPort) throws IOException {
        if (getAvailableMoney() > ship.getPurchasePrice()) {
            shippingPort.getMarineVehicles().add(ship);
            shippingPort.AddVehiclesNumber();
            Paymoney(ship.getPurchasePrice());
            System.out.println("Bought successfully!");
        } else {
            System.out.println("AvailableMoney is not enough!");
        }
        Country.outputFile(country);
    }

    public void BuyBoat(Boat boat, ShippingPort shippingPort) throws IOException {
        if (getAvailableMoney() > boat.getPurchasePrice()) {
            shippingPort.getMarineVehicles().add(boat);
            shippingPort.AddVehiclesNumber();
            Paymoney(boat.getPurchasePrice());
            System.out.println("Bought successfully!");
        } else {
            System.out.println("AvailableMoney is not enough!");
        }
        Country.outputFile(country);
    }

    public void BuyPerson(Person person) throws IOException {
        Persons.add(person);
        Country.outputFile(country);
    }

    public void BuyRoom(Hotel hotel, Room room) throws IOException {
        if (getAvailableMoney() > room.getAccommodationPrice()) {
            hotel.getRooms().add(room);
            Paymoney(room.getAccommodationPrice());
            System.out.println("Bought successfully!");
        } else {
            System.out.println("AvailableMoney is not enough!");
        }
        Country.outputFile(country);
    }

    public void AddService1(Hotel hotel, int service) throws IOException {
        if (getAvailableMoney() > 300) {
            hotel.getServices().add(Hotel.HotelFacilities.values()[service - 1]);
            Paymoney(300);
            System.out.println("Added successfully!");
        } else {
            System.out.println("AvailableMoney is not enough!");
        }
        Country.outputFile(country);
    }

    public void AddService2(Hotel hotel) throws IOException {
        if (getAvailableMoney() > 500) {
            hotel.getServices().add(Hotel.HotelFacilities.values()[0]);
            hotel.getServices().add(Hotel.HotelFacilities.values()[1]);
            Paymoney(500);
            System.out.println("Added successfully!");
        } else {
            System.out.println("AvailableMoney is not enough!");
        }
        Country.outputFile(country);
    }

    public int getPopulation() {
        return getPersons().size();
    }

    public double getAvailableMoney() {
        return AvailableMoney;
    }

    public ArrayList<Person> getPersons() {
        return Persons;
    }

    public ArrayList<Hotel> getHotels() {
        return Hotels;
    }

    public ArrayList<Terminal> getTerminals() {
        return Terminals;
    }

    public Terminal getTerminalsName(String TerminalName) {
        for (int i = 0; i < getTerminals().size(); i++) {
            if (getTerminals().get(i).getTerminalName().equals(TerminalName))
                return getTerminals().get(i);
        }
        return null;
    }

    public void setMoney(double Money) throws IOException {
        AvailableMoney += Money;
        Country.outputFile(country);
    }

    public void Paymoney(double Money) throws IOException {
        AvailableMoney -= Money;
        Country.outputFile(country);
    }

    public Boolean atWork(Person person, City city) {
        for (int i = 0; i < city.getTerminals().size(); i++) {
            for (int j = 0; j < city.getTerminals().get(i).getLeaders().size(); j++) {
                if (city.getTerminals().get(i).getLeaders().get(j).getIDPersonal() == person.getIDPersonal())
                    return true;
            }
        }
        return false;
    }

    public void AddLeader(int ID, Terminal terminal) throws IOException {
        for (int i = 0; i < terminal.getGetCity().getPersons().size(); i++) {
            if (ID == terminal.getGetCity().getPersons().get(i).getIDPersonal()) {
                terminal.getLeaders().add(terminal.getGetCity().getPersons().get(i));
                System.out.println("Added successfully!");
                break;
            }
        }
        Country.outputFile(country);
    }

    public void PrintPerson(String string) {
        for (int i = 0; i < getPersons().size(); i++) {
            if (getPersons().get(i).getJob().equals(string)) {
                System.out.println("Name: " + getPersons().get(i).getName() + "\tFamily: "
                        + getPersons().get(i).getFamily() + "\tBirthDate: "
                        + getPersons().get(i).getBirthDate() + "\tBirthPlace: "
                        + getPersons().get(i).getBirthPlace() + "\tJob: " + getPersons().get(i).getJob()
                        + "\tGender: " + getPersons().get(i).getGender() + "\tPersonal ID: "
                        + getPersons().get(i).getIDPersonal());
            }
        }
    }

    public void PrintBanks() {
        for (int i = 0; i < Banks.size(); i++) {
            System.out.println((i + 1) + "-Name:" + Banks.get(i).getName());
            System.out.println("-------------------------------------");
        }
    }

    public void SetPerson() throws IOException {
        Person p1 = new Person("Ali", "Kabiri", "1991/12/06", "Isfahan", "Sailor", "Male", 11, 150);
        Person p2 = new Person("Alireza", "Hassani", "1994/07/06", "Tehran", "Pilot", "Male", 12, 250);
        Person p3 = new Person("Mohammad", "Ahmadi", "1984/07/09", "Shiraz", "Bus driver", "Male", 13, 100);
        Person p4 = new Person("Reza", "Hamidi", "1998/01/25", "Mashhad", "Crew", "Male", 14, 50);
        Person p5 = new Person("Ehsan", "Arbabi", "1996/03/15", "Tabriz", "Locomotives", "Male", 15, 150);
        Person p6 = new Person("Ali akbar", "Mahmoodi", "1990/10/06", "Isfahan", "Sailor", "Male", 16, 150);
        Person p7 = new Person("Arshia", "Shahamati", "1996/03/06", "Tehran", "Pilot", "Male", 17, 250);
        Person p8 = new Person("Ebrahim", "Rad", "1981/05/09", "Shiraz", "Bus driver", "Male", 18, 100);
        Person p9 = new Person("Gheysar", "Bozorg zadeh", "1997/01/22", "Mashhad", "Crew", "Male", 19, 50);
        Person p10 = new Person("Hesam", "Nikpoor", "1996/08/19", "Tabriz", "Locomotives", "Male", 20, 150);
        BuyPerson(p1);
        BuyPerson(p2);
        BuyPerson(p3);
        BuyPerson(p4);
        BuyPerson(p5);
        BuyPerson(p6);
        BuyPerson(p7);
        BuyPerson(p8);
        BuyPerson(p9);
        BuyPerson(p10);
        Country.outputFile(country);
    }

    public void SetPassengers() throws IOException {
        Person p1 = new Person("Alireza", "Kabiri", "1992/12/06", "Isfahan", "Student", "Male", 21, 50);
        Person p2 = new Person("Ali", "Hassani", "1994/07/12", "Tabriz", "Student", "Male", 22, 100);
        Person p3 = new Person("Reza", "Ahmadi", "1984/07/09", "Shiraz", "Civil Engineer", "Male", 23, 300);
        Person p4 = new Person("Mohammad", "Nikpoor", "1998/01/25", "Mashhad", "Student", "Male", 24, 500);
        Person p5 = new Person("Gheysar", "Arbabi", "1996/06/15", "Shiraz", "Computer Engineer", "Male", 25, 400);
        Person p6 = new Person("Ali", "Bozorg zadeh", "1990/10/06", "Isfahan", "Student", "Male", 26, 500);
        Person p7 = new Person("Arshia", "Shahamati", "1996/05/06", "Shiraz", "Student", "Male", 27, 100);
        Person p8 = new Person("Ebrahim", "Rad", "1976/05/25", "Shiraz", "Taxi driver", "Male", 28, 100);
        Person p9 = new Person("Hesam", "Mahmoudi", "1999/01/22", "Mashhad", "Student", "Male", 29, 500);
        Person p10 = new Person("Ehsan", "Hamidi", "1996/08/19", "Tabriz", "Student", "Male", 30, 400);
        BuyPerson(p1);
        BuyPerson(p2);
        BuyPerson(p3);
        BuyPerson(p4);
        BuyPerson(p5);
        BuyPerson(p6);
        BuyPerson(p7);
        BuyPerson(p8);
        BuyPerson(p9);
        BuyPerson(p10);
        Country.outputFile(country);
    }

    public void SetPerson1() throws IOException {
        Person p1 = new Person("Ahmad", "Kabiri", "1991/12/06", "Isfahan", "Sailor", "Male", 41, 150);
        Person p2 = new Person("Alireza", "Esmaeili", "1994/07/06", "Mashhad", "Crew", "Male", 42, 250);
        Person p3 = new Person("Mohammad", "Ahmadi", "1984/07/05", "Tabriz", "Bus driver", "Male", 43, 100);
        Person p4 = new Person("Habib", "Hamidi", "1998/01/25", "Isfahan", "Locomotives", "Male", 44, 50);
        Person p5 = new Person("Ehsan", "Arbabi", "1996/03/25", "Tabriz", "Locomotives", "Male", 45, 150);
        Person p6 = new Person("Ali akbar", "hemmat", "1990/11/06", "Isfahan", "Sailor", "Male", 46, 150);
        Person p7 = new Person("Arshia", "Shahamati", "1996/03/06", "Isfahan", "Pilot", "Male", 47, 250);
        Person p8 = new Person("Arta", "Rad", "1981/05/09", "Tabriz", "Bus driver", "Male", 48, 100);
        Person p9 = new Person("Gheysar", "Akbari", "1997/26/22", "Tehran", "Crew", "Male", 49, 50);
        Person p10 = new Person("Hesam", "Rezapour", "1996/08/19", "Tehran", "Sailor", "Male", 50, 150);
        BuyPerson(p1);
        BuyPerson(p2);
        BuyPerson(p3);
        BuyPerson(p4);
        BuyPerson(p5);
        BuyPerson(p6);
        BuyPerson(p7);
        BuyPerson(p8);
        BuyPerson(p9);
        BuyPerson(p10);
        Country.outputFile(country);
    }

    public void SetPassengers1() throws IOException {
        Person p1 = new Person("Alireza", "Kabiri", "1992/12/06", "Isfahan", "Student", "Male", 51, 50);
        Person p2 = new Person("Ali", "Ahmadi", "1994/07/12", "Tabriz", "Student", "Male", 52, 100);
        Person p3 = new Person("Reza", "Ahmadi", "1984/07/09", "Shiraz", "Civil Engineer", "Male", 53, 300);
        Person p4 = new Person("Mohammad", "Elahi", "1998/01/25", "Mashhad", "Student", "Male", 54, 500);
        Person p5 = new Person("Gheysar", "Arbabi", "1996/06/15", "Shiraz", "Computer Engineer", "Male", 55, 400);
        Person p6 = new Person("Ali", "Samadi", "1990/10/06", "Isfahan", "Student", "Male", 56, 500);
        Person p7 = new Person("Arshia", "Shahamati", "1996/05/06", "Shiraz", "Student", "Male", 57, 100);
        Person p8 = new Person("Kasra", "Rad", "1976/05/25", "Shiraz", "Taxi driver", "Male", 58, 100);
        Person p9 = new Person("Hesam", "Mahmoudi", "1999/01/22", "Mashhad", "Student", "Male", 59, 500);
        Person p10 = new Person("Ehsan", "Hamidi", "2000/08/19", "Tabriz", "Student", "Male", 60, 400);
        BuyPerson(p1);
        BuyPerson(p2);
        BuyPerson(p3);
        BuyPerson(p4);
        BuyPerson(p5);
        BuyPerson(p6);
        BuyPerson(p7);
        BuyPerson(p8);
        BuyPerson(p9);
        BuyPerson(p10);
        Country.outputFile(country);
    }

    public void SetPerson2() throws IOException {
        Person p1 = new Person("Ali", "Kabiri", "1991/12/06", "Isfahan", "Sailor", "Male", 61, 150);
        Person p2 = new Person("Alireza", "Vali", "1994/07/06", "Tehran", "Pilot", "Male", 62, 250);
        Person p3 = new Person("Mohammad", "Arteshi", "1984/07/09", "Shiraz", "Bus driver", "Male", 63, 100);
        Person p4 = new Person("Reza", "Hamidi", "1998/01/25", "Mashhad", "Crew", "Male", 64, 50);
        Person p5 = new Person("Akbar", "Arbabi", "1996/03/15", "Tabriz", "Locomotives", "Male", 65, 150);
        Person p6 = new Person("Ali akbar", "Mahmoodi", "1990/10/06", "Isfahan", "Sailor", "Male", 66, 150);
        Person p7 = new Person("Arshia", "Shahamati", "1996/03/06", "Tehran", "Pilot", "Male", 67, 250);
        Person p8 = new Person("Ehsan", "Rad", "1981/05/09", "Shiraz", "Bus driver", "Male", 68, 100);
        Person p9 = new Person("Gheysar", "Hesami", "1997/01/22", "Mashhad", "Crew", "Male", 69, 50);
        Person p10 = new Person("Hesam", "Nikpoor", "1996/08/19", "Tabriz", "Locomotives", "Male", 70, 150);
        BuyPerson(p1);
        BuyPerson(p2);
        BuyPerson(p3);
        BuyPerson(p4);
        BuyPerson(p5);
        BuyPerson(p6);
        BuyPerson(p7);
        BuyPerson(p8);
        BuyPerson(p9);
        BuyPerson(p10);
        Country.outputFile(country);
    }

    public void SetPassengers2() throws IOException {
        Person p1 = new Person("Alireza", "Kabiri", "1992/12/06", "Isfahan", "Student", "Male", 71, 50);
        Person p2 = new Person("Ali", "Rad", "1994/07/12", "Tabriz", "Student", "Male", 72, 100);
        Person p3 = new Person("Reza", "Ahmadi", "1984/07/09", "Shiraz", "Civil Engineer", "Male", 73, 300);
        Person p4 = new Person("Mohammad", "Nikpoor", "1998/01/25", "Mashhad", "Student", "Male", 74, 500);
        Person p5 = new Person("Gheysar", "Arbabi", "1996/06/15", "Shiraz", "Computer Engineer", "Male", 75, 400);
        Person p6 = new Person("Ali", "Bozorg zadeh", "1990/10/06", "Isfahan", "Student", "Male", 76, 500);
        Person p7 = new Person("Arshia", "Aram", "1996/05/06", "Shiraz", "Student", "Male", 77, 100);
        Person p8 = new Person("Ebrahim", "Rad", "1976/05/25", "Shiraz", "Taxi driver", "Male", 78, 100);
        Person p9 = new Person("Hesam", "Mahmoudi", "1999/01/22", "Mashhad", "Student", "Male", 79, 500);
        Person p10 = new Person("Ehsan", "Farhang", "1996/08/19", "Tabriz", "Student", "Male", 80, 400);
        BuyPerson(p1);
        BuyPerson(p2);
        BuyPerson(p3);
        BuyPerson(p4);
        BuyPerson(p5);
        BuyPerson(p6);
        BuyPerson(p7);
        BuyPerson(p8);
        BuyPerson(p9);
        BuyPerson(p10);
        Country.outputFile(country);
    }

    public void SetPerson3() throws IOException {
        Person p1 = new Person("Reza", "Kabiri", "1991/12/06", "Isfahan", "Sailor", "Male", 81, 150);
        Person p2 = new Person("Alireza", "Hassani", "1994/07/06", "Tehran", "Pilot", "Male", 82, 250);
        Person p3 = new Person("Ehsan", "Ahmadi", "1984/07/09", "Shiraz", "Bus driver", "Male", 83, 100);
        Person p4 = new Person("Reza", "Shahamati", "1998/01/25", "Mashhad", "Crew", "Male", 84, 50);
        Person p5 = new Person("Ehsan", "Arbabi", "1996/03/15", "Tabriz", "Locomotives", "Male", 85, 150);
        Person p6 = new Person("Ali akbar", "Mahmoodi", "1990/10/06", "Isfahan", "Sailor", "Male", 86, 150);
        Person p7 = new Person("Arshia", "Shahamati", "1996/03/06", "Tehran", "Pilot", "Male", 87, 250);
        Person p8 = new Person("Ebrahim", "Hemmati", "1981/05/09", "Shiraz", "Bus driver", "Male", 88, 100);
        Person p9 = new Person("Gheysar", "Bozorg zadeh", "1997/01/22", "Mashhad", "Crew", "Male", 89, 50);
        Person p10 = new Person("Hesam", "Nikpoor", "1996/08/19", "Tabriz", "Locomotives", "Male", 90, 150);
        BuyPerson(p1);
        BuyPerson(p2);
        BuyPerson(p3);
        BuyPerson(p4);
        BuyPerson(p5);
        BuyPerson(p6);
        BuyPerson(p7);
        BuyPerson(p8);
        BuyPerson(p9);
        BuyPerson(p10);
        Country.outputFile(country);
    }

    public void SetPassengers3() throws IOException {
        Person p1 = new Person("Pouria", "Kabiri", "1992/12/06", "Isfahan", "Student", "Male", 91, 50);
        Person p2 = new Person("Ali", "Hassani", "1994/07/12", "Tabriz", "Student", "Male", 92, 100);
        Person p3 = new Person("Reza", "Sameti", "1984/07/09", "Shiraz", "Civil Engineer", "Male", 93, 300);
        Person p4 = new Person("Mohammad", "Nikpoor", "1998/01/25", "Mashhad", "Student", "Male", 94, 500);
        Person p5 = new Person("Danial", "Arbabi", "1996/06/15", "Shiraz", "Computer Engineer", "Male", 95, 400);
        Person p6 = new Person("Ali", "Bozorg zadeh", "1990/10/06", "Isfahan", "Student", "Male", 96, 500);
        Person p7 = new Person("Arshia", "Tavakoli", "1996/05/06", "Shiraz", "Student", "Male", 97, 100);
        Person p8 = new Person("Ebrahim", "Rad", "1976/05/25", "Shiraz", "Taxi driver", "Male", 98, 100);
        Person p9 = new Person("Hesam", "Ebrahimi", "1999/01/22", "Mashhad", "Student", "Male", 99, 500);
        Person p10 = new Person("Ehsan", "Hamidi", "1996/08/19", "Tabriz", "Student", "Male", 100, 400);
        BuyPerson(p1);
        BuyPerson(p2);
        BuyPerson(p3);
        BuyPerson(p4);
        BuyPerson(p5);
        BuyPerson(p6);
        BuyPerson(p7);
        BuyPerson(p8);
        BuyPerson(p9);
        BuyPerson(p10);
        Country.outputFile(country);
    }

    public void getReadyHotels1() throws IOException {
        Hotel hotel1 = new Hotel("TehHotel", 1200, "Tehran", 1);
        Hotel hotel2 = new Hotel("TehranHotel", 1400, "Tehran", 2);
        Hotels.add(hotel1);
        Hotels.add(hotel2);
        Country.outputFile(country);
    }

    public void getReadyHotels2() throws IOException {
        Hotel hotel1 = new Hotel("IsfHotel", 1200, "Isfahan", 1);
        Hotel hotel2 = new Hotel("IsfahanHotel", 1600, "Isfahan", 3);
        Hotels.add(hotel1);
        Hotels.add(hotel2);
        Country.outputFile(country);
    }

    public void getReadyHotels3() throws IOException {
        Hotel hotel1 = new Hotel("TabHotel", 1200, "Tabriz", 1);
        Hotel hotel2 = new Hotel("TabrizHotel", 1800, "Tabriz", 4);
        Hotels.add(hotel1);
        Hotels.add(hotel2);
        Country.outputFile(country);
    }

    public void getReadyHotels4() throws IOException {
        Hotel hotel1 = new Hotel("ShirHotel", 1400, "Shiraz", 2);
        Hotel hotel2 = new Hotel("ShirazHotel", 1400, "Shiraz", 2);
        Hotels.add(hotel1);
        Hotels.add(hotel2);
        Country.outputFile(country);
    }

    public void getReadyTerminal1() throws IOException {
        BusTerminal busTerminal = new BusTerminal(400, "Tehran", "TehTerminal", "Tehran", 1000, 0, this);
        Airport Airport = new Airport(600, "Tehran", "TehranTerminal", "Tehran", 3000, 0, this, "B", 2);
        Terminals.add(busTerminal);
        Terminals.add(Airport);
        Country.outputFile(country);
    }

    public void getReadyTerminal2() throws IOException {
        BusTerminal busTerminal1 = new BusTerminal(400, "Isfahan", "IsfTerminal", "Isfahan", 5000, 0, this);
        BusTerminal busTerminal2 = new BusTerminal(400, "Isfahan", "IsfahanTerminal", "Isfahan", 1000, 0, this);
        Terminals.add(busTerminal1);
        Terminals.add(busTerminal2);
        Country.outputFile(country);
    }

    public void getReadyTerminal3() throws IOException {
        BusTerminal busTerminal1 = new BusTerminal(400, "Tabriz", "TabTerminal", "Tabriz", 3000, 0, this);
        BusTerminal busTerminal2 = new BusTerminal(400, "Tabriz", "TabrizTerminal", "Tabriz", 5000, 0, this);
        Terminals.add(busTerminal1);
        Terminals.add(busTerminal2);
        Country.outputFile(country);
    }

    public void getReadyTerminal4() throws IOException {
        BusTerminal busTerminal = new BusTerminal(400, "Shiraz", "ShirTerminal", "Shiraz", 2000, 0, this);
        Airport Airport = new Airport(600, "Shiraz", "ShirazTerminal", "Shiraz", 3000, 0, this, "A", 2);
        Terminals.add(busTerminal);
        Terminals.add(Airport);
        Country.outputFile(country);
    }

    public void getReadyBank1() throws IOException {
        Bank bank1 = new Bank("TehBank");
        Bank bank2 = new Bank("TehranBank");
        Banks.add(bank1);
        Banks.add(bank2);
        Country.outputFile(country);
    }

    public void getReadyBank2() throws IOException {
        Bank bank1 = new Bank("IsfBank");
        Bank bank2 = new Bank("IsfahanBank");
        Banks.add(bank1);
        Banks.add(bank2);
        Country.outputFile(country);
    }

    public void getReadyBank3() throws IOException {
        Bank bank1 = new Bank("TabBank");
        Bank bank2 = new Bank("TabrizBank");
        Banks.add(bank1);
        Banks.add(bank2);
        Country.outputFile(country);
    }

    public void getReadyBank4() throws IOException {
        Bank bank1 = new Bank("ShirBank");
        Bank bank2 = new Bank("ShirazBank");
        Banks.add(bank1);
        Banks.add(bank2);
        Country.outputFile(country);
    }

    public void PrintAllPersons() {
        for (Person person : Persons) {
            System.out.println("Name:" + person.getName() + " " + person.getFamily() + "\tJob:" + person.getJob() + "\tID:" + person.getIDPersonal());
            System.out.println("----------------------------------------");
        }
    }

    public Person IDToPerson(int ID) {
        for (Person person : Persons) {
            if (person.getIDPersonal() == ID) {
                return person;
            }
        }
        return null;
    }

    public ArrayList<Bank> getBanks() {
        return Banks;
    }

    public void PrintBank(int index) {
        System.out.print("Name:" + getBanks().get(index - 1).getName());
        System.out.print("\tCirculationMoney:");
        System.out.printf("%.2f", getBanks().get(index - 1).getCirculationMoney());
        System.out.println("\tActiveAccounts:" + getBanks().get(index - 1).getActiveAccounts());
    }

    public void PlusMoney(double Money) throws IOException {
        AvailableMoney += Money;
        Country.outputFile(country);
    }
}
