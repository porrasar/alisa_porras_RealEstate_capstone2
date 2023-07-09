package com.perscholas.RealEstate.services;

import com.perscholas.RealEstate.entities.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerServiceImplTest
{

    // ---------------------------------VARIABLES ------------------------------
    @Autowired
    private CustomerService customerService;

    // ---------------------------------TESTING METHODS ------------------------------
    @Test
    void getAllCustomers()
    {

            List<Customer> allCustomers = customerService.getAllCustomers();

            int beforeAddingMoreCustomers = allCustomers.size();

            Customer customer1 = new Customer();

            customer1.setLastName("Washing");
            customer1.setFirstName("Pat");
            customer1.setCity("Columbus");
            customer1.setState("OH");
            customer1.setZip(43253);
            customer1.setUserName("Pat");
            customer1.setSecurityName("Pat");


            customerService.saveCustomer(customer1);

            int afterAddingMoreCustomers = customerService.getAllCustomers().size();

            Assertions.assertThat(afterAddingMoreCustomers).isEqualTo(beforeAddingMoreCustomers + 1);
            Assertions.assertThat(allCustomers.contains(customer1));

            // verify
    }

//    @DisplayName("parameterized test")  // example in test_demo
//    @ParameterizedTest(name = "{0} - {1} = {2}")
//    @CsvSource({
//            "0, 1, 1",
//            "1, 2, 3",
//            "49, 51, 100",
//            "1, 100, 101"
//    })
//    void add(int first, int second, int expectedResult) {
//        Customer calculator = new Customer();
//        assertEquals(expectedResult, calculator.add(first, second),
//                () -> first + " + " + second + " should equal " + expectedResult);
//        System.out.println("parameterized test");
//    }


//    @Test
//    void getCustomerById()
//    {
//        List<Customer> allCustomers = customerService.getAllCustomers();
//
//        Customer customer1 = allCustomers.get(0);
//
//        if (customer1 != null)
//        {
//            Customer customer2 = customerService.getCustomerById(customer1.getcId());
//            Assertions.assertThat(customer1).isEqualTo(customer2);
//        }
//    }


}