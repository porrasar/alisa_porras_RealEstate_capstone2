package com.perscholas.RealEstate.services;

import com.perscholas.RealEstate.entities.Maintenance;
import com.perscholas.RealEstate.entities.Payment;
import org.assertj.core.api.Assertions;
import org.hibernate.annotations.CreationTimestamp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.constraints.Digits;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PaymentServiceImplTest
{
    // ---------------------------------VARIABLES ------------------------------
    @Autowired
    private PaymentService paymentService;

    // ---------------------------------TESTING METHODS ------------------------------
    @Test
    void getAllPayments()
    {

        List<Payment> allPayments = paymentService.getAllPayments();

        int beforeAddingMorePayments = allPayments.size();

        Payment paymentService1 = new Payment();

        paymentService1.setPaymentType("Fees");
        paymentService1.setPaymentAmount(85.36);
//        paymentService1.setPaymentTransactionDate();
//        paymentService1.setCreatedDateTime("Carpet Cleaners");

        paymentService.savePayment(paymentService1);

        int afterAddingMorePayments = paymentService.getAllPayments().size();

        Assertions.assertThat(afterAddingMorePayments).isEqualTo(beforeAddingMorePayments + 1);
        Assertions.assertThat(allPayments.contains(paymentService1));

        // verify
    }


}
