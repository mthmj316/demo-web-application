package de.mthoma.demowebapp.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.boot.test.context.SpringBootTest;

import de.mthoma.demowebapp.DemoWebApplicationTests;
import de.mthoma.demowebapp.utils.SeleniumCore;

@SpringBootTest
public class LoginPageUITest {
	
	private static final String BOLD = "700";
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
		expectedStyle.put("height", SeleniumCore.getWindowHeight(DRIVER) + "px"); //Test 100% height
		expectedStyle.put("width", SeleniumCore.getWindowWidth(DRIVER) + "px"); // Test 100% width
		
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
	
	/**
	 * Test if the tag with id==main_container_vertical has the tag name div.
	 */
	@Test
	public void testMainContainerVerticalTagName() {

		WebElement tag = DRIVER.findElement(By.id("main_container_vertical"));

		String actual = tag.getTagName();

		assertEquals("div", actual);
	}

	/**
	 * Test if the parent of the tag with id==main_container_vertical is the tag with id==main_container_horizontal. 
	 */
	@Test
	public void testMainContainerVerticalParent() {

		WebElement tag = DRIVER.findElement(By.id("main_container_vertical"));

		WebElement parentTag = tag.findElement(By.xpath("./.."));

		String actual = parentTag.getAttribute("id");
		String expected = "main_container_horizontal";

		assertEquals(expected, actual);
	}
	
	/**
	 * Test if the class attribute of tag with id==main_container_vertical is set to class==cls_main_container_vertical.
	 */
	@Test
	public void testMainContainerVerticalAttrClass() {

		WebElement tag = DRIVER.findElement(By.id("main_container_vertical"));

		String expected = "cls_main_container_vertical";
		String actual = tag.getAttribute("class");

		assertEquals(expected, actual, "'" + expected + "'" + " != " + "'" + actual + "'");
	}
	
	/**
	 * Test of the style of the tag with the id==main_container_vertical.
	 */
	@Test
	public void testMainContainerVerticalStyle() {

		final Map<String, String> expectedStyle = new HashMap<String, String>();
		expectedStyle.put("background-color","rgb(224, 255, 255)");
		expectedStyle.put("width", "400px");
		expectedStyle.put("border-top-width","1px");
		expectedStyle.put("border-bottom-width","1px");
		expectedStyle.put("border-left-width","1px");
		expectedStyle.put("border-right-width","1px");
		expectedStyle.put("border-top-style","solid");
		expectedStyle.put("border-bottom-style","solid");
		expectedStyle.put("border-left-style","solid");
		expectedStyle.put("border-right-style","solid");
		expectedStyle.put("border-top-color","rgb(61, 109, 169)");
		expectedStyle.put("border-bottom-color","rgb(61, 109, 169)");
		expectedStyle.put("border-left-color","rgb(61, 109, 169)");
		expectedStyle.put("border-right-color","rgb(61, 109, 169)");
		expectedStyle.put("height","250px");
		expectedStyle.put("padding-top","20px");
		expectedStyle.put("padding-bottom","20px");
		expectedStyle.put("padding-left","20px");
		expectedStyle.put("padding-right","20px");

		final WebElement tag = DRIVER.findElement(By.id("main_container_vertical"));

		final String testResult = SeleniumCore.checkStyle(DRIVER, tag, expectedStyle);

		assertEquals("", testResult, testResult);
	}
	
	/**
	 * Test if the header with id==login_header has the tag name h2.
	 */
	@Test
	public void testLoginHeaderTagName() {

		final WebElement tag = DRIVER.findElement(By.id("login_header"));

		final String actual = tag.getTagName();

		assertEquals("h2", actual);
	}

	/**
	 * Test if the parent of the header with id==login_header is the tag with id==main_container_vertical. 
	 */
	@Test
	public void testLoginHeaderParent() {

		final WebElement tag = DRIVER.findElement(By.id("login_header"));

		final WebElement parentTag = tag.findElement(By.xpath("./.."));

		final String actual = parentTag.getAttribute("id");
		final String expected = "main_container_vertical";

		assertEquals(expected, actual);
	}

	/**
	 * Test if the text of the header with id==login_header text is: Login:. 
	 */
	@Test
	public void testLoginHeaderText() {

		final WebElement tag = DRIVER.findElement(By.id("login_header"));

		final String actual = tag.getText();
		final String expected = "Login:";

		assertEquals(expected, actual);
	}
	
