package com.turbodriver.employee.exception;

public class UserNotFound extends RuntimeException{
    public UserNotFound() {
        super("The user you are trying to retrieve does not exist");
    }
}
