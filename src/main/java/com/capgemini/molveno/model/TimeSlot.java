package com.capgemini.molveno.model;

import java.util.List;

public class TimeSlot {
    private Time startTime;
    private Time endTime;
    private boolean available;
    private List<Table> tables;

    public TimeSlot(Time startTime) {
        this.startTime = startTime;
        this.endTime = new Time(startTime.getHours() + 2, startTime.getMinutes());
    }

    public Time getStartTime() {

        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }
}
