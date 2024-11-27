package com.bhagya.academics.exception;

public class UserNotAdmin extends RuntimeException {
    public UserNotAdmin(String userNotAdmin) {
        super(userNotAdmin);
    }
}
