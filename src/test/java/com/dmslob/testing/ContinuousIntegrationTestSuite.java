package com.dmslob.testing;

import com.dmslob.testing.controller.ContactsManagementControllerIntegrationTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        DatastoreSystemsHealthTest.class,
        ContactsManagementControllerIntegrationTest.class})
public class ContinuousIntegrationTestSuite {
}
