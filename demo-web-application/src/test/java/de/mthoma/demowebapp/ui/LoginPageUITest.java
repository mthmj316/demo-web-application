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

import de.mthoma.demowebapp.DemoWebApplicationTests;
import de.mthoma.demowebapp.utils.SeleniumCore;

@SpringBootTest
public class LoginPageUITest {
	
	private static WebDriver DRIVER = SeleniumCore.getDriver(); 
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		DRIVER.manage().window().maximize();
		DRIVER.get(DemoWebApplicationTests.TEST_HTTP_LOCALHOST_8080_LOGIN);
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
		assertEquals("html", actual);
	}
	
	/**
	 * Test if the tag with the id head has the tag name "head".
	 */
	@Test
	public void testHeadTagName() {

		WebElement headTag = DRIVER.findElement(By.id("head"));

		String actual = headTag.getTagName();

		//Expected tag name is "head"
		assertEquals("head", actual);

	}

	/**
	 * Test if the parent of the head tag is the html tag. 
	 */
	@Test
	public void testHeadParent() {

		WebElement headTag = DRIVER.findElement(By.id("head"));

		WebElement parentTag = headTag.findElement(By.xpath("./.."));

		String actualParentTagName = parentTag.getTagName();

		assertEquals("html", actualParentTagName);
	}
	
	/**
	 * Test if the tag with the id title has the tag name "title".
	 */
	@Test
	public void testTitleTagName() {

		WebElement titleTag = DRIVER.findElement(By.id("title"));

		String actual = titleTag.getTagName();

		//Expected tag name is "title"
		assertEquals("title", actual);

	}

	/**
	 * Test if the parent of the title tag is the head tag. 
	 */
	@Test
	public void testTitleParent() {

		WebElement titleTag = DRIVER.findElement(By.id("title"));

		WebElement parentTag = titleTag.findElement(By.xpath("./.."));

		String actualParentTagName = parentTag.getTagName();

		assertEquals("head", actualParentTagName);
	}

	/**
	 * Test if the title of the page equals "Login Page".
	 */
	@Test
	public void testTitleText() {

		String expectedTitle = "Login Page";
		String actualTitle = DRIVER.getTitle();

		assertEquals(expectedTitle, actualTitle);
	}
	
	/**
	 * Test if the tag with the link_main_theme has the tag name "link".
	 */
	@Test
	public void testLinkLinkMainThemeTagName() {

		WebElement tag = DRIVER.findElement(By.id("link_main_theme"));

		String actual = tag.getTagName();

		assertEquals("link", actual);
	}

	/**
	 * Test if the parent of the tag with id==link_main_theme has id==head. 
	 */
	@Test
	public void testLinkLinkMainThemeParent() {

		WebElement tag = DRIVER.findElement(By.id("link_main_theme"));

		WebElement parentTag = tag.findElement(By.xpath("./.."));

		String actualParentId = parentTag.getAttribute("id");

		assertEquals("head", actualParentId);
	}

	/**
	 * Test of the link with id==link_main_theme has the attribute rel==stylesheet.
	 */
	@Test
	public void testLinkMainThemeAttrRel() {

		WebElement tag = DRIVER.findElement(By.id("link_main_theme"));

		String expected = "stylesheet";
		String actual = tag.getAttribute("rel");

		assertEquals(expected, actual);
	}

	/**
	 * Test of the link with id==link_main_theme has the attribute href==/css/main_theme.css.
	 */
	@Test
	public void testLinkMainThemeAttrHref() {

		WebElement tag = DRIVER.findElement(By.id("link_main_theme"));

		String expected = "/css/main_theme.css";
		String actual = tag.getAttribute("href");

		assertEquals(expected, actual);
	}
	
	/**
	 * Test if the tag with the link_login_page_theme has the tag name "link".
	 */
	@Test
	public void testLinkLinkLoginPageThemeTagName() {

		WebElement tag = DRIVER.findElement(By.id("link_login_page_theme"));

		String actual = tag.getTagName();

		assertEquals("link", actual);
	}

	/**
	 * Test if the parent of the tag with id==link_login_page_theme has id==head. 
	 */
	@Test
	public void testLinkLinkLoginPageThemeParent() {

		WebElement tag = DRIVER.findElement(By.id("link_login_page_theme"));

		WebElement parentTag = tag.findElement(By.xpath("./.."));

		String actualParentId = parentTag.getAttribute("id");

		assertEquals("head", actualParentId);
	}

	/**
	 * Test of the link with id==link_login_page_theme has the attribute rel==stylesheet.
	 */
	@Test
	public void testLinkLoginPageThemeAttrRel() {

		WebElement tag = DRIVER.findElement(By.id("link_login_page_theme"));

		String expected = "stylesheet";
		String actual = tag.getAttribute("rel");

		assertEquals(expected, actual);
	}

	/**
	 * Test of the link with id==link_login_page_theme has the attribute href==/css/login_page_theme.css.
	 */
	@Test
	public void testLinkLoginPageThemeAttrHref() {

		WebElement tag = DRIVER.findElement(By.id("link_login_page_theme"));

		String expected = "/css/login_page_theme.css";
		String actual = tag.getAttribute("href");

		assertEquals(expected, actual);
	}
	
	/**
	 * Test if the tag with id==body has the tag name body.
	 */
	@Test
	public void testBodyTagName() {

		WebElement tag = DRIVER.findElement(By.id("body"));

		String actual = tag.getTagName();

		assertEquals("body", actual);
	}

	/**
	 * Test if the parent of the tag with id==body is the tag with id==html. 
	 */
	@Test
	public void testBodyParent() {

		WebElement tag = DRIVER.findElement(By.id("body"));

		WebElement parentTag = tag.findElement(By.xpath("./.."));

		String actual = parentTag.getAttribute("id");
		String expected = "html";

		assertEquals(expected, actual);
	}
}
