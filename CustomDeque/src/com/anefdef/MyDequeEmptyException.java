package com.anefdef;

public class MyDequeEmptyException extends RuntimeException {

    public MyDequeEmptyException() {
        super();
    }

    public MyDequeEmptyException(String message) {
        super(message);
    }
}
