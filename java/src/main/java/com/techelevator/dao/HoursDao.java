package com.techelevator.dao;

import com.techelevator.model.Hours;

public interface HoursDao {

    Hours getHoursByBreweryId(int breweryId);

    Hours createHours(Hours hours);

    Hours updateHours(Hours hours);
}
