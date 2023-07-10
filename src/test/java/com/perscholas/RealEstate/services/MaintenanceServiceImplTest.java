package com.perscholas.RealEstate.services;

import com.perscholas.RealEstate.entities.Customer;
import com.perscholas.RealEstate.entities.House;
import com.perscholas.RealEstate.entities.Maintenance;
import com.perscholas.RealEstate.repositories.MaintenanceRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MaintenanceServiceImplTest {

    // ---------------------------------VARIABLES ------------------------------
    @Autowired
    private MaintenanceService maintenanceService;

    @Autowired
    private MaintenanceRepository maintenanceRepository;

    // ---------------------------------TESTING METHODS ------------------------------
    @Test
    void getAllMaintenances()
    {
        List<Maintenance> allMaintenances = maintenanceService.getAllMaintenances();

        int beforeAddingMoreMaintenances = allMaintenances.size();

        Maintenance maintenance1 = new Maintenance();

        maintenance1.setMaintenanceName("Carpet Cleaners");


        maintenanceService.saveMaintenance(maintenance1);

        int afterAddingMoreMaintenances = maintenanceService.getAllMaintenances().size();

        Assertions.assertThat(afterAddingMoreMaintenances).isEqualTo(beforeAddingMoreMaintenances + 1);
        Assertions.assertThat(allMaintenances.contains(maintenance1));

        // verify
    }
    // -------------------------
    @DisplayName("parameterized test")  // example in test_demo
    @ParameterizedTest
    @ValueSource(strings = {"Plumbing for you", "Electricity Reigns", "We Clean Everything"})

    void test_saveMaintenance_should_save_maintenance_name
                     (Maintenance maintenance, int expectedResult)
    {
        List<Maintenance> allMaintenances = maintenanceService.getAllMaintenances();

        int beforeAddingMoreMaintenances = allMaintenances.size();

        Maintenance maintenance1 = new Maintenance();

//       assertEquals(expectedResult, maintenanceRepository.save(maintenance),
//                () -> first + " + " + second + " should equal " + expectedResult);
//        System.out.println("parameterized test");

        int afterAddingMoreMaintenances = maintenanceService.getAllMaintenances().size();


    }

//    @DisplayName("parameterized test")  // example in test_demo
//    @ParameterizedTest(name = "{0} - {1} = {2}")
//    @CsvSource
//    ({
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


}