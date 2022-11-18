package com.itheima.domain;

public class User {
    private int id;
    private String username;
    private String password;
    private String PhoneNumber;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    public User(String username, String password, String PhoneNumber) {
        this.username = username;
        this.password = password;
        this.PhoneNumber = PhoneNumber;
    }

//    public User(String username, String PhoneNumber) {
//        this.username = username;
//        this.PhoneNumber = PhoneNumber;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                '}';
    }
}
