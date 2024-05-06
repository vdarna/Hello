package com.example.department.exception;

public class NotFoundException extends Exception{

    private final ErrorCode errorCode;
    private String message;

    public NotFoundException(ErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
