package com.techelevator.controller;

import com.techelevator.dao.BreweryDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Brewery;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class BreweryController {

    private BreweryDao breweryDao;

    public BreweryController(BreweryDao breweryDao) {
        this.breweryDao = breweryDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/new_brewery", method = RequestMethod.POST)
    public void addBrewery(@Valid @RequestBody Brewery newBrewery) {
        try{
            Brewery brewery = breweryDao.createBrewery((newBrewery));
            if (brewery == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Brewery registration failed.");
            }
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Brewery registration failed.");
        }
    }

    @RequestMapping(path = "/breweries", method = RequestMethod.GET)
    public List<Brewery> list() {
        return breweryDao.getBreweries();
    }

}
