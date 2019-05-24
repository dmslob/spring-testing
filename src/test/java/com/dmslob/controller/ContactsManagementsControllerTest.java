package com.dmslob.controller;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.dmslob.domain.CustomerContact;
import com.dmslob.service.ContactsManagementService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ContactsManagementController.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContactsManagementsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactsManagementService contactsManagementService;

    @InjectMocks
    private ContactsManagementController contactsManagementController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World")));
    }

    @Test
    public void testAddContactHappyPath() {
        CustomerContact aContact = new CustomerContact();
        aContact.setFirstName("Jenny");
        aContact.setLastName("Johnson");
        // POST our CustomerContact form bean to the controller; check the outcome
        String outcome = contactsManagementController.processAddContactSubmitFail(aContact);
        System.out.println(outcome);
        // Assert THAT the outcome is as expected
        assertThat(outcome, is(equalTo("success")));
    }

    @Test
    public void testAddContactFirstNameMissing() {
        CustomerContact aContact = new CustomerContact();
        // POST our CustomerContact form bean to the controller; check the outcome
        String outcome = contactsManagementController.processAddContactSubmitFail(aContact);
        // Assert THAT the outcome is as expected
        assertThat(outcome, is(equalTo("failure")));
    }

    @Test
    public void testAddContactHappyPathOld() throws Exception {
        // setup mock Contact returned the mock service component
        CustomerContact mockCustomerContact = new CustomerContact();
        mockCustomerContact.setFirstName("Fred");

        when(contactsManagementService.add(any(CustomerContact.class)))
                .thenReturn(mockCustomerContact);
        // simulate the form bean that would POST from the web page
        CustomerContact aContact = new CustomerContact();
        aContact.setFirstName("Fred");
        aContact.setEmail("fredj@myemail.com");
        // simulate the form submit (POST)
        mockMvc.perform(post("/addContact", aContact))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testAddContactBizServiceRuleNotSatisfiedOld() throws Exception {
        // setup a mock response of NULL object returned from the mock service component
        when(contactsManagementService.add(any(CustomerContact.class)))
                .thenReturn(null);
        // simulate the form bean that would POST from the web page
        CustomerContact aContact = new CustomerContact();
        aContact.setLastName("Johnson");
        // simulate the form submit (POST)
        mockMvc
                .perform(post("/addContact", aContact))
                .andExpect(status().is(302))
                .andReturn();
    }

    @Test
    public void testAddContactOccasionHappyPath() throws Exception {
        // implement this
    }
}
