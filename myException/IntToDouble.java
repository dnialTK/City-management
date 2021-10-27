package myException;

import java.io.Serializable;

public class IntToDouble extends InvalidInput implements Serializable {
    public String toString() {
        return "Enter Int not Double!";
    }
}
