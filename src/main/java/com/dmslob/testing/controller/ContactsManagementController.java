package com.dmslob.testing.controller;

import com.dmslob.testing.domain.ContactImportantOccasion;
import com.dmslob.testing.domain.CustomerContact;
import com.dmslob.testing.service.ContactsManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactsManagementController {

    @Autowired
    private ContactsManagementService contactsManagementService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddContactSubmitFail(@RequestBody CustomerContact aContact) {
        CustomerContact newContact = contactsManagementService.add(aContact);
        if (newContact != null) {
            return "success";
        }
        return "failure";
    }

    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public String processAddContactSubmit(@ModelAttribute CustomerContact aContact) {
        CustomerContact newContact = contactsManagementService.add(aContact);
        if (newContact != null) {
            return "/addContactForm";
        }
        return "redirect:/showAddContact";
    }

    @RequestMapping(value = "/showAddContact", method = RequestMethod.GET)
    public String showAddContact() {
        // implement this
        return "/addContactForm";
    }

    public String processAddContactOccasionSubmit(@ModelAttribute CustomerContact aContact,
                                                  @ModelAttribute ContactImportantOccasion anOccasion) {
        // implement this
        return "/addContactOccasionForm";
    }

    @RequestMapping("/")
    public @ResponseBody
    String greeting() {
        return "Hello World";
    }
}
