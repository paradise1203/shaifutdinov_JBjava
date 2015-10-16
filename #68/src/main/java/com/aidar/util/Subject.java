package com.aidar.util;

public enum  Subject {

    ENGLISH,
    MATAN,
    DISCR,
    ALGEM,
    ALGR,
    PROGR;

    public static Subject getSubject(Integer n) {
        for (Subject subject : values()) {
            if (subject.ordinal() == n) {
                return subject;
            }
        }
        return null;
    }

}
