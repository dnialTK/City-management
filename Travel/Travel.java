package Travel;

import Main.Buildings.Terminal;
import Main.Person;
import Main.Vehicles.Vehicle;

import java.io.Serializable;
import java.util.ArrayList;

public class Travel implements Comparable<Travel>, Serializable {
    private final Terminal OriginTerminal;
    private final Terminal DestinationTerminal;
    private final Person Driver;
    private final Vehicle Vehicle;
    private final int ID;
    private final String Date;
    private final double Cost;
    private ArrayList<Person> Passengers = new ArrayList<>();

    public Travel(Terminal originTerminal, Terminal destinationTerminal, ArrayList<Person> passengers, Person driver, Vehicle vehicle, int ID, String date, double cost) {
        OriginTerminal = originTerminal;
        DestinationTerminal = destinationTerminal;
        Passengers = passengers;
        Driver = driver;
        Vehicle = vehicle;
        this.ID = ID;
        Date = date;
        Cost = cost;
    }

    public int getID() {
        return ID;
    }

    public String getDate() {
        return Date;
    }

    public Terminal getOriginTerminal() {
        return OriginTerminal;
    }

    public double getCost() {
        return Cost;
    }

    @Override
    public int compareTo(Travel travel) {
        int i;
        boolean flag = false;
        //year
        for (i = 6; i <= 9; i++) {
            if (travel.Date.charAt(i) < (this.Date.charAt(i)))
                return 1;
            else if (travel.Date.charAt(i) > (this.Date.charAt(i)))
                return -1;
        }
        //month
        for (i = 3; i <= 4; i++) {
            if (travel.Date.charAt(i) < (this.Date.charAt(i)))
                return 1;
            else if (travel.Date.charAt(i) > (this.Date.charAt(i)))
                return -1;
        }
        //day
        for (i = 0; i <= 1; i++) {
            if (travel.Date.charAt(i) < (this.Date.charAt(i)))
                return 1;
            else if (travel.Date.charAt(i) > (this.Date.charAt(i)))
                return -1;
            else if (travel.Date.charAt(i) == (this.Date.charAt(i))) {
                if (i == 1) {
                    flag = true;
                }
            }
        }
        if (flag) {
            return Double.compare(this.Cost, travel.Cost);
        }
        return 0;
    }

}