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
public class JdbcBeerDao implements BeerDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcBeerDao(JdbcTemplate jdbcTemplate) {
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
    public List<Beer> getBeersByBreweryId(int breweryId) {
        List<Beer> beers = new ArrayList<>();
        String sql = "SELECT beer_id, brewery_id, beer_name, beer_img, beer_description, abv, beer_type, is_available FROM beer WHERE brewery_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, breweryId);
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

        }catch(CannotGetJdbcConnectionException e){
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
        String brewBeerSql = "INSERT INTO brewery_beer (brewery_id, beer_id) VALUES (?, ?) RETURNING brewery_id";
        try {
            int newBeerId = jdbcTemplate.queryForObject(insertBeerSql, int.class, beer.getBreweryId(), beer.getName(), beer.getImgUrl(), beer.getDescription(),
                    beer.getAbv(), beer.getType(), beer.isAvailable());
            jdbcTemplate.queryForObject(brewBeerSql, int.class, beer.getBreweryId(), newBeerId);
            newBeer = getBeerById(newBeerId);
        }  catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newBeer;
    }

    @Override
    public int deleteBeerById(int id) {
        int rowsAffected = 0;
        String reviewSql = "DELETE FROM review WHERE beer_id = ?";
        String brewerySql = "DELETE FROM brewery_beer WHERE beer_id = ?";
        String sql = "DELETE FROM beer WHERE beer_id = ?;";
        try {
            jdbcTemplate.update(reviewSql, id);
            jdbcTemplate.update(brewerySql, id);
           rowsAffected = jdbcTemplate.update(sql, id);
        }
        catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to the server.", e);
        }
        catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation.", e);
        }
        return rowsAffected;
    }

    @Override
    public Beer updateBeerById(Beer beer) {
        Beer updatedBeer = null;
        String sql = "UPDATE beer SET beer_name = ?, beer_img = ?, beer_description = ?, abv = ?, beer_type = ?, is_available = ? WHERE beer_id = ?;";
        try {
            int numberOfRows = jdbcTemplate.update(sql, beer.getName(), beer.getImgUrl(), beer.getDescription(), beer.getAbv(), beer.getType(), beer.isAvailable(), beer.getBeerId());
            if (numberOfRows == 0) {
                throw new DaoException("Zero rows affected, expected at least one.");
            }
            else {
                updatedBeer = getBeerById(beer.getBeerId());
            }
        }
        catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to the server.", e);
        }
        catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation.", e);
        }
        return updatedBeer;
    }

    @Override
    public List<Integer> getBeerIds() {
        List<Integer> beerIds = new ArrayList<>();
        String sql = "SELECT beer_id FROM beer ORDER BY RANDOM() LIMIT 3";
        try {

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

            while (results.next()) {
                Integer id = results.getInt("beer_id");
                beerIds.add(id);

            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return beerIds;
    }

    private Beer mapRowToBeer(SqlRowSet rs) {
        Beer beer = new Beer();
        beer.setBeerId(rs.getInt("beer_id"));
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
