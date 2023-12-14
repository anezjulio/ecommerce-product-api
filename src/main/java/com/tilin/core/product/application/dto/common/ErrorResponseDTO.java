package com.tilin.core.product.application.dto.common;

import java.time.LocalDateTime;

public class ErrorResponseDTO {
    private String status;
    private String message;
    private Object data;
    private String uri;
    private LocalDateTime dateTime;

    public ErrorResponseDTO() {}

    public ErrorResponseDTO(String status, String message, Object data, String uri, LocalDateTime dateTime) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.uri = uri;
        this.dateTime = dateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
