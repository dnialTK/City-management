package Main.Vehicles;

import java.io.Serializable;

public class PassengerPlane extends AirVehicle implements Serializable {

    private final int CrewNumber;
    private final String SeatClassification;

    public PassengerPlane(double purchasePrice, int capacity, int iD, String manufacturerName, double maxFlightAltitude,
                          double bandLength, int crewNumber, String seatClassification) {
        super(purchasePrice, capacity, iD, manufacturerName, maxFlightAltitude, bandLength);
        CrewNumber = crewNumber;
        SeatClassification = seatClassification;
    }

}