package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Beer;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBeerDao implements BeerDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcBeerDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Beer getBeerById(int beerId) {
        Beer beer = null;
        String sql = "SELECT beer_id, brewery_id, beer_name, beer_img, beer_description, abv, beer_type, is_available FROM beer WHERE beer_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, beerId);
            if (results.next()) {
                beer = mapRowToBeer(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return beer;
    }

    @Override
    public List<Beer> getBeers() {
        List<Beer> beers = new ArrayList<>();
        String sql = "SELECT beer_id, brewery_id, beer_name, beer_img, beer_description, abv, beer_type, is_available FROM beer";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Beer beer = mapRowToBeer(results);
                beers.add(beer);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return beers;
    }

    @Override
    public List<Beer> getBeerByName(String name) {
        if (name == null) throw new IllegalArgumentException("Name cannot be null");
        List<Beer> beers = new ArrayList<>();
        name = "%" + name + "%";
        String sql = "SELECT beer_id, brewery_id, beer_name, beer_img, beer_description, abv, beer_type, is_available FROM beer WHERE beer_name ILIKE ?";
        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, name);
            while (rowSet.next()) {
                beers.add(mapRowToBeer(rowSet));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return beers;
    }

    @Override
    public Beer createBeer(Beer beer){
        Beer newBeer = null;
        String insertBeerSql = "INSERT INTO beer (brewery_id, beer_name, beer_img, " +
                "beer_description, abv, beer_type, is_available) VALUES (?, ?, ?, ?, ?, ?, ?) " +
                "RETURNING beer_id;";
        try {
            int newBeerId = jdbcTemplate.queryForObject(insertBeerSql, int.class, beer.getName());
            newBeer = getBeerById(newBeerId);
        }  catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newBeer;
    }

    private Beer mapRowToBeer(SqlRowSet rs) {
        Beer beer = new Beer();
        beer.setId(rs.getInt("beer_id"));
        beer.setBreweryId(rs.getInt("brewery_id"));
        beer.setName(rs.getString("beer_name"));
        beer.setImgUrl(rs.getString("beer_img"));
        beer.setDescription(rs.getString("beer_description"));
        beer.setAbv(rs.getDouble("abv"));
        beer.setType(rs.getString("beer_type"));
        beer.setAvailable(rs.getBoolean("is_available"));
        return beer;
    }
}
