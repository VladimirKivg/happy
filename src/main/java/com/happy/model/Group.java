package com.happy.model;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.crypto.Data;

/*@Entity(name = "groups")*/
public class Group {

    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)*/
    private static int count;
    private Integer id = count++;
    private String place;
    // private Data date;
    private Float price;
    private String room;
    private String name;
    private Integer number;

    public String getName() {
        return name;
    }
    public Integer getNumber() {
        return number;
    }

    public Group() {
    }

    public int getId() {
        return id;
    }

  //  public void setId(int id) {
    //    this.id = id;
    //}

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

   /* public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
*/
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {this.room = room;}
    public void setName(String name) {this.name = name;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
}
