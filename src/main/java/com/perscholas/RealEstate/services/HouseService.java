package com.perscholas.RealEstate.services;

import com.perscholas.RealEstate.entities.House;

import java.util.List;

/*
Purpose: This class defines the business logic methods that perform CRUD and other custom operations.
 */
public interface HouseService
{
    List<House> getAllHouses();

    void saveHouse(House house);

    House getHouseById(int id);

//
//    House getHouseByAddress(String houseAddress);

    void deleteHouseById(int id);
}
