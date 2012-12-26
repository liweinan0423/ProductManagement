package com.meritit.productmanagement.domain;

public class ValidationException extends RuntimeException {
    public static final int NOT_BLANK = 1;
    public static final int TOO_LONG = 2;
    public static final int NOT_NULL = 3;
    private Object property;
    private int type;

    public ValidationException(String name, int type) {
        this.property = name;
        this.type = type;
    }

    public Object getProperty() {
        return property;
    }

    public int getType() {
        return type;
    }
}
