package Main.Vehicles;

import java.io.Serializable;

public class Boat extends MarineVehicle implements Serializable {

    private final double BoatLength;
    private final String BoatMaterial;

    public Boat(double purchasePrice, int capacity, int iD, String manufacturerName, String fuelType, double minDepth,
            double boatLength, String boatMaterial) {
        super(purchasePrice, capacity, iD, manufacturerName, fuelType, minDepth);
        BoatLength = boatLength;
        BoatMaterial = boatMaterial;
    }

}