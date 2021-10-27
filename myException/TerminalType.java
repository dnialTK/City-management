package myException;

import java.io.Serializable;

public class TerminalType extends InvalidTravel implements Serializable {
    public String toString() {
        return "The type of terminal of origin and destination must be the same!";
    }
}
