package com.techelevator.controller;

import com.techelevator.dao.BeerDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Beer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class BeerController {

    private BeerDao beerDao;

    public BeerController(BeerDao beerDao) {
        this.beerDao = beerDao;
    }

    /**
     * Create a new Beer for a specific Brewery
     * @param breweryId
     * @param newBeer
     */
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "breweries/{breweryId}/beers", method = RequestMethod.POST)
    public Beer addBeer(@PathVariable int breweryId, @Valid @RequestBody Beer newBeer) {
        Beer beer = null;
        try {
            beer = beerDao.createBeer(newBeer);
            if (beer == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Beer registration failed.");
            }
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Beer registration failed.");
        }
        return beer;
    }


    @RequestMapping(path = "breweries/{breweryId}/beers", method = RequestMethod.GET)
    public List<Beer> list(@PathVariable int breweryId) {
        if(breweryId == 0) {
            return beerDao.getBeers();
        }
        else {
            return beerDao.getBeersByBreweryId(breweryId);
        }
    }

    /**
     * Gets a specific beer by its ID
     * @param beerId
     * @return One beer
     */
    @RequestMapping(path = "/beers/{beerId}", method = RequestMethod.GET)
    public Beer getBeerById(@PathVariable int beerId) {
        return beerDao.getBeerById(beerId);
    }

    /**
     * Deletes a beer by its ID
     * @param beerId
     */
    @RequestMapping(path = "/beers/{beerId}", method = RequestMethod.DELETE)
    public int deleteBeerById(@PathVariable int beerId) {
        return beerDao.deleteBeerById(beerId);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(path = "/beers/{beerId}", method = RequestMethod.PUT)
    public Beer updateBeerById(@Valid @RequestBody Beer beer, @PathVariable int beerId) {
        if (beerId != beer.getBeerId() && beer.getBeerId() != 0) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Resource ID does not match URL.");
        }
        beer.setBeerId(beerId);
        try {
            Beer updatedBeer = beerDao.updateBeerById(beer);
            return updatedBeer;
        }
        catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Beer not found.");
        }
    }
}
