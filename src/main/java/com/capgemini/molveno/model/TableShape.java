package com.capgemini.molveno.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TableShape {
    RECTANGLE, ROUND;

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}