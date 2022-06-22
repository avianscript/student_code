package com.techelevator.dao;

import com.techelevator.model.City;

import java.util.ArrayList;
import java.util.List;

public class MemoryCityDao implements  CityDao {

    List<City> cities = new ArrayList<>();

    public MemoryCityDao() {
        City city1 = new City();
        city1.setCityId(10);
        city1.setCityName("City 1");
        city1.setArea(20);
        city1.setPopulation(1000);
        city1.setStateAbbreviation("PA");
        cities.add(city1);


        City city2 = new City();
        city2.setCityId(20);
        city2.setCityName("City 2");
        city2.setArea(20);
        city2.setPopulation(1000);
        city2.setStateAbbreviation("DE");
        cities.add(city2);

    }


    @Override
    public City getCity(int cityId) {
        for (City city : cities) {
            if (city.getCityId() == cityId) {
                return city;
            }
        }
        return null;
    }

    @Override
    public List<City> getCitiesByState(String stateAbbreviation) {
        return null;
    }

    @Override
    public City createCity(City city) {
        return null;
    }

    @Override
    public void updateCity(City city) {

    }

    @Override
    public void deleteCity(int cityId) {

    }
}
