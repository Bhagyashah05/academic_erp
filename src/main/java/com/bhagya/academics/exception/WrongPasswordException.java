package com.bhagya.academics.exception;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException(String wrongPassword) {
        super(wrongPassword);
    }
}
