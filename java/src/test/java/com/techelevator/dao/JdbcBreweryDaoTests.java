package com.techelevator.dao;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.techelevator.model.Brewery;
import com.techelevator.model.Contact;
import com.techelevator.model.Hours;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalTime;
import java.util.List;

public class JdbcBreweryDaoTests extends BaseDaoTests{

    private static Contact contact1;
    private static Contact contact2;
    private static Contact contact3;
    private static Hours hours1;
    private static Hours hours2;
    private static Hours hours3;
    private static final Brewery BREWERY_1 = new Brewery(1,"brewery1", "breweryImage", "logoImage1", "testsite1.com", hours1, "Lorem Ipsum", contact1);
    private static final Brewery BREWERY_2 = new Brewery(2,"brewery2", "logoImage2", "breweryImage", "testsite2.com", hours2, "Lorem Ipsum 2", contact2);
    private static final Brewery BREWERY_3 = new Brewery(3,"brewery3", "logoImage3", "breweryImage", "testsite3.com", hours3, "Lorem Ipsum 3", contact3);

    private Brewery testBrewery;

    private Contact contact0;
    private Hours hours0;

    private JdbcBreweryDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcBreweryDao(jdbcTemplate);
        testBrewery = new Brewery(0, "Test Brewery", "Test Image", "Test Website", hours0, "Test History", contact0);
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
        Assert.assertEquals("Brewery Hours don't match", expected.getHours(), actual.getHours());
        Assert.assertEquals("Brewery history doesn't match", expected.getHistory(), actual.getHistory());
        Assert.assertEquals("Brewery Contact Doesn't match", expected.getContact(), actual.getContact());
    }
}
