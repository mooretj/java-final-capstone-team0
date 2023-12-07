package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.tomcat.jni.Local;

import java.sql.Time;
import java.time.LocalTime;

public class Hours {

    @JsonProperty("brewery_id")
    private int breweryId;

    @JsonProperty("sunday_open")
    private LocalTime sundayOpen;
    @JsonProperty("sunday_close")
    private LocalTime sundayClose;

    @JsonProperty("monday_open")
    private LocalTime mondayOpen;
    @JsonProperty("monday_close")
    private LocalTime mondayClose;

    @JsonProperty("tuesday_open")
    private LocalTime tuesdayOpen;
    @JsonProperty("tuesday_close")
    private LocalTime tuesdayClose;

    @JsonProperty("wednesday_open")
    private LocalTime wednesdayOpen;
    @JsonProperty("wednesday_close")
    private LocalTime wednesdayClose;

    @JsonProperty("thursday_open")
    private LocalTime thursdayOpen;
    @JsonProperty("thursday_close")
    private LocalTime thursdayClose;

    @JsonProperty("friday_open")
    private LocalTime fridayOpen;
    @JsonProperty("friday_close")
    private LocalTime fridayClose;

    @JsonProperty("saturday_open")
    private LocalTime saturdayOpen;
    @JsonProperty("saturday_close")
    private LocalTime saturdayClose;

    public Hours() { }

    public int getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(int breweryId) {
        this.breweryId = breweryId;
    }

    public LocalTime getSundayOpen() {
        return sundayOpen;
    }

    public void setSundayOpen(LocalTime sundayOpen) {
        this.sundayOpen = sundayOpen;
    }

    public LocalTime getSundayClose() {
        return sundayClose;
    }

    public void setSundayClose(LocalTime sundayClose) {
        this.sundayClose = sundayClose;
    }

    public LocalTime getMondayOpen() {
        return mondayOpen;
    }

    public void setMondayOpen(LocalTime mondayOpen) {
        this.mondayOpen = mondayOpen;
    }

    public LocalTime getMondayClose() {
        return mondayClose;
    }

    public void setMondayClose(LocalTime mondayClose) {
        this.mondayClose = mondayClose;
    }

    public LocalTime getTuesdayOpen() {
        return tuesdayOpen;
    }

    public void setTuesdayOpen(LocalTime tuesdayOpen) {
        this.tuesdayOpen = tuesdayOpen;
    }

    public LocalTime getTuesdayClose() {
        return tuesdayClose;
    }

    public void setTuesdayClose(LocalTime tuesdayClose) {
        this.tuesdayClose = tuesdayClose;
    }

    public LocalTime getWednesdayOpen() {
        return wednesdayOpen;
    }

    public void setWednesdayOpen(LocalTime wednesdayOpen) {
        this.wednesdayOpen = wednesdayOpen;
    }

    public LocalTime getWednesdayClose() {
        return wednesdayClose;
    }

    public void setWednesdayClose(LocalTime wednesdayClose) {
        this.wednesdayClose = wednesdayClose;
    }

    public LocalTime getThursdayOpen() {
        return thursdayOpen;
    }

    public void setThursdayOpen(LocalTime thursdayOpen) {
        this.thursdayOpen = thursdayOpen;
    }

    public LocalTime getThursdayClose() {
        return thursdayClose;
    }

    public void setThursdayClose(LocalTime thursdayClose) {
        this.thursdayClose = thursdayClose;
    }

    public LocalTime getFridayOpen() {
        return fridayOpen;
    }

    public void setFridayOpen(LocalTime fridayOpen) {
        this.fridayOpen = fridayOpen;
    }

    public LocalTime getFridayClose() {
        return fridayClose;
    }

    public void setFridayClose(LocalTime fridayClose) {
        this.fridayClose = fridayClose;
    }

    public LocalTime getSaturdayOpen() {
        return saturdayOpen;
    }

    public void setSaturdayOpen(LocalTime saturdayOpen) {
        this.saturdayOpen = saturdayOpen;
    }

    public LocalTime getSaturdayClose() {
        return saturdayClose;
    }

    public void setSaturdayClose(LocalTime saturdayClose) {
        this.saturdayClose = saturdayClose;
    }

//    public LocalTime getSundayOpen() {
//        return open[0];
//    }
//
//    public void setSundayOpen(LocalTime sundayOpen) {
//        open[0] = sundayOpen;
//    }
//
//    public LocalTime getSundayClose() {
//        return close[0];
//    }
//
//    public void setSundayClose(LocalTime sundayClose) {
//        close[0] = sundayClose;
//    }
//
//    public LocalTime getMondayOpen() {
//        return open[1];
//    }
//
//    public void setMondayOpen(LocalTime mondayOpen) {
//        open[1] = mondayOpen;
//    }
//
//    public LocalTime getMondayClose() {
//        return close[1];
//    }
//
//    public void setMondayClose(LocalTime mondayClose) {
//        close[1] = mondayClose;
//    }
//
//    public LocalTime getTuesdayOpen() {
//        return open[2];
//    }
//
//    public void setTuesdayOpen(LocalTime tuesdayOpen) {
//        open[2] = tuesdayOpen;
//    }
//
//    public LocalTime getTuesdayClose() {
//        return close[2];
//    }
//
//    public void setTuesdayClose(LocalTime tuesdayClose) {
//        close[2] = tuesdayClose;
//    }
//
//    public LocalTime getWednesdayOpen() {
//        return open[3];
//    }
//
//    public void setWednesdayOpen(LocalTime wednesdayOpen) {
//        open[3] = wednesdayOpen;
//    }
//
//    public LocalTime getWednesdayClose() {
//        return close[3];
//    }
//
//    public void setWednesdayClose(LocalTime wednesdayClose) {
//        close[3] = wednesdayClose;
//    }
//
//    public LocalTime getThursdayOpen() {
//        return open[4];
//    }
//
//    public void setThursdayOpen(LocalTime thursdayOpen) {
//        open[4] = thursdayOpen;
//    }
//
//    public LocalTime getThursdayClose() {
//        return close[4];
//    }
//
//    public void setThursdayClose(LocalTime thursdayClose) {
//        close[4] = thursdayClose;
//    }
//
//    public LocalTime getFridayOpen() {
//        return open[5];
//    }
//
//    public void setFridayOpen(LocalTime fridayOpen) {
//        open[5] = fridayOpen;
//    }
//
//    public LocalTime getFridayClose() {
//        return close[5];
//    }
//
//    public void setFridayClose(LocalTime fridayClose) {
//        close[5] = fridayClose;
//    }
//
//    public LocalTime getSaturdayOpen() {
//        return open[6];
//    }
//
//    public void setSaturdayOpen(LocalTime saturdayOpen) {
//        open[6] = saturdayOpen;
//    }
//
//    public LocalTime getSaturdayClose() {
//        return close[6];
//    }
//
//    public void setSaturdayClose(LocalTime saturdayClose) {
//        close[6] = saturdayClose;
//    }

}
