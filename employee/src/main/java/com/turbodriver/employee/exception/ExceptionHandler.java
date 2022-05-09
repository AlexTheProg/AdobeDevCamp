package com.turbodriver.employee.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(
            {
                    UserAlreadyExists.class
            })
    public ResponseEntity handle(Exception e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
