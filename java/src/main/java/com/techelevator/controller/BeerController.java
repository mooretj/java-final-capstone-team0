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


//    @RequestMapping(path = "/beers", method = RequestMethod.GET)
//    public List<Beer> list(@RequestParam(required = false, value = "name", defaultValue = "")String name) {
//        if(name.isEmpty()) {
//            return beerDao.getBeers();
//        }
//        else {
//            return beerDao.getBeerByName(name);
//        }
//    }

    @RequestMapping(path = "breweries/{breweryId}/beers", method = RequestMethod.GET)
    public List<Beer> list(@PathVariable int breweryId) {
        return beerDao.getBeersByBreweryId(breweryId);
    }

    @RequestMapping(path = "breweries/{breweryId}/beers/{beerId}", method = RequestMethod.GET)
    public Beer getBeerById(@PathVariable int beerId) {
        return beerDao.getBeerById(beerId);
    }

    @RequestMapping(path = "breweries/{breweryId}/beers/{beerId}", method = RequestMethod.DELETE)
    public int deleteBeerById(@PathVariable int beerId) {
        return beerDao.deleteBeerById(beerId);
    }

//    @RequestMapping(path = "/beers?beer_name={beerName}", method = RequestMethod.GET)
//    public List<Beer> getBeerByName(@RequestParam(required = false) String beerName) {
//        return beerDao.getBeerByName(beerName);
//    }
}