	/**
	 * Test if the class attribute of tag with id==login_header is set to class==cls_main_header.
	 */
	@Test
	public void testLoginHeaderAttrClass() {

		final WebElement tag = DRIVER.findElement(By.id("login_header"));

		final String expected = "cls_main_header";
		final String actual = tag.getAttribute("class");

		assertEquals(expected, actual, "'" + expected + "'" + " != " + "'" + actual + "'");
	}
	
	/**
	 * Test of the style of the tag with the id==login_header.
	 */
	@Test
	public void testLoginHeaderStyle() {

		final Map<String, String> expectedStyle = new HashMap<String, String>();
		expectedStyle.put("font-weight", BOLD); //BOLD == 700

		final WebElement tag = DRIVER.findElement(By.id("login_header"));

		final String testResult = SeleniumCore.checkStyle(DRIVER, tag, expectedStyle);

		assertEquals("", testResult, testResult);
	}
	
	/**
	 * Test of immediate preceding sibling of the tag with id==login_header.
	 * An {@link NoSuchElementException} is expected, since there is no preceding sibling.
	 */
	@Test
	public void testLoginHeaderPrecedingSibling() {

		final WebElement tag = DRIVER.findElement(By.id("login_header"));

		assertThrows(NoSuchElementException.class, () -> tag.findElement(By.xpath("preceding-sibling::*[1]")));
	}
	
	/**
	 * Test of immediate following sibling of the tag with id==login_header.
	 */
	@Test
	public void testLoginHeaderFollowingSibling() {

		final WebElement tag = DRIVER.findElement(By.id("login_header"));

		final WebElement followingSibling = tag.findElement(By.xpath("following-sibling::*[1]"));

		final String expectedId = "login_form";
		final String actualId = followingSibling.getAttribute("id");

		assertEquals(expectedId, actualId, "wrong following sibling");
	}
	
	/**
	 * Test if the tag with id==login_form has the tag name form.
	 */
	@Test
	public void testLoginFormTagName() {

		final WebElement tag = DRIVER.findElement(By.id("login_form"));

		final String actual = tag.getTagName();

		assertEquals("form", actual);
	}

	/**
	 * Test if the parent of the tag with id==login_form is the tag with id==main_container_vertical. 
	 */
	@Test
	public void testLoginFormParent() {

		final WebElement tag = DRIVER.findElement(By.id("login_form"));

		final WebElement parentTag = tag.findElement(By.xpath("./.."));

		final String actual = parentTag.getAttribute("id");
		final String expected = "main_container_vertical";

		assertEquals(expected, actual);
	}

	/**
	 * Test the submission method of the form with the id: login_form
	 */
	@Test
	void testLoginFormMethod() {

		final WebElement tag = DRIVER.findElement(By.id("login_form"));

		final String expectedMethod = "get";
		final String actualMethod = tag.getAttribute("method");

		assertEquals(expectedMethod, actualMethod, "wrong submission method");
	}

	/**
	 * Test the action of the form with the id: login_form
	 */
	@Test
	void testLoginFormAction() {

		final WebElement tag = DRIVER.findElement(By.id("login_form"));

		final String expectedAction = "http://localhost:8080/login";
		final String actualAction = tag.getAttribute("action");

		assertEquals(expectedAction, actualAction, "wrong action");
	}
	
	/**
	 * Test of immediate preceding sibling of the tag with id==login_form.
	 */
	@Test
	public void testLoginFormPrecedingSibling() {

		final WebElement tag = DRIVER.findElement(By.id("login_form"));

		final WebElement followingSibling = tag.findElement(By.xpath("preceding-sibling::*[1]"));

		final String expectedId = "login_header";
		final String actualId = followingSibling.getAttribute("id");

		assertEquals(expectedId, actualId, "wrong preceding sibling");
	}
	
	/**
	 * Test of immediate following sibling of the tag with id==login_form.
	 */
	@Test
	public void testLoginFormFollowingSibling() {

		final WebElement tag = DRIVER.findElement(By.id("login_form"));

		final WebElement followingSibling = tag.findElement(By.xpath("following-sibling::*[1]"));

		final String expectedId = "login_page_script";
		final String actualId = followingSibling.getAttribute("id");

		assertEquals(expectedId, actualId, "wrong following sibling");
	}
}
