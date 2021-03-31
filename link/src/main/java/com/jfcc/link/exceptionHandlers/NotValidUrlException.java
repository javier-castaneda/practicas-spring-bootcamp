package com.jfcc.link.exceptionHandlers;

public class NotValidUrlException extends Exception{

    public NotValidUrlException(String url) {
        super(url);
    }
}
