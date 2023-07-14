package com.perscholas.RealEstate.repositories;


import com.perscholas.RealEstate.entities.Customer;
import com.perscholas.RealEstate.entities.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
Purpose: This class is to communicate with the database in order to access and persist the data.
*/
@Repository
public interface HouseRepository extends JpaRepository<House, Integer>
{

}
