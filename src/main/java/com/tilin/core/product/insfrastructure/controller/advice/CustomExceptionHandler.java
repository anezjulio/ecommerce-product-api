package com.tilin.core.product.insfrastructure.controller.advice;

import com.tilin.common.error.GlobalExceptionHandler;
import com.tilin.common.error.application.CommonErrorHandlerService;
import com.tilin.common.error.pojo.ResponseBody;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomExceptionHandler extends GlobalExceptionHandler {

    private final CommonErrorHandlerService commonErrorHandlerService;

    public CustomExceptionHandler(CommonErrorHandlerService commonErrorHandlerService) {
        this.commonErrorHandlerService = commonErrorHandlerService;
    }


    @ExceptionHandler(CustomStatusException.class)
    public ResponseEntity<ResponseBody> handleCustomStatusExceptions(CustomStatusException ex, HttpServletRequest request) {
        return this.commonErrorHandlerService.handleStatusCustomExceptions(ex, request);
    }

    @ExceptionHandler(CustomPartialContentException.class)
    public ResponseEntity<ResponseBody> handleStatusPartialContentExceptions(CustomPartialContentException ex, HttpServletRequest request) {
        return this.commonErrorHandlerService.handlePartialContentExceptions(ex, request);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<ResponseBody> handleHttpServerErrorExceptions(InternalServerErrorException ex, HttpServletRequest request) {
        return this.commonErrorHandlerService.handleHttpServerErrorExceptions(ex, request);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseBody> handleValidationException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        return this.commonErrorHandlerService.handleValidationException(ex, request);
    }


    @ExceptionHandler(NotDataFoundException.class)
    public ResponseEntity<ResponseBody> handleNotDataFoundExceptions(NotDataFoundException ex, HttpServletRequest request) {
        return this.commonErrorHandlerService.handleNotFoundDataExceptions(ex, request);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ResponseBody> handleConstraintViolationException(ConstraintViolationException ex, HttpServletRequest request) {
        return this.commonErrorHandlerService.handleConstraintValidationException(ex, request);
    }

}
