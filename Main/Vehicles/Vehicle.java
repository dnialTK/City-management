package Main.Vehicles;

import java.io.Serializable;

abstract public class Vehicle implements Serializable {

    private final int ID;
    private final double PurchasePrice;
    private int Capacity;
    private String ManufacturerName;

    public Vehicle(double purchasePrice, int capacity, int iD, String manufacturerName) {
        PurchasePrice = purchasePrice;
        Capacity = capacity;
        ID = iD;
        ManufacturerName = manufacturerName;
    }

    public double getPurchasePrice() {
        return PurchasePrice;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

    public int getID() {
        return ID;
    }

    public String getManufacturerName() {
        return ManufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        ManufacturerName = manufacturerName;
    }

}