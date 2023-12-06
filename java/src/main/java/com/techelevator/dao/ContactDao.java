package com.techelevator.dao;

import com.techelevator.model.Contact;

public interface ContactDao {
    Contact getContactByBreweryId(int breweryId);
    Contact createBreweryContact(Contact contact);
    int deleteContactByBreweryId(int breweryId);
    Contact updateContactById(Contact contact);
}
