package Main.Vehicles;

import java.io.Serializable;

abstract public class LandVehicle extends Vehicle implements Serializable {

    private final double MaxSpeed;
    private final double Acceleration;

    public LandVehicle(double purchasePrice, int capacity, int iD, String manufacturerName, double maxSpeed,
                       double acceleration) {
        super(purchasePrice, capacity, iD, manufacturerName);
        MaxSpeed = maxSpeed;
        Acceleration = acceleration;
    }

}
