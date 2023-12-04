package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Brewery;
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

    public JdbcBreweryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Brewery getBreweryById(int id) {
        Brewery brewery = null;
        String sql = "SELECT brewery_id, brewery_name, website, open_hour, close_hour, history FROM brewery WHERE brewery_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                brewery = mapRowToBrewery(results);
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
        String sql = "SELECT brewery_id, brewery_name, website, open_hour, close_hour, history FROM brewery WHERE brewery_name ILIKE ?";
        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, breweryName);
            while (result.next()) {
                breweries.add(mapRowToBrewery(result));
            }
        }
        catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return breweries;
    }

    @Override
    public Brewery createBrewery(Brewery brewery) {
        Brewery newBrewery = null;
        String insertBrewerySql = "INSERT INTO brewery (brewery_name, website, open_hour, close_hour, history) " +
                "values (?, ?, ?, ?, ?) RETURNING brewery_id";
        try {
            int newBreweryId = jdbcTemplate.queryForObject(insertBrewerySql, int.class, brewery.getBreweryName(), brewery.getWebsite(),
                    brewery.getOpenHour(), brewery.getCloseHour(), brewery.getHistory());
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
        String sql = "SELECT brewery_id, brewery_name, website, open_hour, close_hour, history FROM brewery";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Brewery brewery = mapRowToBrewery(results);
                breweries.add(brewery);
            }
        }
        catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database");
        }
        return breweries;
    }

        private Brewery mapRowToBrewery(SqlRowSet b) {
            Brewery brewery = new Brewery();
            brewery.setId(b.getInt("brewery_id"));
            brewery.setBreweryName(b.getString("brewery_name"));
            brewery.setWebsite(b.getString("website"));
            brewery.setOpenHour(b.getTime("open_hour").toLocalTime());
            brewery.setCloseHour(b.getTime("close_hour").toLocalTime());
            brewery.setHistory(b.getString("history"));
            return brewery;
        }
}
