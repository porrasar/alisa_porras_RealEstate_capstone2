package com.perscholas.RealEstate.controllers;

import com.perscholas.RealEstate.entities.Customer;
import com.perscholas.RealEstate.services.CustomerService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestCustomerControllerTest
{
    @Autowired
    private CustomerService customerService;

    @PersistenceContext
    private EntityManager entityManager;
// -----------------------------------------------------
    @Test
    void test_getCustomerByLastName(String lastName)
    {

        String query = "SELECT * FROM Customer WHERE lastName = :frank";
        List<Customer> result = entityManager.createNativeQuery(query, Customer.class)
                .setParameter("frank", "frank")
                .getResultList();
        Assertions.assertThat(result).isNotEmpty();
    }

}

