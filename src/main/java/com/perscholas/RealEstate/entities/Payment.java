package com.perscholas.RealEstate.entities;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Payment implements Serializable
{
    //-----------------VARIABLES ---------------------------------
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int paymentId;
     private String paymentType;
    private double paymentAmount;
    @CreationTimestamp
    private LocalDateTime createdDateTime;


    //----------------------------------CONSTRUCTORS-------------------------


    public Payment(int paymentId, String paymentType, double paymentAmount, LocalDateTime createdDateTime) {
        this.paymentId = paymentId;
        this.paymentType = paymentType;
        this.paymentAmount = paymentAmount;
        this.createdDateTime = createdDateTime;
    }

    public Payment()
    {
    }
    //- ------------------------GETTER/SETTER---------------------


    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

     public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", paymentType='" + paymentType + '\'' +
                ", paymentAmount=" + paymentAmount +
                ", createdDateTime=" + createdDateTime +
                '}';
    }
}
