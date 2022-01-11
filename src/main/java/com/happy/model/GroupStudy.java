package com.happy.model;

public class GroupStudy {
    private static int id;
    private String name;
    private Integer number;

    {++id;}

    public GroupStudy( String name, Integer number) {

        this.name = name;
        this.number = number;
    }

    public GroupStudy() {
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
