package com.techelevator.controller;

import com.techelevator.dao.BreweryDao;
import com.techelevator.dao.ContactDao;
import com.techelevator.dao.HoursDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Brewery;
import com.techelevator.model.Contact;
import com.techelevator.model.Hours;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class BreweryController {

    private BreweryDao breweryDao;
    private ContactDao contactDao;
    private HoursDao hoursDao;

    public BreweryController(BreweryDao breweryDao, ContactDao contactDao, HoursDao hoursDao) {
        this.breweryDao = breweryDao;
        this.contactDao = contactDao;
        this.hoursDao = hoursDao;
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

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(path = "/breweries/{id}/contact", method = RequestMethod.PUT)
    public Contact updateContactByBreweryId(@Valid @RequestBody Contact contact, @PathVariable int id) {
        if (id != contact.getBreweryId() && contact.getBreweryId() != 0) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Resource ID does not match URL.");
        }
        contact.setBreweryId(id);
        try {
            Contact updatedContact = contactDao.updateContactByBreweryId(contact);
            return updatedContact;
        }
        catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found.");
        }
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(path = "/breweries/{id}/hours", method = RequestMethod.PUT)
    public Hours updateHoursByBreweryId(@Valid @RequestBody Hours hours, @PathVariable int id) {
        if (id != hours.getBreweryId() && hours.getBreweryId() != 0) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Resource ID does not match URL.");
        }
        hours.setBreweryId(id);
        try {
            Hours updatedHours = hoursDao.updateHours(hours);
            return updatedHours;
        }
        catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hours not found.");
        }
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
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Brewery not found.");
        }
    }

}
