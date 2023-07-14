package com.perscholas.RealEstate.entities;


import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


/*
Purpose: This class is to define the Payment entity -  with variables, constructors and getter/setters and using Springboot.
         This creates the table in the database.
*/
@Entity
public class Payment implements Serializable
{
    //-----------------VARIABLES ---------------------------------
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int paymentId;

    private String paymentType;
    @Digits(integer = 4, fraction = 2, message = "whole and cents")
    private double paymentAmount;
    private Date paymentTransactionDate;
    @CreationTimestamp
    private LocalDateTime createdDateTime;


    //----------------------------------CONSTRUCTORS-------------------------
    public Payment(int paymentId, String paymentType, double paymentAmount, Date paymentTransactionDate, LocalDateTime createdDateTime) {
        this.paymentId = paymentId;
        this.paymentType = paymentType;
        this.paymentAmount = paymentAmount;
        this.paymentTransactionDate = paymentTransactionDate;
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

    public Date getPaymentTransactionDate() {
        return paymentTransactionDate;
    }

    public void setPaymentTransactionDate(Date paymentTransactionDate) {
        this.paymentTransactionDate = paymentTransactionDate;
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
                ", paymentTransactionDate=" + paymentTransactionDate +
                ", createdDateTime=" + createdDateTime +
                '}';
    }
}
