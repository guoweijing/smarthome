package com.itheima.domain;

public class house {
    String username;
    String buildname;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBuildname() {
        return buildname;
    }

    public void setBuildname(String buildname) {
        this.buildname = buildname;
    }

    @Override
    public String toString() {
        return "house{" +
                "username='" + username + '\'' +
                ", buildname='" + buildname + '\'' +
                '}';
    }
}
