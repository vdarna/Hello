package com.example.department.exception;

public class NotFoundException2 extends Exception{

    private final ErrorCode errorCode;
    private String message;

    public NotFoundException2(ErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public NotFoundException2(ErrorCode errorCode,String message, Throwable cause) {
        super(message, cause);
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
