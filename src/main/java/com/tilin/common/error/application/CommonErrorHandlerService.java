package com.tilin.common.error.application;

import javax.servlet.http.HttpServletRequest;

import com.tilin.common.error.pojo.ResponseBody;
import com.tilin.core.product.application.exceptions.CustomException;
import org.springframework.http.ResponseEntity;

public interface CommonErrorHandlerService {
  ResponseEntity<ResponseBody> handleCustomExceptions(CustomException var1, HttpServletRequest var2);
}