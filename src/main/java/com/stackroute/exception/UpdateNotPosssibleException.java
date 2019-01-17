package com.stackroute.exception;

public class UpdateNotPosssibleException extends Exception {
    private String message;

    public UpdateNotPosssibleException(){
    }

    public UpdateNotPosssibleException(String message) {
        super(message);
        this.message = message;
    }
}
