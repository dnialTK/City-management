package Main.Vehicles;

import java.io.Serializable;

public class CityBus extends LandVehicle implements Serializable {

    private final String Color;
    private final double TicketFee;

    public CityBus(double purchasePrice, int capacity, int iD, String manufacturerName, double maxSpeed,
            double acceleration, String color, double ticketFee) {
        super(purchasePrice, capacity, iD, manufacturerName, maxSpeed, acceleration);
        Color = color;
        TicketFee = ticketFee;
    }

    public String getColor() {
        return Color;
    }
}