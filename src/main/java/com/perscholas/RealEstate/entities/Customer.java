package com.perscholas.RealEstate.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Customer implements Serializable
{

    //-----------------VARIABLES ---------------------------------

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cId;
    @NotNull
    @Size(min=2, max=30)
    private String name;
    private String address;
    private String city;
    private String state;
    private Integer zip;


    @OneToMany(cascade = {CascadeType.ALL})
    private List <Payment> paymentList;

    //--------------------------CONSTRUCTOR--------------


    public Customer(int cId, String name, String address, String city, String state, Integer zip) {
        this.cId = cId;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Customer()
    {
    }
    //- ------------------------GETTER/SETTER---------------------

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
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

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cId=" + cId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", paymentList=" + paymentList +
                '}';
    }
}
