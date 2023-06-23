package com.perscholas.RealEstate.services;

import com.perscholas.RealEstate.entities.Customer;
import com.perscholas.RealEstate.entities.Payment;

import java.util.List;

public interface PaymentService
{

    List<Payment> getAllPayments();

    void savePayment(Payment payment);

    Payment getPaymentById(int id);

//
//    Payment getPaymentByPaymentType(String paymentType);

    void deletePaymentById(int id);

}
