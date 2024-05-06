package com.example.department.exception;

public enum ErrorCode {
    // Define error codes and their corresponding messages
    INVALID_INPUT("Invalid input provided %s."),
    RESOURCE_NOT_FOUND("The requested resource was not found %s."),
    DATABASE_ERROR("An error occurred while accessing the database."),
    UNAUTHORIZED_ACCESS("Unauthorized access."),
    // Add more error codes as needed
    ;

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}