package com.happy.model;

public class GroupStudy {
    private static int index;
    private int id;

    private String name;
    private Integer number;

     {
        index++;
        id=index;
    }

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

    @Override
    public String toString() {
        return "GroupStudy{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
