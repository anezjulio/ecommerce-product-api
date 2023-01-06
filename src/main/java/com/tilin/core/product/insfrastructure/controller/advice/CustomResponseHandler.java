package com.tilin.core.product.insfrastructure.controller.advice;
import com.tilin.common.error.pojo.ResponseBody;
import com.tilin.common.error.rest.ResponseBodyBuilder;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@ControllerAdvice(basePackages = "com.tilin.core.product")
public class CustomResponseHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        HttpStatus responseStatus = HttpStatus.valueOf(((ServletServerHttpResponse) serverHttpResponse).getServletResponse().getStatus());

        if (responseStatus.is2xxSuccessful() && responseStatus != HttpStatus.PARTIAL_CONTENT) {

            ResponseBody response = this.createResponseBody(serverHttpRequest);

            response.setData(body instanceof Collection ? body : Collections.singletonList(body));

            return response;

        } else if (body instanceof ResponseBody) {

            ResponseBody responseBody = (ResponseBody) body;

            ResponseBody response = this.createResponseBody(serverHttpRequest);

            response.setData(responseBody.getData());
            response.setErrors(responseBody.getErrors());

            return response;
        }

        return body instanceof Collection ? body : Collections.singletonList(body);
    }


    private ResponseBody createResponseBody(ServerHttpRequest serverHttpRequest) {
        return new ResponseBodyBuilder()
                .withMethod(Objects.requireNonNull(serverHttpRequest.getMethod()).name())
                .withOperation(((ServletServerHttpRequest) serverHttpRequest).getServletRequest().getRequestURI())
                .build();
    }

}