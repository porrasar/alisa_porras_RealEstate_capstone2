package com.perscholas.RealEstate.entities;


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
    private LocalDateTime paymentDateTime;
//    private java.sql.Timestamp timestamp;
    private double paymentAmount;


    //----------------------------------CONSTRUCTORS-------------------------
      public Payment(String paymentType, LocalDateTime paymentDateTime, double paymentAmount)
    {
        super();
        this.paymentType = paymentType;
        this.paymentDateTime = paymentDateTime;
        this.paymentAmount = paymentAmount;
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

    public LocalDateTime getPaymentDateTime() {
        return paymentDateTime;
    }

    public void setPaymentDateTime(LocalDateTime paymentDateTime) {
        this.paymentDateTime = paymentDateTime;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", paymentType='" + paymentType + '\'' +
                ", paymentDateTime=" + paymentDateTime +
                ", paymentAmount=" + paymentAmount +
                '}';
    }
}
