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
    @RequestMapping(path = "/beers", method = RequestMethod.POST)
    public Beer addBeer(@Valid @RequestBody Beer newBeer) {
        return beerDao.createBeer(newBeer);

    }

    @RequestMapping(path = "/beers", method = RequestMethod.GET)
    public List<Beer> list() {
        return beerDao.getBeers();
    }
}
