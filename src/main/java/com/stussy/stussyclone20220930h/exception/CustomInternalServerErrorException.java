package com.stussy.stussyclone20220930h.exception;

public class CustomInternalServerErrorException extends RuntimeException {
    public CustomInternalServerErrorException(String message){
        super(message);
    }
}
