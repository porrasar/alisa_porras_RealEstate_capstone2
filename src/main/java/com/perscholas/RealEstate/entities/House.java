package com.perscholas.RealEstate.entities;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.io.Serializable;


/*
Purpose: This class is to define the House entity -  with variables, constructors and getter/setters and using Springboot.
         This creates the table in the database.
*/
@Entity
public class House implements Serializable
{

    //-----------------VARIABLES ---------------------------------

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hId;
    @NotNull
    @Size(min=4, max=100)
    private String houseAddress;
    private String houseCity;
    private String houseState;
    private Integer houseZip;

    //--------------------------CONSTRUCTOR--------------


    public House(int id, String houseAddress, String houseCity, String houseState, Integer houseZip)
    {
        this.hId = hId;
        this.houseAddress = houseAddress;
        this.houseCity = houseCity;
        this.houseState = houseState;
        this.houseZip = houseZip;
    }

    public House() {
    }

    //- ------------------------GETTER/SETTER---------------------


    public int gethId() {
        return hId;
    }

    public void sethId(int hId) {
        this.hId = hId;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public String getHouseCity() {
        return houseCity;
    }

    public void setHouseCity(String houseCity) {
        this.houseCity = houseCity;
    }

    public String getHouseState() {
        return houseState;
    }

    public void setHouseState(String houseState) {
        this.houseState = houseState;
    }

    public Integer getHouseZip() {
        return houseZip;
    }

    public void setHouseZip(Integer houseZip) {
        this.houseZip = houseZip;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + hId +
                ", houseAddress='" + houseAddress + '\'' +
                ", houseCity='" + houseCity + '\'' +
                ", houseState='" + houseState + '\'' +
                ", houseZip=" + houseZip +
                '}';
    }
}
