package Main.Vehicles;

import java.io.Serializable;

public class Train extends LandVehicle implements Serializable {

    private final int WagonsNumber;
    private final int StarsNumber;

    public Train(double purchasePrice, int capacity, int iD, String manufacturerName, double maxSpeed,
                 double acceleration, int wagonsNumber, int starsNumber) {
        super(purchasePrice, capacity, iD, manufacturerName, maxSpeed, acceleration);
        WagonsNumber = wagonsNumber;
        StarsNumber = starsNumber;
    }

}