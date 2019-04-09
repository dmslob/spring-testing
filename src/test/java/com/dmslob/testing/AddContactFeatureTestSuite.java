package com.dmslob.testing;

import com.dmslob.testing.controller.ContactsManagementControllerIntegrationTest;
import com.dmslob.testing.data.repos.CustomerContactRepositoryIntegrationTest;
import com.dmslob.testing.service.ContactsManagementServiceIntegrationTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ContactsManagementServiceIntegrationTest.class, ContactsManagementControllerIntegrationTest.class, CustomerContactRepositoryIntegrationTest.class})
public class AddContactFeatureTestSuite {
    // intentionally empty - Test Suite Setup (annotations) is sufficient
}
