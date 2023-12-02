package com.techelevator.controller;

import com.techelevator.dao.BeerDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Beer;
import com.techelevator.model.RegisterUserDto;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class BeerController {

    private BeerDao beerDao;

    public BeerController(BeerDao beerDao) {
        this.beerDao = beerDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/new-beer", method = RequestMethod.POST)
    public void addBeer(@Valid @RequestBody Beer newBeer) {
        try {
            Beer beer = beerDao.createBeer(newBeer);
            if (beer == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User registration failed.");
            }
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "User registration failed.");
        }
    }
}
