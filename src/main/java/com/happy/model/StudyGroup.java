package com.happy.model;

import java.util.Objects;

public class StudyGroup {
    private static int count;
    private int id;
    private String name;
    private int number;

    public StudyGroup( String name, int number) {
        this.id = count++;
        this.name = name;
        this.number = number;
    }

    public StudyGroup() {
        this.id = count++;
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
        StudyGroup that = (StudyGroup) o;
        return id == that.id && number == that.number && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, number);
    }

    @Override
    public String toString() {
        return "StudyGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
