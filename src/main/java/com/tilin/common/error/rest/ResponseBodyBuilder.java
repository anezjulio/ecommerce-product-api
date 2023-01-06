package com.tilin.common.error.rest;

import static java.util.Collections.emptyList;

import java.util.*;

import com.tilin.common.error.pojo.ErrorData;
import com.tilin.common.error.pojo.MetaData;
import com.tilin.common.error.pojo.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ResponseBodyBuilder {

  final static Logger LOGGER = LoggerFactory.getLogger(ResponseBodyBuilder.class);

    private MetaData metaData = null;
    private List<Object> data = null;
    private List<ErrorData> errors = null;
    private Map<String, String> errorMetaData;

  public ResponseBodyBuilder() {
        metaData = new MetaData();
        data = emptyList();
    errorMetaData = new HashMap<String, String>();
        errors = new LinkedList<ErrorData>();
    }

    public static ResponseBodyBuilder init(){
        return new ResponseBodyBuilder();
    }

    public ResponseBodyBuilder withMethod(String method) {
    validateErrorListEmpty("set method");
        this.metaData.setMethod(method);
        return this;
    }

    public ResponseBodyBuilder withOperation(String operation) {
    validateErrorListEmpty("set operation");
        this.metaData.setOperation(operation);
        return this;
    }

  public ResponseBodyBuilder withErrorMetaData(Map<String, String> errorMetaData) {
    validateErrorListEmpty("add errorMetadata");
    Set<Map.Entry<String, String>> entries = errorMetaData.entrySet();
    for (Map.Entry<String, String> entrie: entries) {
      this.errorMetaData.put(entrie.getKey(), entrie.getValue());
    }
    return this;
  }

  private void validateErrorListEmpty(String operation) {
    if(!errors.isEmpty()){
      throw new RuntimeException("cannot " + operation + " after error adding");
    }
  }

  public ResponseBodyBuilder withErrorMetaData(String key, String value) {
    validateErrorListEmpty("add errorMetadata");
    this.errorMetaData.put(key, value);
    return this;
  }

  public ResponseBodyBuilder addErrorFromResponseBody(String code, String message, Object dataError) {
    ErrorData error = new ErrorData();
    error.setCode(code);
    error.setMessage(message);
    error.setData(dataError);
    this.errors.add(error);
    return this;
  }

  public ResponseBodyBuilder addErrorFromThrowable(Throwable throwable){
    return addErrorFromThrowable(throwable, false);
  }

  public ResponseBodyBuilder addErrorFromThrowable(Throwable throwable, Boolean skipAddingMetaData) {
    final ErrorData errorData = new ErrorData();
    errorData.setCode(throwable.getClass().getCanonicalName());
    errorData.setMessage(throwable.getMessage());
    StackTraceElement[] stackTrace = throwable.getStackTrace();
    if(stackTrace.length > 0){
      StackTraceElement stackTraceElement = stackTrace[0];
      String className = stackTraceElement.getClassName();
      Integer lineNumber = stackTraceElement.getLineNumber();
      errorData.setDescription(className + ":" + lineNumber);
    }
    if(skipAddingMetaData != true ){
      addErrorMetaData(errorData);
    }
    this.errors.add(errorData);
    return this;
  }

    public ResponseBody build() {
        final ResponseBody responseApiFunctionalityFilter = new ResponseBody();
        responseApiFunctionalityFilter.setData(data);
        responseApiFunctionalityFilter.setErrors(errors);
        responseApiFunctionalityFilter.setMeta(metaData);
        return responseApiFunctionalityFilter;
    }

  public void addErrors(List<ErrorData> errorDataList, Boolean skipAddingMetaData) {
    for (ErrorData errorData:errorDataList) {
      addError(errorData, skipAddingMetaData);
    }
  }

  private void addError(ErrorData errorData, Boolean skipAddingMetaData) {
    if(skipAddingMetaData != true ){
      addErrorMetaData(errorData);
    }
    this.errors.add(errorData);
  }

  public void addErrors(List<ErrorData> errorDataList) {
    addErrors(errorDataList, false);
  }

  private void addErrorMetaData(ErrorData errorData) {
    Set<Map.Entry<String, String>> entries = errorMetaData.entrySet();
    for (Map.Entry<String, String> entry: entries) {
      errorData.put(entry.getKey(), entry.getValue());
    }
  }
}