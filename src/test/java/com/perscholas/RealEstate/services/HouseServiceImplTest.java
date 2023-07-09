package com.perscholas.RealEstate.services;

import com.perscholas.RealEstate.entities.Customer;
import com.perscholas.RealEstate.entities.House;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HouseServiceImplTest
{

    // ---------------------------------VARIABLES ------------------------------
    @Autowired
    private HouseService houseService;
    // ---------------------------------TESTING METHODS ------------------------------
    @Test
    void getAllHouses()
    {
            List<House> allHouses = houseService.getAllHouses();

            int beforeAddingMoreHouses = allHouses.size();

            House house1 = new House();

            house1.setHouseAddress("555 go away st.");
            house1.setHouseCity("Columbus");
            house1.setHouseState("OH");
            house1.setHouseZip(43215);

            houseService.saveHouse(house1);

            int afterAddingMoreHouses = houseService.getAllHouses().size();

            Assertions.assertThat(afterAddingMoreHouses).isEqualTo(beforeAddingMoreHouses + 1);
            Assertions.assertThat(allHouses.contains(house1));

            // verify
        }


}