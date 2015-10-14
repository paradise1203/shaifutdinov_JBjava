package com.aidar.util;

public enum  Subject {

    ENGLISH(0, "ENGLISH"),
    MATAN(1, "MATAN"),
    DISCR(2, "DISCR"),
    ALGEM(3, "ALGEM"),
    ALGR(4, "ALGR"),
    PROGR(5, "PROGR");

    private final Integer value;
    private final String type;

    private Subject(Integer value, String type) {
        this.value = value;
        this.type = type;
    }

    private Integer getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public static Subject getSubject(Integer value) {
        for (Subject s : values()) {
            if (s.getValue().equals(value)) {
                return s;
            }
        }
        return null;
    }

}
