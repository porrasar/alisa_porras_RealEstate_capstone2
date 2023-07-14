package com.perscholas.RealEstate.services;

import com.perscholas.RealEstate.entities.Customer;
import com.perscholas.RealEstate.entities.Payment;

import java.util.List;

/*
Purpose: This class defines the business logic methods that perform CRUD and other custom operations.
 */
public interface PaymentService
{

    List<Payment> getAllPayments();

    void savePayment(Payment payment);

    Payment getPaymentById(int id);

//
//    Payment getPaymentByPaymentType(String paymentType);

    void deletePaymentById(int id);

}
