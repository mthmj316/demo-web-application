package de.mthoma.demowebapp.data;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserDataAccessFactoryTest {
	
	@Autowired
	private UserDataAccessFactory useDataAccessFactory;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test if the dependency injection works. 
	 */
	@Test
	void testGetUserDataAccess() {
		
		assertNotNull(this.useDataAccessFactory.getUserDataAccess(), "userDataAccess attribute is null!");
	}
}
