package com.example.newapp;

import com.google.gson.annotations.SerializedName;

public class PersonModel {

    public int id;

    public String email;

    public String password;

    public PersonModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PersonModel(int id, String email, String password) {
        super();
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
