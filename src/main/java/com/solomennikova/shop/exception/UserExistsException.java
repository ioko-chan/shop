package com.solomennikova.shop.exception;

public class UserExistsException  extends Exception{
    public UserExistsException(String message) {
        super(message);
    }
}
