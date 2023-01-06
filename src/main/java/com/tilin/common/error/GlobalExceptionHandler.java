package com.tilin.common.error;


import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import pom.cross.commons.error.handler.model.ErrorHandlerErrorContainer;
import pom.cross.commons.error.handler.service.ErrorHandlerErrorSerializer;

@ControllerAdvice
@Order(-2147483648)
public class GlobalExceptionHandler {
    static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @Autowired
    ErrorHandlerErrorSerializer errorHandlerErrorSerializer;

    public GlobalExceptionHandler() {
    }

    @ResponseBody
    @ExceptionHandler({Exception.class})
    private ResponseEntity<String> handleAllExceptions(Exception exception, HttpServletRequest httpServletRequest) {
        ErrorHandlerErrorContainer errorHandlerErrorContainer = this.errorHandlerErrorSerializer.serialize(exception);
        HttpStatus httpStatus = errorHandlerErrorContainer.getHttpStatus();
        HttpHeaders headers = this.toHttpHeaders(errorHandlerErrorContainer.getHeaders());
        String content = errorHandlerErrorContainer.getContent();
        return new ResponseEntity(content, headers, httpStatus);
    }

    private HttpHeaders toHttpHeaders(Map<String, String> headers) {
        HttpHeaders result = new HttpHeaders();
        Iterator var3 = headers.entrySet().iterator();

        while(var3.hasNext()) {
            Entry<String, String> entry = (Entry)var3.next();
            result.put((String)entry.getKey(), Collections.singletonList(entry.getValue()));
        }

        return result;
    }
}
