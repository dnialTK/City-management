package myException;

import java.io.Serializable;

public class DriverPresent extends CancelTravel implements Serializable {
    public String toString() {
        return "The driver from origin terminal does not is not present!";
    }
}
