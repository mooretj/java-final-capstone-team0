package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contact {
    @JsonProperty("brewery_id")
    private int breweryId;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("email")
    private String email;
    @JsonProperty("brewery_address")
    private String address;

    public Contact() {}

    public Contact(int breweryId, String phone, String email, String address){
        this.breweryId = breweryId;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public int getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(int breweryId) {
        this.breweryId = breweryId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
