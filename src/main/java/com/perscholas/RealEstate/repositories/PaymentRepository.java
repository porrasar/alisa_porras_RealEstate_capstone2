package com.perscholas.RealEstate.repositories;


import com.perscholas.RealEstate.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
Purpose: This class is to communicate with the database in order to access and persist the data.
*/
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>
{

}
