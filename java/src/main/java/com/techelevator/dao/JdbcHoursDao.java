package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Hours;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcHoursDao implements HoursDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcHoursDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Hours getHoursByBreweryId(int breweryId) {
        Hours hours = null;
        String sql = "SELECT brewery_id, " +
                "sunday_open, sunday_close, " +
                "monday_open, monday_close, " +
                "tuesday_open, tuesday_close," +
                "wednesday_open, wednesday_close, " +
                "thursday_open, thursday_close, " +
                "friday_open, friday_close, " +
                "saturday_open, saturday_close " +
                "FROM brewery_hours " +
                "WHERE brewery_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, breweryId);
            if (results.next()) {
                hours = mapRowToHours(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return hours;
    }

    @Override
    public Hours createHours(Hours hours) {
        Hours newHours = null;
        String insertSql = "INSERT INTO brewery_hours (brewery_id, " +
                "sunday_open, sunday_close, " +
                "monday_open, monday_close, " +
                "tuesday_open, tuesday_close, " +
                "wednesday_open, wednesday_close, " +
                "thursday_open, thursday_close, " +
                "friday_open, friday_close, " +
                "saturday_open, saturday_close) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) " +
                "RETURNING brewery_id;";
        try {
            int newHoursId = jdbcTemplate.queryForObject(insertSql, int.class, hours.getBreweryId(),
                    hours.getSundayOpen(), hours.getSundayClose(),
                    hours.getMondayOpen(), hours.getMondayClose(),
                    hours.getTuesdayOpen(), hours.getTuesdayClose(),
                    hours.getWednesdayOpen(), hours.getWednesdayClose(),
                    hours.getThursdayOpen(), hours.getThursdayClose(),
                    hours.getFridayOpen(), hours.getFridayClose(),
                    hours.getSaturdayOpen(), hours.getSaturdayClose());
            newHours = getHoursByBreweryId(newHoursId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newHours;
    }

    @Override
    public Hours updateHours(Hours hours) {
        Hours updatedHours = null;
        String sql = "UPDATE brewery_hours SET " +
                "sunday_open = ?, sunday_close = ?, " +
                "monday_open = ?, monday_close = ?, " +
                "tuesday_open = ?, tuesday_close = ?, " +
                "wednesday_open = ?, wednesday_close = ?, " +
                "thursday_open = ?, thursday_close = ?, " +
                "friday_open = ?, friday_close = ?, " +
                "saturday_open = ?, saturday_close = ? " +
                "WHERE brewery_id = ?;";
        try {
            int numRowsAffected = jdbcTemplate.update(sql,
                    hours.getSundayOpen(), hours.getSundayClose(),
                    hours.getMondayOpen(), hours.getMondayClose(),
                    hours.getTuesdayOpen(), hours.getTuesdayClose(),
                    hours.getWednesdayOpen(), hours.getWednesdayClose(),
                    hours.getThursdayOpen(), hours.getThursdayClose(),
                    hours.getFridayOpen(), hours.getFridayClose(),
                    hours.getSaturdayOpen(), hours.getSaturdayClose(),
                    hours.getBreweryId());
            if (numRowsAffected == 0) {
                throw new DaoException("Zero rows affected, expected at least one.");
            } else {
                updatedHours = getHoursByBreweryId(hours.getBreweryId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to the server.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation.", e);
        }
        return updatedHours;
    }

    public Hours mapRowToHours(SqlRowSet rs) {
        Hours hours = new Hours();
        hours.setBreweryId(rs.getInt("brewery_id"));
        hours.setSundayOpen(rs.getTime("sunday_open").toLocalTime());
        hours.setSundayClose(rs.getTime("sunday_close").toLocalTime());
        hours.setMondayOpen(rs.getTime("monday_open").toLocalTime());
        hours.setMondayClose(rs.getTime("monday_close").toLocalTime());
        hours.setTuesdayOpen(rs.getTime("tuesday_open").toLocalTime());
        hours.setTuesdayClose(rs.getTime("tuesday_close").toLocalTime());
        hours.setWednesdayOpen(rs.getTime("wednesday_open").toLocalTime());
        hours.setWednesdayClose(rs.getTime("wednesday_close").toLocalTime());
        hours.setThursdayOpen(rs.getTime("thursday_open").toLocalTime());
        hours.setThursdayClose(rs.getTime("thursday_close").toLocalTime());
        hours.setFridayOpen(rs.getTime("friday_open").toLocalTime());
        hours.setFridayClose(rs.getTime("friday_close").toLocalTime());
        hours.setSaturdayOpen(rs.getTime("saturday_open").toLocalTime());
        hours.setSaturdayClose(rs.getTime("saturday_close").toLocalTime());
        return hours;

//        return new Hours(
//                rs.getInt("brewery_id"),
//                rs.getTime("sunday_open"),
//                rs.getTime("sunday_close"),
//                rs.getTime("monday_open"),
//                rs.getTime("monday_close"),
//                rs.getTime("tuesday_open"),
//                rs.getTime("tuesday_open"),
//                rs.getTime("wednesday_open"),
//                rs.getTime("wednesday_close"),
//                rs.getTime("thursday_open"),
//                rs.getTime("thursday_close"),
//                rs.getTime("friday_open"),
//                rs.getTime("friday_close"),
//                rs.getTime("saturday_open"),
//                rs.getTime("saturday_close"));
    }
}