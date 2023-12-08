package com.techelevator.dao;

import com.techelevator.model.Beer;

import java.util.List;

public interface BeerDao {

    List<Beer> getBeers();

    Beer getBeerById(int beerId);

    List<Beer> getBeerByName(String name);

    Beer createBeer(Beer beer);

    int deleteBeerById(int id);

    List<Beer> getBeersByBreweryId(int breweryId);

    Beer updateBeerById(Beer beer);

    List<Integer> getBeerIds();
}
