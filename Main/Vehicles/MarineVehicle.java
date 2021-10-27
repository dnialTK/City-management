package Main.Vehicles;

import java.io.Serializable;

abstract public class MarineVehicle extends Vehicle implements Serializable {

    private final String FuelType;
    private final double MinDepth;

    public MarineVehicle(double purchasePrice, int capacity, int iD, String manufacturerName, String fuelType,
                         double minDepth) {
        super(purchasePrice, capacity, iD, manufacturerName);
        FuelType = fuelType;
        MinDepth = minDepth;
    }

}