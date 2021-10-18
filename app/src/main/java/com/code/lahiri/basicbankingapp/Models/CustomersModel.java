package com.code.lahiri.basicbankingapp.Models;

public class CustomersModel {
    int image ;
    String name;
    String phone;
    String email;

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    String balance;
    String address;

    public CustomersModel(int image, String name, String phone, String email , String address , String balance) {
        this.image = image;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.balance = balance;
        this.address = address;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
