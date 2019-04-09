package com.dmslob.testing.service;

import com.dmslob.testing.data.repos.CustomerContactRepository;
import com.dmslob.testing.domain.CustomerContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactsManagementService {

    @Autowired
    private CustomerContactRepository customerContactRepository;

    public CustomerContact add(CustomerContact aContact) {
        CustomerContact newContact = customerContactRepository.save(aContact);
        return newContact;
    }

    public CustomerContact addContact(CustomerContact aContact) {
        CustomerContact newContact = null;
        if (aContact.getFirstName() != null) {
            newContact = customerContactRepository.save(aContact);
        }
        return newContact;
    }
}
