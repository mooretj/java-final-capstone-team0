package com.techelevator.dao;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.techelevator.model.Brewery;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalTime;
import java.util.List;

public class JdbcBreweryDaoTests extends BaseDaoTests{

    private static final Brewery BREWERY_1 = new Brewery(1,"brewery1", "breweryImage", "testsite1.com", LocalTime.parse("08:01"), LocalTime.parse("23:01"), "Lorem Ipsum 1");
    private static final Brewery BREWERY_2 = new Brewery(2,"brewery2", "breweryImage", "testsite2.com", LocalTime.parse("08:02"), LocalTime.parse("23:02"), "Lorem Ipsum 2");
    private static final Brewery BREWERY_3 = new Brewery(3,"brewery3", "breweryImage", "testsite3.com", LocalTime.parse("08:03"), LocalTime.parse("23:03"), "Lorem Ipsum 3");

    private Brewery testBrewery;

    private JdbcBreweryDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcBreweryDao(jdbcTemplate);
        testBrewery = new Brewery(0, "Test Brewery", "Test Image", "Test Website", LocalTime.parse("00:00"), LocalTime.parse("23:59"), "Test History");
    }

    @Test
    public void getBreweryById_invalid_id_returns_null() {
        Brewery brewery = sut.getBreweryById(-1);
        Assert.assertNull(brewery);
    }

    @Test
    public void getBreweryById_valid_id_returns_brewery() {
        Brewery brewery = sut.getBreweryById(2);
        assertBreweriesMatch(BREWERY_2, brewery);

        brewery = sut.getBreweryById(3);
        assertBreweriesMatch(BREWERY_3, brewery);
    }

    @Test
    public void getBreweries_returns_all_breweries() {
        List<Brewery> breweries = sut.getBreweries();
        Assert.assertNotNull(breweries);
        Assert.assertEquals(3, breweries.size());
        assertBreweriesMatch(BREWERY_1, breweries.get(0));
        assertBreweriesMatch(BREWERY_2, breweries.get(1));
        assertBreweriesMatch(BREWERY_3, breweries.get(2));
    }

    @Test
    public void createBrewery_creates_brewery() {
        Brewery createdBrewery = sut.createBrewery(testBrewery);
        Assert.assertNotNull(createdBrewery);

        int newId = createdBrewery.getId();
        Assert.assertTrue(newId > 0);

        Brewery retrievedBrewery = sut.getBreweryById(newId);
        assertBreweriesMatch(createdBrewery, retrievedBrewery);
    }

    private void assertBreweriesMatch(Brewery expected, Brewery actual) {
        Assert.assertEquals("Brewery id doesn't match", expected.getId(), actual.getId());
        Assert.assertEquals("Brewery name doesn't match", expected.getBreweryName(), actual.getBreweryName());
        Assert.assertEquals("Brewery image doesn't match", expected.getBreweryImg(), actual.getBreweryImg());
        Assert.assertEquals("Brewery website doesn't match", expected.getWebsite(), actual.getWebsite());
        Assert.assertEquals("Brewery Open Hour doesn't match", expected.getOpenHour(), actual.getOpenHour());
        Assert.assertEquals("Brewery Close Hour doesn't match", expected.getCloseHour(), actual.getCloseHour());
        Assert.assertEquals("Brewery history doesn't match", expected.getHistory(), actual.getHistory());
    }
}
