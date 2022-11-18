package com.itheima.domain;

public class Door {
    private String name;
    private String place;
    private String username;

    public Door(String name, String place, String username) {
        this.name = name;
        this.place = place;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Door{" +
                "name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
