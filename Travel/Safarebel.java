package Travel;

import Main.Buildings.Terminal;
import Main.Person;
import Main.Vehicles.Vehicle;

import java.io.IOException;
import java.util.ArrayList;


public interface Safarebel {
    default void newTravel(Terminal originTerminal, Terminal destinationTerminal, ArrayList<Person> Passengers, Person driver, Vehicle vehicle, int ID, String date, double cost) throws IOException {
    }

    default void TravelSort() throws IOException {
    }

    default double TravelCost(ArrayList<Person> Passengers, Vehicle vehicle) {
        return 0;
    }

    default void TravelHistory(String string) throws IOException {
    }

}
