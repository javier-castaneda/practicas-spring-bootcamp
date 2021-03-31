package com.jfcc.link.exceptionHandlers;

public class NotValidIdException extends Exception{

    public NotValidIdException(String id) {
        super(id);
    }
}
