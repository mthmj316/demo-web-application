package de.mthoma.demowebapp.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.boot.test.context.SpringBootTest;

import de.mthoma.demowebapp.DemoWebApplication;
import de.mthoma.demowebapp.DemoWebApplicationTests;
import de.mthoma.demowebapp.utils.SeleniumCore;

@SpringBootTest
public class LoginPageUITest {
	
	private static WebDriver DRIVER = SeleniumCore.getDriver(); 
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		DRIVER.manage().window().maximize();
		DRIVER.get(DemoWebApplicationTests.HTTP_LOCALHOST_8082_DEMOWEBAPP_LOGIN);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		DRIVER.close();
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	/**
	 * Test if the attribute lang == en
	 */
	@Test
	public void testHTMLTagAttrLang() {
		
		WebElement htmlTag = DRIVER.findElement(By.id("html"));
		
		String actual = htmlTag.getAttribute("lang");
		
		//Expected language is en
		assertEquals("en", actual);
	}
	
	/**
	 * Test if the tag with id HTML has the tag name HTML.
	 */
	@Test
	public void testHTMLTagName() {
		
		WebElement htmlTag = DRIVER.findElement(By.id("html"));
		
		String actual = htmlTag.getTagName();
		
		//Expected tage name is HTML
		assertEquals("HTML", actual);
	}
}
