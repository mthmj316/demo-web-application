package de.mthoma.demowebapp.data;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

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
	void testGetAge_ReturnsCorrect() throws Exception {
        
		String fieldName = "age";
		int expected = 10;
		
        final User pojo = new User();
        final Field field = pojo.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(pojo, expected);

        final int actual = pojo.getAge();

        assertEquals(actual, expected);
	}

	@Test
	void testGetAlias_ReturnsCorrect() throws Exception {
        
		String fieldName = "alias";
		String expected = "some_" + fieldName;
		
        final User pojo = new User();
        final Field field = pojo.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(pojo, expected);

        final String actual = pojo.getAlias();

        assertEquals(actual, expected);
	}

	@Test
	void testGetName_ReturnsCorrect()throws Exception {
        
		String fieldName = "name";
		String expected = "some_" + fieldName;
		
        final User pojo = new User();
        final Field field = pojo.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(pojo, expected);

        final String actual = pojo.getName();

        assertEquals(actual, expected);
	}

	@Test
	void testGetPassword_ReturnsCorrect()throws Exception {
        
		String fieldName = "password";
		String expected = "some_" + fieldName;
		
        final User pojo = new User();
        final Field field = pojo.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(pojo, expected);

        final String actual = pojo.getPassword();

        assertEquals(actual, expected);
	}

	@Test
	void testIsMale()throws Exception {
        
		String fieldName = "male";
		boolean expected = true;
		
        final User pojo = new User();
        final Field field = pojo.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(pojo, expected);

        final boolean actual = pojo.isMale();

        assertEquals(actual, expected);
	}

	@Test
	void testSetAge_SetsCorrect() throws Exception, SecurityException {

		final User pojo = new User();

        int expected = 10;
        
        pojo.setAge(expected);

        final Field field = pojo.getClass().getDeclaredField("age");
        field.setAccessible(true);
        
        int actual = (int)field.get(pojo);
        
        assertEquals(expected, actual);
		
	}

	@Test
	void testSetAlias_SetsCorrect() throws Exception, SecurityException {
		
		final User pojo = new User();

        String expected = "alias-value";
        
        pojo.setAlias(expected);

        final Field field = pojo.getClass().getDeclaredField("alias");
        field.setAccessible(true);
        
        String actual = (String)field.get(pojo);
        
        assertEquals(expected, actual);
	}

	@Test
	void testSetMale_SetsCorrect() throws Exception {
		
		final User pojo = new User();

		String fieldName = "male";
        boolean expected = true;
        
        pojo.setMale(expected);

        final Field field = pojo.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        
        boolean actual = (boolean)field.get(pojo);
        
        assertEquals(expected, actual);
	}

	@Test
	void testSetName_SetsCorrect() throws Exception {
		
		final User pojo = new User();

		String fieldName = "name";
        String expected = "name-value";
        
        pojo.setName(expected);

        final Field field = pojo.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        
        String actual = (String)field.get(pojo);
        
        assertEquals(expected, actual);
	}

	@Test
	void testSetPassword_SetsCorrect() throws Exception {
		
		final User pojo = new User();

        String expected = "password-value";
        
        pojo.setPassword(expected);

        final Field field = pojo.getClass().getDeclaredField("password");
        field.setAccessible(true);
        
        String actual = (String)field.get(pojo);
        
        assertEquals(expected, actual);
	}

}
