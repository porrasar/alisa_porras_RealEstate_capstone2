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
    void getAllMaintenances_should_return_that_a_new_record_has_been_added()
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

    @DisplayName("Parameterized Test")
    @ParameterizedTest
    @ValueSource(strings = {"Plumbing for you Company", "Electricity Reigns, Inc.", "We Clean Everything LLC"})

    void saveMaintenance_should_save_each_maintenance_company_name(String nameOfCompany)
    {
        List<Maintenance> allMaintenances = maintenanceService.getAllMaintenances();

        int beforeAddingMoreMaintenances = allMaintenances.size();

        Maintenance maintenance1 = new Maintenance(nameOfCompany);
        maintenanceService.saveMaintenance(maintenance1);

        int afterAddingMoreMaintenances = maintenanceService.getAllMaintenances().size();

        Assertions.assertThat(afterAddingMoreMaintenances).isEqualTo(beforeAddingMoreMaintenances + 1);
        Assertions.assertThat(allMaintenances.contains(maintenance1));

    }
}