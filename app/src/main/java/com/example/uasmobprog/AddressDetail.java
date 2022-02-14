package com.example.uasmobprog;

public class AddressDetail {
    private String first,last,city,country,phone,email,picture;

    public AddressDetail(String first, String last, String city, String country, String phone, String email, String picture) {
        this.first = first;
        this.last = last;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.email = email;
        this.picture = picture;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
