package Main.Buildings;

import java.io.Serializable;
import java.util.ArrayList;

public class Hotel implements Serializable {

    private final String HotelName;
    private final double ConstructionCost;
    private final int StarsNumber;
    private final ArrayList<Room> Rooms = new ArrayList<>();
    private final ArrayList<HotelFacilities> Services = new ArrayList<>();
    private final String Address;

    public Hotel(String hotelName, double constructionCost, String address, int starsNumber) {
        HotelName = hotelName;
        ConstructionCost = constructionCost;
        Address = address;
        StarsNumber = starsNumber;
    }

    public String getHotelName() {
        return HotelName;
    }

    public double getConstructionCost() {
        return ConstructionCost;
    }

    public int getStarsNumber() {
        return StarsNumber;
    }

    public ArrayList<Room> getRooms() {
        return Rooms;
    }

    public ArrayList<HotelFacilities> getServices() {
        return Services;
    }

    public enum HotelFacilities {
        Gym, SwimmingPool
    }

}