package com.medeova.exception;

public class PersonalizedException extends RuntimeException {
    public PersonalizedException(String exceptionMessage){
        super(exceptionMessage);
    }
    public PersonalizedException(String exceptionMessage, Exception exception){
        super(exceptionMessage, exception);
    }
}
