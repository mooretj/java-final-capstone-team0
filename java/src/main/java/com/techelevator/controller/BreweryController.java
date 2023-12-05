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

    /**
     * Create a new Brewery
     * @param newBrewery
     */
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/breweries", method = RequestMethod.POST)
    public Brewery addBrewery(@Valid @RequestBody Brewery newBrewery) {
        Brewery brewery = null;
        try {
            brewery = breweryDao.createBrewery(newBrewery);
            if (brewery == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Brewery registration failed.");
            }
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Brewery registration failed.");
        }
        return brewery;
    }

    /**
     * Gets a specific Brewery by its ID
     * @param id
     * @return a single Brewery
     */
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(path = "/breweries/{id}", method = RequestMethod.GET)
    public Brewery getBreweryById(@PathVariable int id) {
        return breweryDao.getBreweryById(id);
        }

    /**
     * Returns all Breweries in the system
     * @param breweryName
     * @return all Breweries
     */
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(path = "/breweries", method = RequestMethod.GET)
    public List<Brewery> getBreweryByName(@RequestParam(required = false, value="name", defaultValue = "") String breweryName) {
        if(breweryName.isEmpty()) {
            return breweryDao.getBreweries();
        }
        else {
            return breweryDao.getBreweryByName(breweryName);
        }
    }

    /**
     * Deletes a brewery by its ID
     * @param id
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/breweries/{id}", method = RequestMethod.DELETE)
    public int deleteBreweryById(@PathVariable int id) {
        return breweryDao.deleteBreweryById(id);
    }

    /**
     * Updates a specific Brewery by its ID
     * @param brewery
     * @param id
     */
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(path = "/breweries/{id}", method = RequestMethod.PUT)
    public Brewery updateBreweryById(@Valid @RequestBody Brewery brewery, @PathVariable int id) {
        if (id != brewery.getId() && brewery.getId() != 0) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Resource ID does not match URL.");
        }
        brewery.setId(id);
        try {
            Brewery updatedBrewery = breweryDao.updateBreweryById(brewery);
            return updatedBrewery;
        }
        catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Brewery not found.");
        }
    }

}
