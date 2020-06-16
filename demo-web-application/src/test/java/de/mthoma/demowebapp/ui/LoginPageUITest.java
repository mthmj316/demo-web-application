package de.mthoma.demowebapp.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

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

		String expected = "http://localhost:8080/css/main_theme.css";
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

		String url = DRIVER.getCurrentUrl();
		
		System.out.println("Test:" + url);
		
		String expected = "http://localhost:8080/css/login_page_theme.css";
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
	
	/**
	 * Test if the tag with id==main_container has the tag name div.
	 */
	@Test
	public void testMainConatinerTagName() {

		WebElement tag = DRIVER.findElement(By.id("main_container"));

		String actual = tag.getTagName();

		assertEquals("div", actual);
	}

	/**
	 * Test if the parent of the tag with id==main_container is the tag with id==body. 
	 */
	@Test
	public void testMainConatinerParent() {

		WebElement tag = DRIVER.findElement(By.id("main_container"));

		WebElement parentTag = tag.findElement(By.xpath("./.."));

		String actual = parentTag.getAttribute("id");
		String expected = "body";

		assertEquals(expected, actual);
	}
	
	/**
	 * Test if the class attribute of tag with id==main_container is set to class==cls_main_container.
	 */
	@Test
	public void testMainContainerAttrClass() {

		WebElement tag = DRIVER.findElement(By.id("main_container"));

		String expected = "cls_main_container";
		String actual = tag.getAttribute("class");

		assertEquals(expected, actual, "'" + expected + "'" + " != " + "'" + actual + "'");
	}
	
	/**
	 * Test of the style of the tag with the id==main_container.
	 */
	@Test
	public void testMainContainerStyle() {
		
		final Map<String, String> expectedStyle = new HashMap<String, String>();
		expectedStyle.put("display", "table");
		expectedStyle.put("position", "absolute");
		expectedStyle.put("top", "0px");
		expectedStyle.put("left", "0px");		
		expectedStyle.put("height", SeleniumCore.getWindowHeight(DRIVER) + "px");
		expectedStyle.put("width", SeleniumCore.getWindowWidth(DRIVER) + "px");
		
		WebElement tag = DRIVER.findElement(By.id("main_container"));
		
		String testResult = SeleniumCore.checkStyle(DRIVER, tag, expectedStyle);
		
		assertEquals("", testResult, testResult);
	}
	
	/**
	 * Test if the tag with id==main_container_horizontal has the tag name div.
	 */
	@Test
	public void testMainContainerHorizontalTagName() {

		WebElement tag = DRIVER.findElement(By.id("main_container_horizontal"));

		String actual = tag.getTagName();

		assertEquals("div", actual);
	}

	/**
	 * Test if the parent of the tag with id==main_container_horizontal is the tag with id==main_container. 
	 */
	@Test
	public void testMainContainerHorizontalParent() {

		WebElement tag = DRIVER.findElement(By.id("main_container_horizontal"));

		WebElement parentTag = tag.findElement(By.xpath("./.."));

		String actual = parentTag.getAttribute("id");
		String expected = "main_container";

		assertEquals(expected, actual);
	}
	
	/**
	 * Test if the class attribute of tag with id==main_container_horizontal is set to class==cls_main_container_horizontal.
	 */
	@Test
	public void testMainContainerHorizontalAttrClass() {

		WebElement tag = DRIVER.findElement(By.id("main_container_horizontal"));

		String expected = "cls_main_container_horizontal";
		String actual = tag.getAttribute("class");

		assertEquals(expected, actual, "'" + expected + "'" + " != " + "'" + actual + "'");
	}
	
	/**
	 * Test of the style of the tag with the id==main_container_horizontal.
	 */
	@Test
	public void testMainContainerHorizontalStyle() {

		final Map<String, String> expectedStyle = new HashMap<String, String>();
		expectedStyle.put("background-color", "rgb(241, 241, 241)");
		expectedStyle.put("display", "table-cell");
		expectedStyle.put("vertical-align", "middle");

		final WebElement tag = DRIVER.findElement(By.id("main_container_horizontal"));

		final String testResult = SeleniumCore.checkStyle(DRIVER, tag, expectedStyle);

		assertEquals("", testResult, testResult);
	}
	
}
