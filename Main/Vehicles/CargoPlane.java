package Main.Vehicles;

import java.io.Serializable;

public class CargoPlane extends AirVehicle implements Serializable {

    private final double PortableWeight;

    public CargoPlane(double purchasePrice, int capacity, int iD, String manufacturerName, double maxFlightAltitude,
            double bandLength, double portableWeight) {
        super(purchasePrice, capacity, iD, manufacturerName, maxFlightAltitude, bandLength);
        PortableWeight = portableWeight;
    }
}