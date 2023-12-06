package com.techelevator.model;

public class Contact {
    private int phone;
    private String email;
    private String address;

    public Contact() {}

    public Contact(int phone, String email, String address){
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
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
