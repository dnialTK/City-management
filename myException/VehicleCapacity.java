package myException;

import java.io.Serializable;

public class VehicleCapacity extends CancelTravel implements Serializable {
    public String toString() {
        return "The number of passengers for this travel has not reached the appropriate number!";
    }
}
