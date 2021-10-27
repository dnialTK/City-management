package Main.Vehicles;

import java.io.Serializable;

abstract public class AirVehicle extends Vehicle implements Serializable {

    private final double MaxFlightAltitude;
    private final double BandLength;

    public AirVehicle(double purchasePrice, int capacity, int iD, String manufacturerName, double maxFlightAltitude,
            double bandLength) {
        super(purchasePrice, capacity, iD, manufacturerName);
        MaxFlightAltitude = maxFlightAltitude;
        BandLength = bandLength;
    }

}