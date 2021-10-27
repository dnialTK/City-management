package Main.Buildings;

import java.io.Serializable;

public class Room implements Serializable {

    private final int RoomNumber;
    private final int BedsNumber;
    private final double Area;
    private final double AccommodationPrice;

    public Room(int roomNumber, int bedsNumber, double area, double accommodationPrice) {
        RoomNumber = roomNumber;
        BedsNumber = bedsNumber;
        Area = area;
        AccommodationPrice = accommodationPrice;
    }

    public double getAccommodationPrice() {
        return AccommodationPrice;
    }
}