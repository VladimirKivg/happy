package com.happy.model;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class GroupStudy {
    private static int index;
    private int id;

    @NotBlank(message = "Name is mandatory")
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupStudy that = (GroupStudy) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, number);
    }

    @Override
    public String toString() {
        return "GroupStudy{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
