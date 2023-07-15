package com.perscholas.RealEstate.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;


/*
Purpose: This class is to define the Customer entity -  with variables, constructors and getter/setters and using Springboot.
         This creates the table in the database.
*/
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
    @Size(min=1, max=75)
    private String firstName;

    @NotNull
    @Size(min=1, max=75)
    private String lastName;

    private String address;

    private String city;

    private String state;

    private Integer zip;

    private String phoneNumber;

    private String userName;


    @OneToMany(cascade = {CascadeType.ALL})
    private List <Payment> paymentList;

    //--------------------------CONSTRUCTOR--------------


    public Customer(int cId, String firstName, String lastName, String address, String city,
                    String state, Integer zip, String phoneNumber, String userName) {
        this.cId = cId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
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

     public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cId=" + cId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", userName='" + userName + '\'' +
                ", paymentList=" + paymentList +
                '}';
    }
}
