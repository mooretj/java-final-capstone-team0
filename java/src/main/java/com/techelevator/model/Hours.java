package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

public class Hours {

    @JsonProperty("brewery_id")
    private int breweryId;

    private List<LocalTime> open;
    private List<LocalTime> close;

//    @JsonProperty("sunday_open")
//    private LocalTime sundayOpen;
//    @JsonProperty("sunday_close")
//    private LocalTime sundayClose;
//
//    @JsonProperty("monday_open")
//    private LocalTime mondayOpen;
//    @JsonProperty("monday_close")
//    private LocalTime mondayClose;
//
//    @JsonProperty("tuesday_open")
//    private LocalTime tuesdayOpen;
//    @JsonProperty("tuesday_close")
//    private LocalTime tuesdayClose;
//
//    @JsonProperty("wednesday_open")
//    private LocalTime wednesdayOpen;
//    @JsonProperty("wednesday_close")
//    private LocalTime wednesdayClose;
//
//    @JsonProperty("thursday_open")
//    private LocalTime thursdayOpen;
//    @JsonProperty("thursday_close")
//    private LocalTime thursdayClose;
//
//    @JsonProperty("friday_open")
//    private LocalTime fridayOpen;
//    @JsonProperty("friday_close")
//    private LocalTime fridayClose;
//
//    @JsonProperty("saturday_open")
//    private LocalTime saturdayOpen;
//    @JsonProperty("saturday_close")
//    private LocalTime saturdayClose;

    public Hours() { }

    public Hours(int breweryId, Time sundayOpen, Time sundayClose,
                 Time mondayOpen, Time mondayClose,
                 Time tuesdayOpen, Time tuesdayClose,
                 Time wednesdayOpen, Time wednesdayClose,
                 Time thursdayOpen, Time thursdayClose,
                 Time fridayOpen, Time fridayClose,
                 Time saturdayOpen, Time saturdayClose) {
        this.setBreweryId(breweryId);
        this.open.add(sundayOpen.toLocalTime());
        this.close.add(sundayClose.toLocalTime());
        this.open.add(mondayOpen.toLocalTime());
        this.close.add(mondayClose.toLocalTime());
        this.open.add(tuesdayOpen.toLocalTime());
        this.close.add(tuesdayClose.toLocalTime());
        this.open.add(wednesdayOpen.toLocalTime());
        this.close.add(wednesdayClose.toLocalTime());
        this.open.add(thursdayOpen.toLocalTime());
        this.close.add(thursdayClose.toLocalTime());
        this.open.add(fridayOpen.toLocalTime());
        this.close.add(fridayClose.toLocalTime());
        this.open.add(saturdayOpen.toLocalTime());
        this.close.add(saturdayClose.toLocalTime());
    }

    public int getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(int breweryId) {
        this.breweryId = breweryId;
    }

    public LocalTime getSundayOpen() {
        return open.get(0);
    }

    public void setSundayOpen(Time sundayOpen) {
        this.open.set(0, sundayOpen.toLocalTime());
    }

    public LocalTime getSundayClose() {
        return close.get(0);
    }

    public void setSundayClose(Time sundayClose) {
        this.close.set(0, sundayClose.toLocalTime());
    }

    public LocalTime getMondayOpen() {
        return open.get(1);
    }

    public void setMondayOpen(Time mondayOpen) {
        this.open.set(1, mondayOpen.toLocalTime());
    }

    public LocalTime getMondayClose() {
        return close.get(1);
    }

    public void setMondayClose(Time mondayClose) {
        this.close.set(1, mondayClose.toLocalTime());
    }

    public LocalTime getTuesdayOpen() {
        return open.get(2);
    }

    public void setTuesdayOpen(Time tuesdayOpen) {
        this.open.set(2, tuesdayOpen.toLocalTime());
    }

    public LocalTime getTuesdayClose() {
        return close.get(2);
    }

    public void setTuesdayClose(Time tuesdayClose) {
        this.close.set(2, tuesdayClose.toLocalTime());
    }

    public LocalTime getWednesdayOpen() {
        return open.get(3);
    }

    public void setWednesdayOpen(Time wednesdayOpen) {
        this.open.set(3, wednesdayOpen.toLocalTime());
    }

    public LocalTime getWednesdayClose() {
        return close.get(3);
    }

    public void setWednesdayClose(Time wednesdayClose) {
        this.close.set(3, wednesdayClose.toLocalTime());
    }

    public LocalTime getThursdayOpen() {
        return open.get(4);
    }

    public void setThursdayOpen(Time thursdayOpen) {
        this.open.set(4, thursdayOpen.toLocalTime());
    }

    public LocalTime getThursdayClose() {
        return close.get(4);
    }

    public void setThursdayClose(Time thursdayClose) {
        this.close.set(4, thursdayClose.toLocalTime());
    }

    public LocalTime getFridayOpen() {
        return open.get(5);
    }

    public void setFridayOpen(Time fridayOpen) {
        this.open.set(5, fridayOpen.toLocalTime());
    }

    public LocalTime getFridayClose() {
        return close.get(5);
    }

    public void setFridayClose(Time fridayClose) {
        this.close.set(5, fridayClose.toLocalTime());
    }

    public LocalTime getSaturdayOpen() {
        return open.get(6);
    }

    public void setSaturdayOpen(Time saturdayOpen) {
        this.open.set(6, saturdayOpen.toLocalTime());
    }

    public LocalTime getSaturdayClose() {
        return close.get(6);
    }

    public void setSaturdayClose(Time saturdayClose) {
        this.close.set(6, saturdayClose.toLocalTime());
    }

}
