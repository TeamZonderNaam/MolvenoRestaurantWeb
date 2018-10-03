package com.capgemini.molveno.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TableStatus {
    AVAILABLE, BOOKED, BLOCKED;

    @JsonValue
    public int toValue() {
        return ordinal();
    }

}
