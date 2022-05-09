package com.turbodriver.employee.exception;

public class UserAlreadyExists extends RuntimeException{
    public UserAlreadyExists() {
        super("The user you are trying to add already exists");
    }
}
