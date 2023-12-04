package com.techelevator.controller;

import com.techelevator.dao.BeerDao;
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
<<<<<<< HEAD
    @RequestMapping(path = "/new_beer", method = RequestMethod.POST)
    public Beer addBeer(@Valid @RequestBody Beer newBeer) {
        Beer beer = null;
        try {
            beer = beerDao.createBeer(newBeer);
            if (beer == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User registration failed.");
            }
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "User registration failed.");
        }
        return beer;
    }

    @RequestMapping(path = "/beers/{id}", method = RequestMethod.GET)
    public Beer getBeerById(@PathVariable int id) {
        return beerDao.getBeerById(id);
=======
    @RequestMapping(path = "/beers", method = RequestMethod.POST)
    public Beer addBeer(@Valid @RequestBody Beer newBeer) {
        return beerDao.createBeer(newBeer);

>>>>>>> 24a62e98ae26aaebb82fde37835583eb755259ff
    }

    @RequestMapping(path = "/beers", method = RequestMethod.GET)
    public List<Beer> list(@RequestParam(required = false, value = "name", defaultValue = "")String name) {
        if(name.isEmpty()) {
            return beerDao.getBeers();
        }
        else {
            return beerDao.getBeerByName(name);
        }
    }

    @RequestMapping(path = "/beers/{id}", method = RequestMethod.GET)
    public Beer getBeerById(@PathVariable int id) {
        return beerDao.getBeerById(id);
    }

    @RequestMapping(path = "/beers?beer_name={beerName}", method = RequestMethod.GET)
    public List<Beer> getBeerByName(@RequestParam(required = false) String beerName) {
        return beerDao.getBeerByName(beerName);
    }
}
