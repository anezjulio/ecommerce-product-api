package com.tilin.core.product.application.exceptions;

public class NoDataFoundException extends CustomException{
    public NoDataFoundException(){}

    @Override
    public String getCode() {
        return "ERROR_404";
    }

    @Override
    public String getDescription() {
        return "No data found";
    }

}
