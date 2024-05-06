package com.example.department.handler;

import com.example.department.exception.NotFoundException;
import com.example.department.exception.NotFoundException2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleException(NotFoundException exception) {
        // Custom handling logic goes here


       String msg = String.format(exception.getErrorCode().getMessage(),
               exception.getMessage());
        String errorMessage = "An exception occurred: " + exception.getMessage();
        // Additional handling actions, such as logging or sending notifications, can be added here

        return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(NotFoundException2.class)
    public ResponseEntity<String> handleException2(NotFoundException2 exception) {
        // Custom handling logic goes here
System.out.println("Exception"+exception.getCause());
        String msg = String.format(exception.getErrorCode().getMessage(),
                exception.getMessage());
        String response = msg+exception.getCause();
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
