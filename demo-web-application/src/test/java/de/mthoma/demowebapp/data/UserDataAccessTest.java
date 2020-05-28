package de.mthoma.demowebapp.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserDataAccessTest {

	@Autowired
	private UserDataAccess userDataAccess;
	
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

	@Test
	void testGetUser_Success() {
		
		String expectedName = "David Brain";
		String actualName = this.userDataAccess.getUser("brainy").getName();
		
		assertEquals(expectedName, actualName);
	}
	
	@Test
	void testGetUser_NoResult() {
		
		User expected = DatabaseDummy.NULL_USER;
		User actual = this.userDataAccess.getUser("this alias doesn't exists");
		
		assertEquals(expected, actual);
	}

	@Test
	void testVerifyLogin_Success() {
		
		String loginAlias = "mila";
		String password = "0815Witz";
		
		assertTrue(this.userDataAccess.verifyLogin(loginAlias, password));;
	}

	@Test
	void testVerifyLogin_Fail() {
		
		String loginAlias = "mila";
		String password = "wrong password";
		
		assertFalse(this.userDataAccess.verifyLogin(loginAlias, password));;
	}
}
