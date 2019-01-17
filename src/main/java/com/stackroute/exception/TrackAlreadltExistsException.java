package com.stackroute.exception;

public class TrackAlreadltExistsException extends Exception {
    private String message;

    public TrackAlreadltExistsException(){
    }

    public TrackAlreadltExistsException(String message) {
        super(message);
        this.message = message;
    }
}
