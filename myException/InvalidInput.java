package myException;

import java.io.Serializable;

public class InvalidInput extends RuntimeException implements Serializable {
    InvalidInput() {
        super("Wrong input!");
    }
}

