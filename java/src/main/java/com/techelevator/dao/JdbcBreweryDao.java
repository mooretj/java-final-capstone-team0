package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Brewery;
import com.techelevator.model.Contact;
import com.techelevator.model.Hours;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBreweryDao implements BreweryDao {

    private final JdbcTemplate jdbcTemplate;
    private final ContactDao contactDao;
    private final HoursDao hoursDao;

    public JdbcBreweryDao(JdbcTemplate jdbcTemplate, ContactDao contactDao, HoursDao hoursDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.contactDao = contactDao;
        this.hoursDao = hoursDao;
    }

    @Override
    public Brewery getBreweryById(int breweryId) {
        Brewery brewery = null;
        String sql = "SELECT brewery_id, brewery_name, brewery_main_img, website, history FROM brewery WHERE brewery_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, breweryId);
            if (results.next()) {
                brewery = mapRowToBrewery(results);
//                brewery.setContact(contactDao.getContactByBreweryId(brewery.getId()));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return brewery;
    }

    @Override
    public List<Brewery> getBreweryByName(String breweryName) {
        if(breweryName == null) throw new IllegalArgumentException("Brewery name cannot be null");
        List<Brewery> breweries = new ArrayList<>();
        breweryName = "%" + breweryName + "%";
        String sql = "SELECT brewery_id, brewery_name, brewery_main_img, website, history FROM brewery WHERE brewery_name ILIKE ?";
        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, breweryName);
            while (result.next()) {
                Brewery brewery = mapRowToBrewery(result);
//                brewery.setContact(contactDao.getContactByBreweryId(brewery.getId()));
                breweries.add(brewery);
            }
        }
        catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return breweries;
    }

    @Override
    public Brewery createBrewery(Brewery brewery) {
        Brewery newBrewery = new Brewery();
        String insertBrewerySql = "INSERT INTO brewery (brewery_name, brewery_main_img, website, history) " +
                "VALUES (?, ?, ?, ?) RETURNING brewery_id";
        try {
            int newBreweryId = jdbcTemplate.queryForObject(insertBrewerySql, int.class, brewery.getBreweryName(),
                    brewery.getBreweryImg(), brewery.getWebsite(), brewery.getHistory());

            Contact newContact = brewery.getContact();
            newContact.setBreweryId(newBreweryId);
            contactDao.createBreweryContact(newContact);

            Hours newHours = brewery.getHours();
            newHours.setBreweryId(newBreweryId);
            hoursDao.createHours(newHours);

            newBrewery = getBreweryById(newBreweryId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newBrewery;
    }

    @Override
    public List<Brewery> getBreweries() {
        List<Brewery> breweries = new ArrayList<>();
        String sql = "SELECT brewery_id, brewery_name, brewery_main_img, website, history FROM brewery";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Brewery brewery = mapRowToBrewery(results);
//                brewery.setContact(contactDao.getContactByBreweryId(brewery.getId()));
                breweries.add(brewery);
            }
        }
        catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database");
        }
        return breweries;
    }

    @Override
    public int deleteBreweryById(int breweryId) {
        int numberOfRowsAffected = 0;
        String sql = "DELETE FROM brewery WHERE brewery_id = ?;";
        try {
            contactDao.deleteContactByBreweryId(breweryId);
            numberOfRowsAffected = jdbcTemplate.update(sql, breweryId);
        }
        catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to the server.", e);
        }
        catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation.", e);
        }
        return numberOfRowsAffected;
    }

    @Override
    public Brewery updateBreweryById(Brewery brewery) {
        Brewery updatedBrewery = null;
        String sql = "UPDATE brewery SET brewery_name = ?, brewery_main_img = ?, website = ?, history = ? WHERE brewery_id = ?;";
        try {
            int numberOfRows = jdbcTemplate.update(sql, brewery.getBreweryName(), brewery.getBreweryImg(), brewery.getWebsite(), brewery.getHistory(), brewery.getId());
            if (numberOfRows == 0) {
                throw new DaoException("Zero rows affected, expected at least one.");
            } else {
                updatedBrewery = getBreweryById(brewery.getId());
            }
        }
            catch (CannotGetJdbcConnectionException e) {
                throw new DaoException("Unable to connect to the server.", e);
            }
            catch (DataIntegrityViolationException e) {
                throw new DaoException("Data integrity violation.", e);
            }
            return updatedBrewery;
    }

    private Brewery mapRowToBrewery(SqlRowSet b) {
        Brewery brewery = new Brewery();
        brewery.setId(b.getInt("brewery_id"));
        brewery.setBreweryName(b.getString("brewery_name"));
        brewery.setBreweryImg(b.getString("brewery_main_img"));
        brewery.setWebsite(b.getString("website"));
        brewery.setHours(hoursDao.getHoursByBreweryId(brewery.getId()));
        brewery.setHistory(b.getString("history"));
        brewery.setContact(contactDao.getContactByBreweryId(brewery.getId()));
        return brewery;
    }
}
