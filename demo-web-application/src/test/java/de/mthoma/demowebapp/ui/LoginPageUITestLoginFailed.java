/**
 * 
 */
package de.mthoma.demowebapp.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.boot.test.context.SpringBootTest;

import de.mthoma.demowebapp.DemoWebApplicationTests;
import de.mthoma.demowebapp.utils.SeleniumCore;

/**
 * @author mthoma
 *
 */
@SpringBootTest
public class LoginPageUITestLoginFailed {
	
	private static WebDriver DRIVER = SeleniumCore.getDriver(); 

	@BeforeAll
	public static void setUpBeforeClass() {

		DRIVER.manage().window().maximize();
		DRIVER.get(DemoWebApplicationTests.TEST_HTTP_LOCALHOST_8080_LOGIN);
		
		DRIVER.findElement(By.id("login_name")).sendKeys("not a valid username");
		DRIVER.findElement(By.id("login_password")).sendKeys("not a valid password");
		DRIVER.findElement(By.id("login_button")).click();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		DRIVER.close();
	}
	
	/**
	 * Test if the class attribute, after login failed, of tag with id==login_error_message is set to 
	 * class==cls_error_text cls_visible.
	 */
	@Test
	public void testLoginErrorMessageAttrClassLoginFailed() {

		final WebElement tag = DRIVER.findElement(By.id("login_error_message"));

		final String expected = "cls_error_text cls_visible";
		final String actual = tag.getAttribute("class");

		assertEquals(expected, actual, "'" + expected + "'" + " != " + "'" + actual + "'");
	}
	
	/**
	 * Test of the style of the tag with the id==login_error_message after login failed.
	 */
	@Test
	public void testLoginErrorMessageStyleLoginFailed() {

		final Map<String, String> expectedStyle = new HashMap<String, String>();
		expectedStyle.put("color", "rgb(255, 0, 0)");
		expectedStyle.put("display", "block");

		final WebElement tag = DRIVER.findElement(By.id("login_error_message"));

		final String testResult = SeleniumCore.checkStyle(DRIVER, tag, expectedStyle);

		assertEquals("", testResult, testResult);
	}
}
