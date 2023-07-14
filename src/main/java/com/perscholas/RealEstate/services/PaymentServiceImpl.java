package com.perscholas.RealEstate.services;


import com.perscholas.RealEstate.entities.Customer;
import com.perscholas.RealEstate.entities.Payment;
import com.perscholas.RealEstate.repositories.CustomerRepository;
import com.perscholas.RealEstate.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
Purpose: This class implements the business logic methods that perform CRUD and other custom operations.
 */

@Service
public class PaymentServiceImpl implements PaymentService
{
    //-----------------------------VARIABLES-------------------------------------
    private PaymentRepository paymentRepository;
    private Payment payment;

    //-----------------------------CONSTRUCTOR-------------------------------------
    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository)
    {
        this.paymentRepository = paymentRepository;
    }


    //-----------------------------METHODS------------------------------------
    @Override
    public List<Payment> getAllPayments()
    {
        return paymentRepository.findAll();
    }


    @Override
    public void savePayment(Payment payment)
    {
        paymentRepository.save(payment);
    }


    /**
     * Returns an Employee object based on id argument.
     * <p>
     * Some more description of the method.
     *
     * @param  id  id of an employee
     * @return      Employee object
     */
    @Override
    public Payment getPaymentById(int id)
    {

        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        if (optionalPayment.isPresent()) {
            Payment payment = optionalPayment.get();
            return payment;
        }
        throw new CustomerNotFoundException();
    }

    //    @Override
//    public Customer getCustomerByName(String name)
//    {
//        Customer employee = customerRepository.findFirstByName(name);
//        if (employee == null) {
//            throw new CustomerNotFoundException();
//        }
//        return employee;
//    }
//
    @Override
    public void deletePaymentById(int id)
    {
        paymentRepository.deleteById(id);
    }
}
