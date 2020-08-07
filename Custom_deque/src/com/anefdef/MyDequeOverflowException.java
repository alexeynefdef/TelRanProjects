package com.anefdef;

public class MyDequeOverflowException extends RuntimeException {

    public MyDequeOverflowException() {
        super();
    }

    public MyDequeOverflowException(String message) {
        super(message);
    }
}
