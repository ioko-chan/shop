package com.solomennikova.shop.exception;

public class CakeNotFoundException extends RuntimeException{

    public CakeNotFoundException(String message) {
        super(message);
    }
}
