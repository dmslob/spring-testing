package com.dmslob;

import com.dmslob.controller.ContactsManagementControllerIntegrationTest;
import com.dmslob.data.repos.CustomerContactRepositoryIntegrationTest;
import com.dmslob.service.ContactsManagementServiceIntegrationTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ContactsManagementServiceIntegrationTest.class, ContactsManagementControllerIntegrationTest.class, CustomerContactRepositoryIntegrationTest.class})
public class AddContactFeatureTestSuite {
    // intentionally empty - Test Suite Setup (annotations) is sufficient
}
