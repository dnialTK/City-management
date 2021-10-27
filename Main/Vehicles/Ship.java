package Main.Vehicles;

import java.io.Serializable;

public class Ship extends MarineVehicle implements Serializable {

    private final int ConstructionYear;
    private final int RoomsNumber;

    public Ship(double purchasePrice, int capacity, int iD, String manufacturerName, String fuelType, double minDepth,
                int constructionYear, int roomsNumber) {
        super(purchasePrice, capacity, iD, manufacturerName, fuelType, minDepth);
        ConstructionYear = constructionYear;
        RoomsNumber = roomsNumber;
    }

}