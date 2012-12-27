package com.meritit.productmanagement.domain;

public class ValidationException extends RuntimeException {

    public static final Type NOT_BLANK = new Type(1, "NOT_BLANK");
    public static final Type TOO_LONG = new Type(2, "TOO_LONG");
    public static final Type NOT_NULL = new Type(3, "NOT_NULL");
    public static final Type INCORRECT_VALUE = new Type(4, "INCORRECT_VALUE");

    public static class Type {
        private int typeCode;
        private String message;

        public Type(int typeCode, String message) {
            this.typeCode = typeCode;
            this.message = message;
        }

        @Override
        public String toString() {
            return typeCode + ":" + message;
        }
    }

    private Object property;
    private Type type;

    public ValidationException(String name, Type type) {
        this.property = name;
        this.type = type;
    }

    public Object getProperty() {
        return property;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString() + "[" + getProperty() + ":" + this.getType() + "]";
    }
}
