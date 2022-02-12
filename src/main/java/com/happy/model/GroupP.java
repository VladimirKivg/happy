package com.happy.model;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class GroupP {
    private static int count;
    private int id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    private int number;

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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupP groupP = (GroupP) o;
        return id == groupP.id && number == groupP.number && Objects.equals(name, groupP.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, number);
    }
}
