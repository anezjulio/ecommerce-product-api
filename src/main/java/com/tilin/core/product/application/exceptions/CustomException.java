package com.tilin.core.product.application.exceptions;

public abstract class CustomException extends Exception {
    protected CustomException(){}

    protected CustomException(String message){
        super(message);
    }

    public abstract String getCode();
    public abstract String getDescription();

}
