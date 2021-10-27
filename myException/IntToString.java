package myException;

import java.io.Serializable;

public class IntToString extends InvalidInput implements Serializable {
    public String toString() {
        return "Enter Int not String!";
    }
}
