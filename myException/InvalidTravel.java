package myException;

import java.io.Serializable;

public class InvalidTravel extends RuntimeException implements Serializable {
    InvalidTravel() {
        super("Invalid travel!");
    }
}

