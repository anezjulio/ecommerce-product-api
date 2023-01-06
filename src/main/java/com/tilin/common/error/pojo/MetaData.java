package com.tilin.common.error.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class MetaData {

    @JsonProperty("method")
    private String method;

    @JsonProperty("operation")
    private String operation;

    public MetaData method(String method) {
        this.method = method;
        return this;
    }

    /**
     * Get method
     *
     * @return method
     **/
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public MetaData operation(String operation) {
        this.operation = operation;
        return this;
    }

    /**
     * Get operation
     *
     * @return operation
     **/
    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MetaData metaData = (MetaData) o;
        return Objects.equals(this.method, metaData.method) &&
                Objects.equals(this.operation, metaData.operation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, operation);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MetaData {\n");

        sb.append("  method: ").append(toIndentedString(method)).append("\n");
        sb.append("  operation: ").append(toIndentedString(operation)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n  ");
    }

}