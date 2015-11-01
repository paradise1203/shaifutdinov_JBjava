package com.aidar.model.enums;

public enum Sex {

    MALE("Male"),
    FEMALE("Female");

    private final String type;

    private Sex(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static Sex getSex(Integer n) {
        for (Sex s : values()) {
            if (s.ordinal() == n) {
                return s;
            }
        }
        return null;
    }

}
