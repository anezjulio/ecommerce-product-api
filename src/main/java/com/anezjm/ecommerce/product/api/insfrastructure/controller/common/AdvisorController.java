package com.anezjm.ecommerce.product.api.insfrastructure.controller.common;

import com.anezjm.ecommerce.product.api.application.dto.common.ErrorResponseDTO;
import com.anezjm.ecommerce.product.api.application.exception.ProductException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
public abstract class AdvisorController {

    protected final Logger logger = LogManager.getLogger(getClass());

    @Autowired
    protected HttpServletRequest request;

    @ExceptionHandler(ProductException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<ErrorResponseDTO> productException(
            HttpStatus httpStatus,
            String message,
            Object data,
            Exception ex) {
        logger.error("Error, " + this.getClass().getName() + " - in request: " + request.getRequestURI(), ex);
        ErrorResponseDTO errorResponse = getErrorResponseDTO(
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                "",
                LocalDateTime.now(),
                request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<ErrorResponseDTO> baseErrorHandleException(Exception ex) {
        logger.error("Error in request: " + request.getRequestURI(), ex);
        ErrorResponseDTO errorResponse = getErrorResponseDTO(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage(),
                "",
                LocalDateTime.now(),
                request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    protected ErrorResponseDTO getErrorResponseDTO(
            HttpStatus httpStatus,
            String message,
            Object data,
            LocalDateTime dateTime,
            String uri) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO();
        errorResponse.setStatus(String.valueOf(httpStatus.value()));
        errorResponse.setMessage(message);
        errorResponse.setData(data);
        errorResponse.setDateTime(dateTime);
        errorResponse.setUri(uri);
        return errorResponse;
    }

}