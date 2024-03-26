package com.maojiu;

public class HelloSpring {
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public void show() {
        System.out.println(username + ": welcome to Spring");
    }
}
