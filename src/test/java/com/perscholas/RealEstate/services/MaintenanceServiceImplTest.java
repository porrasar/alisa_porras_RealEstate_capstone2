package com.perscholas.RealEstate.services;

import com.perscholas.RealEstate.entities.House;
import com.perscholas.RealEstate.entities.Maintenance;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MaintenanceServiceImplTest {

    // ---------------------------------VARIABLES ------------------------------
    @Autowired
    private MaintenanceService maintenanceService;

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

}