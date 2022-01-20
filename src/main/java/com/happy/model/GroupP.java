package com.happy.model;

public class GroupP {
    private static int count;
    private int id;
    private String name;

    {id=count++;}

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
