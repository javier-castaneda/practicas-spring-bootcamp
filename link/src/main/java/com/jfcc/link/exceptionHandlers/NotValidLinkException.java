package com.jfcc.link.exceptionHandlers;

public class NotValidLinkException extends Exception{

    public NotValidLinkException(String message) {
        super(message);
    }
}
