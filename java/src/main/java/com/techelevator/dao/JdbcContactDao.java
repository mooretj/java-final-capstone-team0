package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Contact;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcContactDao implements ContactDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcContactDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Contact getContactByBreweryId(int breweryId) {
        Contact contact = null;
        String sql = "SELECT email, phone, brewery_address FROM brewery_contact WHERE brewery_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, breweryId);
            if (results.next()) {
                contact = mapRowToContact(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return contact;
    }

    @Override
    public Contact createBreweryContact(Contact contact) {
        Contact newContact = null;
        String insertBrewerySql = "INSERT INTO brewery_contact (brewery_id, email, phone, brewery_address) " +
                "values (?, ?, ?, ?)";
        try {
            jdbcTemplate.queryForObject(insertBrewerySql, int.class, contact.getBreweryId(), contact.getEmail(), contact.getPhone(), contact.getAddress());
            contact = getContactByBreweryId(contact.getBreweryId());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return contact;
    }

    @Override
    public int deleteContactByBreweryId(int breweryId) {
        int numberOfRowsAffected = 0;
        String sql = "DELETE FROM contact WHERE brewery_id = ?;";
        try {
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
    public Contact updateContactById(Contact contact) {
        Contact updatedContact = null;
        String sql = "UPDATE contact SET email = ?, phone = ?, website = ?, brewery_address = ? WHERE brewery_id = ?;";
        try {
            int numberOfRows = jdbcTemplate.update(sql, contact.getEmail(), contact.getPhone(), contact.getAddress(), contact.getBreweryId());
            if (numberOfRows == 0) {
                throw new DaoException("Zero rows affected, expected at least one.");
            } else {
                updatedContact = getContactByBreweryId(contact.getBreweryId());
            }
        }
        catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to the server.", e);
        }
        catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation.", e);
        }
        return updatedContact;
    }

    private Contact mapRowToContact(SqlRowSet c) {
        Contact contact = new Contact();
        contact.setEmail(c.getString("email"));
        contact.setPhone(c.getString("phone"));
        contact.setAddress(c.getString("brewery_address"));
        return contact;
    }
}
