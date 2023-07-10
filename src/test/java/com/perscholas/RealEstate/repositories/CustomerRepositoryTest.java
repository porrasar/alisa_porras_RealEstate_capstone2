package com.perscholas.RealEstate.repositories;

import com.perscholas.RealEstate.entities.Customer;
import com.perscholas.RealEstate.services.CustomerService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;





@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerRepositoryTest
{
    //--------------------------------VARIABLES ---------------------------

    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;


    //--------------------------------METHODS ---------------------------

    @Test
    void findByUserName_should_return_customer_with_specific_userName()
    {
        Customer customer = customerRepository.findByUserName("june");

        Assertions.assertThat(customer.getUserName()).isEqualTo("june");
    }
    @Test
    void findByLastName_should_return_customers_with_specific_lastName()
    {
        List<Customer> customers = customerRepository.findByLastName("frank");

        Assertions.assertThat(customers.size()).isEqualTo(2);
    }

    @Test
    void findByFirstName_should_return_customers_with_specific_firstName()
    {
        List<Customer> customers = customerRepository.findByFirstName("hen");

        Assertions.assertThat(customers.size()).isEqualTo(1);
    }

    @Test
    void findByState_should_return_customers_within_a_specific_state()
    {
        List<Customer> customers = customerRepository.findByState("oh");

        Assertions.assertThat(customers.size()).isEqualTo(3);

    }


}