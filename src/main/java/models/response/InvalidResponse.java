package models.response;

import exceptions.*;
import lombok.SneakyThrows;
import models.BaseModel;
import exceptions.UserExists;

import java.util.Map;

public class InvalidResponse extends BaseModel{
    private String field;
    private String message;
    private String requestBodyErrorField;

    private static final Map<InvalidResponse, Class<? extends BaseDataValidationException>> exceptions = Map.of(
            new InvalidResponse("gender","can't be blank, can be male of female"), InvalidGender.class,
            new InvalidResponse("status","can't be blank"), InvalidStatus.class,
            new InvalidResponse("email","has already been taken"), UserExists.class
    );

    @SneakyThrows
    public static BaseDataValidationException getException(InvalidResponse response) {
        // Why lol ^_^? Is there more cool solution which doesn't like a frankenstein? If it exists, find it.
        if (exceptions.containsKey(response)) return exceptions.get(response).getConstructor(String.class).newInstance(response.requestBodyErrorField);
        return new UndefinedException(response.message +"\n "+ response.requestBodyErrorField);
    }



    public InvalidResponse() {
    }

    public InvalidResponse(String field, String message) {
        this.field = field;
        this.message = message;
        this.requestBodyErrorField = "";
    }

    public InvalidResponse(String field, String message, String requestBodyErrorField) {
        this.field = field;
        this.message = message;
        this.requestBodyErrorField = requestBodyErrorField;
    }

    public InvalidResponse(Map<String,String> item) {
        this(item.get("field"), item.get("message"));
        if (item.size() == 3) this.setRequestBodyErrorField(item.get("requestBodyErrorField"));
    }

    public InvalidResponse(InvalidResponse item) {
        this(item.getField(), item.getMessage(), item.getRequestBodyErrorField());
    }



    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequestBodyErrorField() {
        return requestBodyErrorField;
    }

    public void setRequestBodyErrorField(String requestBodyErrorField) {
        this.requestBodyErrorField = requestBodyErrorField;
    }

    @Override
    public String toString() {
        return "InvalidResponse{" +
                "field='" + field + '\'' +
                ", message='" + message + '\'' +
                ", requestBodyErrorField='" + requestBodyErrorField + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvalidResponse that)) return false;

        if (!field.equals(that.field)) return false;
        return message.equals(that.message);
    }

    @Override
    public int hashCode() {
        int result = field.hashCode();
        result = 31 * result + message.hashCode();
        return result;
    }

    @Override
    public Map<String, Object> getMap() {
        return Map.of(
                "field", field,
                "message", message,
                "requestBodyErrorField", requestBodyErrorField
        );
    }
}
