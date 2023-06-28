package com.perscholas.RealEstate.services;

import com.perscholas.RealEstate.entities.House;

import java.util.List;

public interface HouseService
{
    List<House> getAllHouses();

    void saveHouse(House house);

    House getHouseById(int id);

//
//    House getHouseByAddress(String houseAddress);

    void deleteHouseById(int id);
}
