package com.tilin.common.error.pojo;

import java.util.HashMap;

public class ErrorData extends HashMap<String, Object> {

    private static final long serialVersionUID = 2888423549350883433L;
    private String codeKey = "code";
    private String messageKey = "message";
    private String descriptionKey = "description";
    private String dataKey = "data";

    public String getCode() {
        return (String) get(codeKey);
    }

    public void setCode(String code) {
        put(codeKey, code);
    }

    public String getMessage() {
        return (String) get(messageKey);
    }

    public void setMessage(String message) {
        put(messageKey, message);
    }

    public String getDescription() {
        return (String) get(descriptionKey);
    }

    public void setDescription(String description) {
        put(descriptionKey, description);
    }

    public Object getData() {
        return get(dataKey);
    }

    public void setData(Object data) {
        put(dataKey, data);
    }


}