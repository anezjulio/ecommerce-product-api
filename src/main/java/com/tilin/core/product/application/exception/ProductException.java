package com.tilin.core.product.application.exception;

import org.springframework.http.HttpStatus;

public class ProductException extends RuntimeException {

    private HttpStatus httpStatus;
    private String message;
    private Object data;

    public ProductException(HttpStatus httpStatus, String message, Object data) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.data = data;
    }
}
