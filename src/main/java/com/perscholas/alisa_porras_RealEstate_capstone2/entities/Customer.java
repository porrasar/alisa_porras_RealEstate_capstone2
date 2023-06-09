package com.perscholas.alisa_porras_RealEstate_capstone2.entities;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Customer
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min=2, max=30)
    private String name;
    private String address;
    private String city;
    private String state;
    private Integer zip;

    //--------------------------CONSTRUCTOR--------------


    public Customer()
    {
    }

//    public Customer(String name, String address, String city, String state, int zip) {
//        this.name = name;
//        this.address = address;
//        this.city = city;
//        this.state = state;
//        this.zip = zip;
//    }

    public Customer(int id, String name, String address, String city, String state, Integer zip) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
//- ------------------------GETTER/SETTER---------------------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

//    public int getZip() {
//        return zip;
//    }
//
//    public void setZip(int zip) {
//        this.zip = zip;
//    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

//    @Override
//    public String toString() {
//        return "Customer{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", address='" + address + '\'' +
//                ", city='" + city + '\'' +
//                ", state='" + state + '\'' +
//                ", zip=" + zip +
//                '}';
//    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                '}';
    }
}
