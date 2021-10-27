package myException;

import java.io.Serializable;

public class CancelTravel extends RuntimeException implements Serializable {
    CancelTravel() {
        super("The travel was canceled!");
    }
}

