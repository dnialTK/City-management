package Main;

import Main.Bank.Account;
import Main.Bank.Bank;
import Main.Bank.Transaction;
import Main.Buildings.*;
import Main.FinancialManagement.FinancialManagement;
import Main.Vehicles.*;
import myException.LandTravel;
import myException.TerminalType;
import myException.VehicleCapacity;

import javax.swing.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main implements Serializable {

    public static boolean isEntered = false;

    public static FinancialManagement financialManagement;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SwingUtilities.invokeLater(() -> {
            financialManagement = new FinancialManagement();
            financialManagement.setVisible(false);
            financialManagement.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        });
        Country country = new Country();
        //We have to run 2 times, for first create file and just write in file and then read from file
        try {
            country = Read();
            for (City city : country.getCities()) {
                for (int j = 0; j < city.getBanks().size(); j++) {
                    for (int k = 0; k < city.getBanks().get(j).getAccounts().size(); k++) {
                        Thread thread = new Thread(city.getBanks().get(j).getAccounts().get(k));
                        thread.start();
                    }
                }
            }
        } catch (Exception ignored) {
            //To get ready cities
            City city = new City("Tehran", 10000, country);
            City city1 = new City("Isfahan", 7000, country);
            City city2 = new City("Tabriz", 5000, country);
            City city3 = new City("Shiraz", 3000, country);
            city.SetPerson();
            city1.SetPerson1();
            city2.SetPerson2();
            city3.SetPerson3();
            city.SetPassengers();
            city1.SetPassengers1();
            city2.SetPassengers2();
            city3.SetPassengers3();
            city.getReadyHotels1();
            city1.getReadyHotels2();
            city2.getReadyHotels3();
            city3.getReadyHotels4();
            city.getReadyTerminal1();
            city1.getReadyTerminal2();
            city2.getReadyTerminal3();
            city3.getReadyTerminal4();
            city.getReadyBank1();
            city1.getReadyBank2();
            city2.getReadyBank3();
            city3.getReadyBank4();
            country.addCity(city);
            country.addCity(city1);
            country.addCity(city2);
            country.addCity(city3);
            country.setPopulation();
            country.setMoney();
        }
        while (true) {
            country.PrintInfo();
            Print("1-Enter in a city\n2-Build a city\n3-Display information about cities\n4-Financial Management\n5-All money from accounts\n6-Exit");
            Scanner sc = new Scanner(System.in);
            int number = sc.nextInt();
            switch (number) {
                case 1 -> {
                    country.PrintCountryCities();
                    int num = sc.nextInt();
                    EnterMenu(country.getCities().get(num - 1), country);
                }
                case 2 -> {
                    Print("Enter Name and Money: ");
                    String name = sc.next();
                    double money = sc.nextDouble();
                    country.addCity(name, money);
                }
                case 3 -> country.PrintCountry();
                case 4 -> {
                    financialManagement.setVisible(true);
                    isEntered = true;
                }
                case 5 -> Print("All accounts money is: " + country.AllMoney());
                case 6 -> System.exit(0);
                default -> System.out.println("Enter again!");
            }
        }
    }

    public static void Print(Object object) {
        System.out.println(object);
    }

    public static void EnterMenu(City city, Country country) throws IOException {
        Print("Available money: " + city.getAvailableMoney());
        System.out.println(
                "1-Build a variety of terminals\n2-Buy vehicles\n3-Hiring a leader\n4-Display information about terminals\n5-Build a hotel\n6-Build a room for a hotel\n7-Display information about hotels\n8-Add travel\n9-Travel histories\n10-Bank\n\nEnter a number: ");
        Scanner sc = new Scanner(System.in);
        int number1 = sc.nextInt();
        switch (number1) {
            case 1 -> {
                System.out.println("1-Bus Terminal\n2-Airport\n3-Railway Station\n4-Shipping Port");
                System.out.println("What kind of terminal do you want to build? ");
                int number2 = sc.nextInt();
                switch (number2) {
                    case 1 -> {
                        System.out.println("Enter terminalName, address, area, vehiclesNumber");
                        BusTerminal busTerminal = new BusTerminal(400, city.getName(), sc.next(), sc.next(), sc.nextDouble(),
                                sc.nextInt(), city);
                        city.AddBusTerminal(busTerminal);

                    }
                    case 2 -> {
                        System.out.println(
                                "Enter terminalName, address, area, vehiclesNumber, airportType, runwaysNumber");
                        Airport airport = new Airport(600, city.getName(), sc.next(), sc.next(), sc.nextDouble(),
                                sc.nextInt(), city, sc.next(), sc.nextInt());
                        city.AddAirport(airport);
                    }
                    case 3 -> {
                        System.out.println(
                                "Enter terminalName, address, area, vehiclesNumber, inputRailsNumber, outputRailsNumber");
                        RailwayStation railwayStation = new RailwayStation(500, city.getName(), sc.next(), sc.next(),
                                sc.nextDouble(), sc.nextInt(), city, sc.nextInt(), sc.nextInt());
                        city.AddRailwayStation(railwayStation);
                    }
                    case 4 -> {
                        System.out.println("Enter terminalName, address, area, vehiclesNumber, docksNumber");
                        ShippingPort shippingPort = new ShippingPort(300, city.getName(), sc.next(), sc.next(),
                                sc.nextDouble(), sc.nextInt(), city, sc.nextInt());
                        city.AddShippingPort(shippingPort);
                    }
                    default -> Print("Enter again!");
                }
            }
            case 2 -> {
                Print("Choose terminal do you want to buy vehicle for it with name: ");
                for (int i = 0; i < city.getTerminals().size(); i++) {
                    Print("Name: " + city.getTerminals().get(i).getTerminalName() + "\t" + city.getTerminals().get(i).getClass().getSimpleName());
                }
                String number3 = sc.next();
                for (int i = 0; i < city.getTerminals().size(); i++) {
                    if (number3.equals(city.getTerminals().get(i).getTerminalName())) {
                        //Bus terminal
                        if (city.getTerminals().get(i) instanceof BusTerminal) {
                            BusTerminal a = (BusTerminal) city.getTerminalsName(number3);
                            Print("Enter capacity, iD, manufacturerName, maxSpeed, acceleration, color, ticketFee");
                            CityBus citybus = new CityBus(200, sc.nextInt(), sc.nextInt(), sc.next(), sc.nextDouble(),
                                    sc.nextDouble(), sc.next(), sc.nextDouble());
                            city.BuyBus(citybus, a);
                            //Airport
                        } else if (city.getTerminals().get(i) instanceof Airport) {
                            Airport a = (Airport) city.getTerminalsName(number3);
                            System.out.println("1-Passenger Plane\n2-Cargo Plane");
                            System.out.println("Which plane do you want to buy? ");
                            int number4 = sc.nextInt();
                            if (number4 == 1) {
                                Print("Enter capacity, iD, manufacturerName, maxFlightAltitude, bandLength, crewNumber, seatClassification");
                                PassengerPlane passengerPlane = new PassengerPlane(400, sc.nextInt(), sc.nextInt(),
                                        sc.next(), sc.nextDouble(), sc.nextDouble(), sc.nextInt(), sc.next());
                                city.BuyPassengerPlane(passengerPlane, a);
                            } else {
                                Print("Enter capacity, iD, manufacturerName, maxFlightAltitude, bandLength, portableWeight");
                                CargoPlane cargoPlane = new CargoPlane(400, sc.nextInt(), sc.nextInt(), sc.next(),
                                        sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
                                city.BuyCargoPlane(cargoPlane, a);
                            }
                            //Railway station
                        } else if (city.getTerminals().get(i) instanceof RailwayStation) {
                            RailwayStation a = (RailwayStation) city.getTerminalsName(number3);
                            Print("Enter capacity, iD, manufacturerName, maxSpeed, acceleration, wagonsNumber, starsNumber");
                            Train train = new Train(700, sc.nextInt(), sc.nextInt(), sc.next(), sc.nextDouble(),
                                    sc.nextDouble(), sc.nextInt(), sc.nextInt());
                            city.BuyTrain(train, a);
                            //Shipping port
                        } else if (city.getTerminals().get(i) instanceof ShippingPort) {
                            ShippingPort a = (ShippingPort) city.getTerminalsName(number3);
                            System.out.println("1-Ship\n2-Boat");
                            System.out.println("Which marine vehicle do you want to buy? ");
                            int number5 = sc.nextInt();
                            if (number5 == 1) {
                                Print("Enter capacity, iD, manufacturerName, fuelType, minDepth, constructionYear, roomsNumber");
                                Ship ship = new Ship(750, sc.nextInt(), sc.nextInt(), sc.next(), sc.next(), sc.nextDouble(),
                                        sc.nextInt(), sc.nextInt());
                                city.BuyShip(ship, a);

                            } else {
                                Print("Enter capacity, iD, manufacturerName, fuelType, minDepth, boatLength, boatMaterial");
                                Boat boat = new Boat(350, sc.nextInt(), sc.nextInt(), sc.next(), sc.next(), sc.nextDouble(),
                                        sc.nextDouble(), sc.next());
                                city.BuyBoat(boat, a);
                            }
                        }
                    }
                }
            }
            case 3 -> {
                Print("Choose terminal do you want to buy vehicle for it with name: ");
                for (int i = 0; i < city.getTerminals().size(); i++) {
                    Print("Name: " + city.getTerminals().get(i).getTerminalName() + "\t" + city.getTerminals().get(i).getClass().getSimpleName());
                }
                String number6 = sc.next();
                for (int i = 0; i < city.getTerminals().size(); i++) {
                    if (number6.equals(city.getTerminals().get(i).getTerminalName())) {
                        if (city.getTerminals().get(i) instanceof BusTerminal) {
                            city.PrintPerson("Bus driver");
                            System.out.println("Which ID? ");
                            int number7 = sc.nextInt();
                            if (city.getTerminals().get(i).getLeaders().contains(city.checkPerson(number7))) {
                                System.out.println("This leader has already been added!");
                            } else {
                                city.AddLeader(number7, city.getTerminals().get(i));
                            }
                        } else if (city.getTerminals().get(i) instanceof Airport) {
                            System.out.println("1-Pilot\n2-Crew");
                            int number8 = sc.nextInt();
                            if (number8 == 1) {
                                city.PrintPerson("Pilot");
                                System.out.println("Which ID? ");
                                int number9 = sc.nextInt();
                                if (city.getTerminals().get(i).getLeaders().contains(city.checkPerson(number9))) {
                                    System.out.println("This leader has already been added!");
                                } else {
                                    city.AddLeader(number9, city.getTerminals().get(i));
                                }
                            } else {
                                city.PrintPerson("Crew");
                                System.out.println("Which ID? ");
                                int number9 = sc.nextInt();
                                if (city.getTerminals().get(i).getLeaders().contains(city.checkPerson(number9))) {
                                    System.out.println("This leader has already been added!");
                                } else {
                                    city.AddLeader(number9, city.getTerminals().get(i));
                                }
                            }
                        } else if (city.getTerminals().get(i) instanceof RailwayStation) {
                            city.PrintPerson("Locomotives");
                            System.out.println("Which ID? ");
                            int number10 = sc.nextInt();
                            if (city.getTerminals().get(i).getLeaders().contains(city.checkPerson(number10))) {
                                System.out.println("This leader has already been added!");
                            } else {
                                city.AddLeader(number10, city.getTerminals().get(i));
                            }
                        } else if (city.getTerminals().get(i) instanceof ShippingPort) {
                            city.PrintPerson("Sailor");
                            System.out.println("Which ID? ");
                            int number11 = sc.nextInt();
                            if (city.getTerminals().get(i).getLeaders().contains(city.checkPerson(number11))) {
                                System.out.println("This leader has already been added!");
                            } else {
                                city.AddLeader(number11, city.getTerminals().get(i));
                            }
                        }
                    }
                }
            }
            case 4 -> {
                for (int i = 0; i < city.getTerminals().size(); i++) {
                    System.out.println("Terminal name: " + city.getTerminals().get(i).getTerminalName()
                            + "\nCity name: " + city.getTerminals().get(i).getCityName());
                }
                System.out.println("Leaders:");
                for (int i = 0; i < city.getTerminals().size(); i++) {
                    for (int j = 0; j < city.getTerminals().get(i).getLeaders().size(); j++) {
                        System.out.println("Name: " + city.getTerminals().get(i).getLeaders().get(j).getName() + "\tFamily: "
                                + city.getTerminals().get(i).getLeaders().get(j).getFamily() + "\tJob: "
                                + city.getTerminals().get(i).getLeaders().get(j).getJob());
                    }
                }
            }
            case 5 -> {
                System.out.println("How many stars do you want for your hotel? \tChoose between 1-5");
                int stars = sc.nextInt();
                Print("Enter hotelName, address");
                switch (stars) {
                    case 1 -> {
                        Hotel hotel1 = new Hotel(sc.next(), 1200, sc.next(), 1);
                        city.AddHotel(hotel1);
                        System.out.println("Do you want to add services to your hotel?\n1-Yes\n2-No ");
                        int add1 = sc.nextInt();
                        if (add1 == 1) {
                            System.out.println("Hotel services:\n" + "1-" + Hotel.HotelFacilities.values()[0] + "\n2-"
                                    + Hotel.HotelFacilities.values()[1] + "\n3-" + Hotel.HotelFacilities.values()[0]
                                    + " and " + Hotel.HotelFacilities.values()[1]);
                            int services1 = sc.nextInt();
                            switch (services1) {
                                case 1, 2 -> city.AddService1(hotel1, services1);
                                case 3 -> city.AddService2(hotel1);
                            }
                        } else {
                            System.out.println("No services!");
                        }
                    }
                    case 2 -> {
                        Hotel hotel2 = new Hotel(sc.next(), 1400, sc.next(), 2);
                        city.AddHotel(hotel2);
                        System.out.println("Do you want to add services to your hotel?\n1-Yes\n2-No ");
                        int add2 = sc.nextInt();
                        if (add2 == 1) {
                            System.out.println("Hotel services:\n" + "1-" + Hotel.HotelFacilities.values()[0] + "\n2-"
                                    + Hotel.HotelFacilities.values()[1] + "\n3-" + Hotel.HotelFacilities.values()[0]
                                    + " and " + Hotel.HotelFacilities.values()[1]);
                            int services1 = sc.nextInt();
                            switch (services1) {
                                case 1, 2 -> city.AddService1(hotel2, services1);
                                case 3 -> city.AddService2(hotel2);
                            }
                        } else {
                            System.out.println("No services!");
                        }
                    }
                    case 3 -> {
                        Hotel hotel3 = new Hotel(sc.next(), 1600, sc.next(), 3);
                        city.AddHotel(hotel3);
                        System.out.println("Do you want to add services to your hotel?\n1-Yes\n2-No ");
                        int add3 = sc.nextInt();
                        if (add3 == 1) {
                            System.out.println("Hotel services:\n" + "1-" + Hotel.HotelFacilities.values()[0] + "\n2-"
                                    + Hotel.HotelFacilities.values()[1] + "\n3-" + Hotel.HotelFacilities.values()[0]
                                    + " and " + Hotel.HotelFacilities.values()[1]);
                            int services1 = sc.nextInt();
                            switch (services1) {
                                case 1, 2 -> city.AddService1(hotel3, services1);
                                case 3 -> city.AddService2(hotel3);
                            }
                        } else {
                            System.out.println("No services!");
                        }
                    }
                    case 4 -> {
                        Hotel hotel4 = new Hotel(sc.next(), 1800, sc.next(), 4);
                        city.AddHotel(hotel4);
                        System.out.println("Do you want to add services to your hotel?\n1-Yes\n2-No ");
                        int add4 = sc.nextInt();
                        if (add4 == 1) {
                            System.out.println("Hotel services:\n" + "1-" + Hotel.HotelFacilities.values()[0] + "\n2-"
                                    + Hotel.HotelFacilities.values()[1] + "\n3-" + Hotel.HotelFacilities.values()[0]
                                    + " and " + Hotel.HotelFacilities.values()[1]);
                            int services1 = sc.nextInt();
                            switch (services1) {
                                case 1, 2 -> city.AddService1(hotel4, services1);
                                case 3 -> city.AddService2(hotel4);
                            }
                        } else {
                            System.out.println("No services!");
                        }
                    }
                    case 5 -> {
                        Hotel hotel5 = new Hotel(sc.next(), 2000, sc.next(), 5);
                        city.AddHotel(hotel5);
                        System.out.println("Do you want to add services to your hotel?\n1-Yes\n2-No ");
                        int add5 = sc.nextInt();
                        if (add5 == 1) {
                            System.out.println("Hotel services:\n" + "1-" + Hotel.HotelFacilities.values()[0] + "\n2-"
                                    + Hotel.HotelFacilities.values()[1] + "\n3-" + Hotel.HotelFacilities.values()[0]
                                    + " and " + Hotel.HotelFacilities.values()[1]);
                            int services1 = sc.nextInt();
                            switch (services1) {
                                case 1, 2 -> city.AddService1(hotel5, services1);
                                case 3 -> city.AddService2(hotel5);
                            }
                        } else {
                            System.out.println("No services!");
                        }
                    }
                    default -> Print("Enter again!");
                }
            }
            case 6 -> {
                for (int i = 0; i < city.getHotels().size(); i++) {
                    System.out.println("Hotels: \n");
                    System.out.println((i + 1) + "-" + "Name: " + city.getHotels().get(i).getHotelName()
                            + "\tNumber of stars: " + city.getHotels().get(i).getStarsNumber());
                }
                System.out.println("Which hotel do you want to add room for? ");
                int number12 = sc.nextInt();
                for (int i = 0; i < city.getHotels().size(); i++) {
                    if (number12 == i + 1) {
                        Room room = new Room(sc.nextInt(), sc.nextInt(), sc.nextDouble(), 200);
                        city.BuyRoom(city.getHotels().get(i), room);
                        break;
                    }
                }
            }
            case 7 -> {
                System.out.println("Which hotel?");
                for (int i = 0; i < city.getHotels().size(); i++) {
                    System.out.println((i + 1) + "-" + city.getHotels().get(i).getHotelName());
                }
                int HotelNumber = sc.nextInt();
                System.out
                        .println("Name: " + city.getHotels().get(HotelNumber - 1).getHotelName() + "\tNumber of stars: "
                                + city.getHotels().get(HotelNumber - 1).getStarsNumber() + "\tNumber of rooms: "
                                + city.getHotels().get(HotelNumber - 1).getRooms().size() + "\nServices: ");
                for (int i = 0; i < city.getHotels().get(HotelNumber - 1).getServices().size(); i++) {
                    System.out.print(city.getHotels().get(HotelNumber - 1).getServices().get(i) + "\t");
                }
                System.out.println("\n");
            }
            case 8 -> {
                //passengers
                Print("How many passengers do you want to add in travel?");
                int PassengersNumber = sc.nextInt();
                int[] getID = new int[PassengersNumber];
                Print("Choose passengers with id");
                for (int i = 0; i < city.getPersons().size(); i++) {
                    if (city.atWork(city.getPersons().get(i), city).equals(false))
                        Print("Name: " + city.getPersons().get(i).getName() + " " + city.getPersons().get(i).getFamily() + "\tJob: " + city.getPersons().get(i).getJob() + "\tID: " + city.getPersons().get(i).getIDPersonal());
                }
                for (int i = 0; i < PassengersNumber; i++) {
                    getID[i] = sc.nextInt();
                }

                //origin terminals
                Print("Choose origin terminal with name");
                for (int i = 0; i < city.getTerminals().size(); i++) {
                    Print("City: " + city.getTerminals().get(i).getCityName() + "\tName: " + city.getTerminals().get(i).getTerminalName() + "\t" + city.getTerminals().get(i).getClass().getSimpleName());
                }
                String originName = sc.next();

                //destination city
                Print("Choose destination city with name");
                for (int i = 0; i < country.getCities().size(); i++) {
                    if (country.getCities().get(i).getName().equals(city.getName()))
                        System.out.print("");
                    else
                        Print("Name: " + country.getCities().get(i).getName());
                }
                String destinationCity = sc.next();

                //destination terminals
                Print("Choose destination terminal with name");
                for (int i = 0; i < country.getCities().size(); i++) {
                    for (int j = 0; j < country.getCities().get(i).getTerminals().size(); j++) {
                        if (destinationCity.equals(country.getCities().get(i).getName()))
                            Print("City: " + country.getCities().get(i).getName() + "\tName: " + country.getCities().get(i).getTerminals().get(j).getTerminalName() + "\t" + country.getCities().get(i).getTerminals().get(j).getClass().getSimpleName());
                    }
                }
                String destinationName = sc.next();

                //origin terminals vehicles
                Print("Choose vehicle with id");
                for (int i = 0; i < city.getTerminals().size(); i++) {
                    city.getTerminals().get(i).showVehicle();
                }
                int getVehicleId = sc.nextInt();

                //origin terminals drivers
                Print("Choose driver with id");
                for (int i = 0; i < city.getTerminals().size(); i++) {
                    for (int j = 0; j < city.getTerminals().get(i).getLeaders().size(); j++) {
                        Print("Name: " + city.getTerminals().get(i).getLeaders().get(j).getName() + " " + city.getTerminals().get(i).getLeaders().get(j).getFamily() + "\tJob: " + city.getTerminals().get(i).getLeaders().get(j).getJob() + "\tID: " + city.getTerminals().get(i).getLeaders().get(j).getIDPersonal());
                    }
                }
                int getDriverID = sc.nextInt();

                try {
                    //add information in temp to add new travel
                    Terminal OriginTemp = null;
                    for (int i = 0; i < city.getTerminals().size(); i++) {
                        if (originName.equals(city.getTerminals().get(i).getTerminalName())) {
                            OriginTemp = city.getTerminals().get(i);
                        }
                    }
                    Terminal DestinationTemp = null;
                    for (int i = 0; i < country.getCities().size(); i++) {
                        for (int j = 0; j < country.getCities().get(i).getTerminals().size(); j++) {
                            if (destinationName.equals(country.getCities().get(i).getTerminals().get(j).getTerminalName())) {
                                DestinationTemp = country.getCities().get(i).getTerminals().get(j);
                            }
                        }
                    }
                    ArrayList<Person> passengers = new ArrayList<>();
                    for (int k : getID) {
                        for (int j = 0; j < city.getPersons().size(); j++) {
                            if (k == city.getPersons().get(j).getIDPersonal()) {
                                passengers.add(city.getPersons().get(j));
                                break;
                            }
                        }
                    }
                    Person driver = null;
                    for (int i = 0; i < city.getTerminals().size(); i++) {
                        for (int j = 0; j < city.getTerminals().get(i).getLeaders().size(); j++) {
                            if (getDriverID == city.getTerminals().get(i).getLeaders().get(j).getIDPersonal()) {
                                driver = city.getTerminals().get(i).getLeaders().get(j);
                            }
                        }
                    }
                    Vehicle vehicle = null;
                    for (int i = 0; i < city.getTerminals().size(); i++) {
                        vehicle = city.getTerminals().get(i).getVehicle(getVehicleId);
                    }

                    assert OriginTemp != null;
                    assert DestinationTemp != null;
                    assert vehicle != null;
                    if (!OriginTemp.getClass().getSimpleName().equals(DestinationTemp.getClass().getSimpleName())) {
                        throw new TerminalType();
                    }
                    if (passengers.size() < (vehicle.getCapacity() / 2)) {
                        throw new VehicleCapacity();
                    }
                    if (OriginTemp.getClass().getSimpleName().equals("BusTerminal")) {
                        throw new LandTravel();
                    }

                    //add new travel
                    Print("Enter ID and date(dd/mm/yyyy)");
                    OriginTemp.newTravel(OriginTemp, DestinationTemp, passengers, driver, vehicle, sc.nextInt(), sc.next(), OriginTemp.TravelCost(passengers, vehicle));
                    Print("Travel added!");

                } catch (TerminalType t) {
                    System.out.println("Error TerminalType!");
                    System.out.println(t.getMessage());
                } catch (VehicleCapacity v) {
                    System.out.println("Error VehicleCapacity!");
                    System.out.println(v.getMessage());
                } catch (LandTravel l) {
                    System.out.println("Land travel");
                    System.out.println(l.getMessage());
                }

            }
            case 9 -> {
                Print("1-Input travels\n2-Output travels\n3-All travels");
                int num = sc.nextInt();
                switch (num) {
                    case 1:
                        for (int i = 0; i < city.getTerminals().size(); i++) {
                            city.getTerminals().get(i).TravelHistory("Input");
                        }
                        break;
                    case 2:
                        for (int i = 0; i < city.getTerminals().size(); i++) {
                            city.getTerminals().get(i).TravelHistory("Output");
                        }
                        break;
                    case 3:
                        for (int i = 0; i < city.getTerminals().size(); i++) {
                            city.getTerminals().get(i).TravelHistory("All");
                        }
                        break;
                    default:
                        Print("Enter again!");
                        break;
                }
            }
            case 10 -> {
                Print("1-Enter in a bank\n2-Add bank");
                int num = sc.nextInt();
                switch (num) {
                    case 1 -> {
                        city.PrintBanks();
                        num = sc.nextInt();
                        Print("1-Open an account\n2-Login to the account\n3-Bank information");
                        int num1 = sc.nextInt();
                        switch (num1) {
                            case 1 -> {
                                Print("Which Person? Enter ID:");
                                city.PrintAllPersons();
                                int ID = sc.nextInt();
                                Person person = city.IDToPerson(ID);
                                Print("Enter cash, username and password:");
                                double cash = sc.nextDouble();
                                String username = sc.next();
                                String password = sc.next();
                                Account account = new Account(cash, person, username, password, country, city.getBanks().get(num - 1), city);
                                city.getBanks().get(num - 1).getAccounts().add(account);
                                if (account.getCash() != 0)
                                    city.getBanks().get(num - 1).setActiveAccounts();
                            }
                            case 2 -> {
                                Print("Enter username and password:");
                                String username = sc.next();
                                String password = sc.next();
                                for (int i = 0; i < city.getBanks().get(num - 1).getAccounts().size(); i++) {
                                    if (city.getBanks().get(num - 1).getAccounts().get(i).getUserName().equals(username)) {
                                        if (city.getBanks().get(num - 1).getAccounts().get(i).getPassword().equals(password)) {
                                            Account account = city.getBanks().get(num - 1).getAccounts().get(i);
                                            Bank bank = city.getBanks().get(num - 1);
                                            Print("1-Deposit\n2-Withdraw\n3-Transactions");
                                            int num2 = sc.nextInt();
                                            switch (num2) {
                                                case 1:
                                                    Print("Enter Deposit amount:");
                                                    double Deposit = sc.nextDouble();
                                                    account.Deposit(Deposit);
                                                    city.PlusMoney(Deposit);
                                                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                                                    LocalDateTime now = LocalDateTime.now();
                                                    Transaction transaction1 = new Transaction(Deposit, Transaction.TransactionType.Deposit, dtf.format(now), bank, city);
                                                    account.getTransactions().add(transaction1);
                                                    break;
                                                case 2:
                                                    Print("Enter Withdraw amount:");
                                                    double Withdraw = sc.nextDouble();
                                                    account.Withdraw(Withdraw);
                                                    city.Paymoney(Withdraw);
                                                    DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                                                    LocalDateTime now2 = LocalDateTime.now();
                                                    Transaction transaction2 = new Transaction(Withdraw, Transaction.TransactionType.Withdraw, dtf2.format(now2), bank, city);
                                                    account.getTransactions().add(transaction2);
                                                    break;
                                                case 3:
                                                    for (int j = 0; j < account.getTransactions().size(); j++) {
                                                        account.getTransactions().get(j).PrintTransaction();
                                                    }
                                                    break;
                                                default:
                                                    Print("Enter again!");
                                                    break;
                                            }
                                        } else {
                                            Print("Wrong password!");
                                        }
                                    } else {
                                        Print("Wrong username!");
                                    }
                                }
                            }
                            case 3 -> city.PrintBank(num);
                            default -> Print("Enter again!");
                        }
                    }
                    case 2 -> {
                        Print("Enter name: ");
                        String name = sc.next();
                        city.AddBank(name);
                    }
                    default -> Print("Enter again!");
                }
            }
            default -> Print("Enter again!");
        }
    }

    public static Country Read() throws IOException, ClassNotFoundException {
        File file = new File("file.txt");
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Country country = (Country) ois.readObject();
        ois.close();
        fis.close();
        return country;
    }

}
