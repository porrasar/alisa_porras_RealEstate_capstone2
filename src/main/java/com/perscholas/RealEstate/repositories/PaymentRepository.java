package com.perscholas.RealEstate.repositories;


import com.perscholas.RealEstate.entities.Department;
import com.perscholas.RealEstate.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>
{

}
