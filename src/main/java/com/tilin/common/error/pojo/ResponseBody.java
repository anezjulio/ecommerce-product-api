package com.tilin.common.error.pojo;


import static java.util.Collections.emptyList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseBody {

    @JsonProperty("meta")
    private MetaData meta = null;

    @JsonProperty("data")
    private Object data = emptyList();

    @JsonProperty("errors")
    private List<ErrorData> errors = null;

    public ResponseBody meta(MetaData metaData) {
        this.meta = metaData;
        return this;
    }

    public MetaData getMeta() {
        return meta;
    }

    public void setMeta(MetaData meta) {
        this.meta = meta;
    }

    public ResponseBody data(Object data) {
        this.data = data;
        return this;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseBody errors(List<ErrorData> errors) {
        this.errors = errors;
        return this;
    }

    public ResponseBody addErrorsItem(ErrorData errorsItem) {
        if (this.errors == null) {
            this.errors = new ArrayList<>();
        }
        this.errors.add(errorsItem);
        return this;
    }

    public List<ErrorData> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorData> errors) {
        this.errors = errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResponseBody responseApiFunctionality = (ResponseBody) o;
        return Objects.equals(this.meta, responseApiFunctionality.meta) &&
                Objects.equals(this.data, responseApiFunctionality.data) &&
                Objects.equals(this.errors, responseApiFunctionality.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(meta, data, errors);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResponseApiFunctionality {\n");

        sb.append("    metaData: ").append(toIndentedString(meta)).append("\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}