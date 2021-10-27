package myException;

import java.io.Serializable;

public class TerminalExists extends InvalidTravel implements Serializable {
    public String toString() {
        return "This terminal does not exist!";
    }
}
