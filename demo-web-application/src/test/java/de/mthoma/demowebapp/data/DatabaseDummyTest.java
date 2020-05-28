package de.mthoma.demowebapp.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DatabaseDummyTest {

	private static final String NOT_EXISTING_ALIAS = "xxxx";

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
	void testExistsAliasPasswordCombinationTrue() {
		
		DatabaseDummy databaseDummy = new DatabaseDummy();
		
		assertTrue(databaseDummy.existsAliasPasswordCombination("McCabe", "asd98"));
	}

	@Test
	void testExistsAliasPasswordCombinationFalse() {
		
		DatabaseDummy databaseDummy = new DatabaseDummy();
		
		assertFalse(databaseDummy.existsAliasPasswordCombination("McCabe", "xxx"));
	}

	@Test
	void testGetByAlias1() {
		
		DatabaseDummy databaseDummy = new DatabaseDummy();
		
		String expectedAlias = "brainy";
		String actualAlias = databaseDummy.getByAlias(expectedAlias).getAlias();
		
		assertEquals(expectedAlias, actualAlias);
	}
	
	@Test
	void testGetByAlias2() {
		
		DatabaseDummy databaseDummy = new DatabaseDummy();
		
		String expectedAlias = "coloso";
		String actualAlias = databaseDummy.getByAlias(expectedAlias).getAlias();
		
		assertEquals(expectedAlias, actualAlias);
	}
	
	@Test
	void testGetByAliasNoResult() {
		DatabaseDummy databaseDummy = new DatabaseDummy();
		
		User expectedUser = DatabaseDummy.NULL_USER;
		User acutalResult = databaseDummy.getByAlias(NOT_EXISTING_ALIAS);

		assertEquals(expectedUser, acutalResult);
	}
}
