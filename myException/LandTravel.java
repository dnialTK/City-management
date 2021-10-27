package myException;

import java.io.Serializable;

public class LandTravel extends InvalidTravel implements Serializable {
    public String toString() {
        return "Travel should not land!";
    }
}
