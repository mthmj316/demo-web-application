package de.mthoma.demowebapp.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.boot.test.context.SpringBootTest;

import de.mthoma.demowebapp.DemoWebApplicationTests;
import de.mthoma.demowebapp.data.User;
import de.mthoma.demowebapp.data.UserDataAccess;
import de.mthoma.demowebapp.data.UserDataAccessImpl;
import de.mthoma.demowebapp.utils.SeleniumCore;

@SpringBootTest
public class HomePageUITest {

	private final static WebDriver DRIVER = SeleniumCore.getDriver();
	private static UserDataAccess userDataAccess = new UserDataAccessImpl();
	private static User user;
	
	
	@BeforeAll
	public static void initialSetup() {
		DRIVER.manage().window().maximize();
		DRIVER.get(DemoWebApplicationTests.TEST_HTTP_LOCALHOST_8080_LOGIN);
		
		user = userDataAccess.getUser("coloso");
		
		DRIVER.findElement(By.id("login_name")).sendKeys(user.getAlias());
		DRIVER.findElement(By.id("login_password")).sendKeys(user.getPassword());
		DRIVER.findElement(By.id("login_button")).click();
	}

	@AfterAll 
	public static void finalCleanup() {
		DRIVER.close();
	}
	
	/**
	 * Test if the attribute lang == en
	 */
	@Test
	public void testHTMLTagAttrLang() {

		final WebElement htmlTag = DRIVER.findElement(By.id("html"));

		final String actual = htmlTag.getAttribute("lang");

		//Expected language is en
		assertEquals("en", actual);
	}

	/**
	 * Test if the tag with id HTML has the tag name HTML.
	 */
	@Test
	public void testHTMLTagName() {

		final WebElement htmlTag = DRIVER.findElement(By.id("html"));

		final String actual = htmlTag.getTagName();

		//Expected tage name is HTML
		assertEquals("html", actual);
	}
	
	/**
	 * Test of immediate following sibling of the tag with id==html.
	 * An {@link NoSuchElementException} is expected, since there is no following sibling.
	 */
	@Test
	public void testHTMLFollowingSibling() {

		final WebElement tag = DRIVER.findElement(By.id("html"));

		assertThrows(NoSuchElementException.class, () -> tag.findElement(By.xpath("following-sibling::*[1]")));
	}
	
	/**
	 * Test of immediate preceding sibling of the tag with id==html.
	 * An {@link NoSuchElementException} is expected, since there is no preceding sibling.
	 */
	@Test
	public void testHTMLPrecedingSibling() {

		final WebElement tag = DRIVER.findElement(By.id("html"));

		assertThrows(NoSuchElementException.class, () -> tag.findElement(By.xpath("preceding-sibling::*[1]")));
	}

	/**
	 * Test if there is a superior tag to the html tag. 
	 */
	@Test
	public void testHTMLParent() {

		final WebElement tag = DRIVER.findElement(By.id("html"));

		assertThrows(NoSuchElementException.class, () -> tag.findElement(By.xpath("./..")));
	}
	
	/**
	 * Test if the tag with id==head has the tag name head.
	 */
	@Test
	public void testHeadTagName() {

		final WebElement tag = DRIVER.findElement(By.id("head"));

		final String actual = tag.getTagName();

		assertEquals("head", actual);
	}

	/**
	 * Test if the parent of the tag with id==head is the tag with id==html. 
	 */
	@Test
	public void testHeadParent() {

		final WebElement tag = DRIVER.findElement(By.id("head"));

		final WebElement parentTag = tag.findElement(By.xpath("./.."));

		final String actual = parentTag.getAttribute("id");
		final String expected = "html";

		assertEquals(expected, actual);
	}
	
	/**
	 * Test of immediate preceding sibling of the tag with id==head.
	 * An {@link NoSuchElementException} is expected, since there is no preceding sibling.
	 */
	@Test
	public void testHeadPrecedingSibling() {

		final WebElement tag = DRIVER.findElement(By.id("head"));

		assertThrows(NoSuchElementException.class, () -> tag.findElement(By.xpath("preceding-sibling::*[1]")));
	}
	
	/**
	 * Test of immediate following sibling of the tag with id==head.
	 */
	@Test
	public void testHeadFollowingSibling() {

		final WebElement tag = DRIVER.findElement(By.id("head"));

		final WebElement followingSibling = tag.findElement(By.xpath("following-sibling::*[1]"));

		final String expectedId = "body";
		final String actualId = followingSibling.getAttribute("id");

		assertEquals(expectedId, actualId, "wrong following sibling");
	}
	
	/**
	 * Test if the tag with the id=title has the tag name "title".
	 */
	@Test
	public void testTitleTagName() {

		final WebElement titleTag = DRIVER.findElement(By.id("title"));

		final String actual = titleTag.getTagName();

		//Expected tag name is "title"
		assertEquals("title", actual);

	}

	/**
	 * Test if the parent of the title tag is the head tag. 
	 */
	@Test
	public void testTitleParent() {

		final WebElement titleTag = DRIVER.findElement(By.id("title"));

		final WebElement parentTag = titleTag.findElement(By.xpath("./.."));

		final String actualParentTagName = parentTag.getTagName();

		assertEquals("head", actualParentTagName);
	}

	/**
	 * Test if the title of the page equals "Home Page".
	 */
	@Test
	public void testTitleText() {

		final String expectedTitle = "Home Page";
		final String actualTitle = DRIVER.getTitle();

		assertEquals(expectedTitle, actualTitle);
	}
	
	/**
	 * Test of immediate preceding sibling of the tag with id==title.
	 * An {@link NoSuchElementException} is expected, since there is no preceding sibling.
	 */
	@Test
	public void testTitlePrecedingSibling() {

		final WebElement tag = DRIVER.findElement(By.id("title"));

		assertThrows(NoSuchElementException.class, () -> tag.findElement(By.xpath("preceding-sibling::*[1]")));
	}
	
	/**
	 * Test of immediate following sibling of the tag with id==title.
	 */
	@Test
	public void testTitleFollowingSibling() {

		final WebElement tag = DRIVER.findElement(By.id("title"));

		final WebElement followingSibling = tag.findElement(By.xpath("following-sibling::*[1]"));

		final String expectedId = "link_main_theme";
		final String actualId = followingSibling.getAttribute("id");

		assertEquals(expectedId, actualId, "wrong following sibling");
	}
	
	/**
	 * Test if the tag with the link_main_theme has the tag name "link".
	 */
	@Test
	public void testLinkLinkMainThemeTagName() {

		final WebElement tag = DRIVER.findElement(By.id("link_main_theme"));

		final String actual = tag.getTagName();

		assertEquals("link", actual);
	}

	/**
	 * Test if the parent of the tag with id==link_main_theme has id==head. 
	 */
	@Test
	public void testLinkLinkMainThemeParent() {

		final WebElement tag = DRIVER.findElement(By.id("link_main_theme"));

		final WebElement parentTag = tag.findElement(By.xpath("./.."));

		final String actualParentId = parentTag.getAttribute("id");

		assertEquals("parent_id", actualParentId);
	}

	/**
	 * Test of the link with id==link_main_theme has the attribute rel==stylesheet.
	 */
	@Test
	public void testLinkMainThemeAttrRel() {

		final WebElement tag = DRIVER.findElement(By.id("link_main_theme"));

		final String expected = "stylesheet";
		final String actual = tag.getAttribute("rel");

		assertEquals(expected, actual);
	}

	/**
	 * Test of the link with id==link_main_theme has the attribute href== /css/main_theme.css.
	 */
	@Test
	public void testLinkMainThemeAttrHref() {

		final WebElement tag = DRIVER.findElement(By.id("link_main_theme"));

		final String expected = " /css/main_theme.css";
		final String actual = tag.getAttribute("href");

		assertEquals(expected, actual);
	}
	
	/**
	 * Test of immediate preceding sibling of the tag with id==link_main_theme.
	 */
	@Test
	public void testLinkMainThemePrecedingSibling() {

		final WebElement tag = DRIVER.findElement(By.id("link_main_theme"));

		final WebElement followingSibling = tag.findElement(By.xpath("preceding-sibling::*[1]"));

		final String expectedId = "title";
		final String actualId = followingSibling.getAttribute("id");

		assertEquals(expectedId, actualId, "wrong preceding sibling");
	}
	
	/**
	 * Test of immediate following sibling of the tag with id==link_main_theme.
	 * An {@link NoSuchElementException} is expected, since there is no following sibling.
	 */
	@Test
	public void testLinkMainThemeFollowingSibling() {

		final WebElement tag = DRIVER.findElement(By.id("link_main_theme"));

		assertThrows(NoSuchElementException.class, () -> tag.findElement(By.xpath("following-sibling::*[1]")));
	}
	
	/**
	 * Test if the tag with id==body has the tag name body.
	 */
	@Test
	public void testBodyTagName() {

		final WebElement tag = DRIVER.findElement(By.id("body"));

		final String actual = tag.getTagName();

		assertEquals("body", actual);
	}

	/**
	 * Test if the parent of the tag with id==body is the tag with id==html. 
	 */
	@Test
	public void testBodyParent() {

		final WebElement tag = DRIVER.findElement(By.id("body"));

		final WebElement parentTag = tag.findElement(By.xpath("./.."));

		final String actual = parentTag.getAttribute("id");
		final String expected = "html";

		assertEquals(expected, actual);
	}
	
	/**
	 * Test of immediate preceding sibling of the tag with id==body.
	 */
	@Test
	public void testBodyPrecedingSibling() {

		final WebElement tag = DRIVER.findElement(By.id("body"));

		final WebElement followingSibling = tag.findElement(By.xpath("preceding-sibling::*[1]"));

		final String expectedId = "head";
		final String actualId = followingSibling.getAttribute("id");

		assertEquals(expectedId, actualId, "wrong preceding sibling");
	}
	
	/**
	 * Test of immediate following sibling of the tag with id==body.
	 * An {@link NoSuchElementException} is expected, since there is no following sibling.
	 */
	@Test
	public void testBodyFollowingSibling() {

		final WebElement tag = DRIVER.findElement(By.id("body"));

		assertThrows(NoSuchElementException.class, () -> tag.findElement(By.xpath("following-sibling::*[1]")));
	}
	
	/**
	 * Test if the tag with id==main_container has the tag name div.
	 */
	@Test
	public void testMainContainerTagName() {

		final WebElement tag = DRIVER.findElement(By.id("main_container"));

		final String actual = tag.getTagName();

		assertEquals("div", actual);
	}

	/**
	 * Test if the parent of the tag with id==main_container is the tag with id==body. 
	 */
	@Test
	public void testMainContainerParent() {

		final WebElement tag = DRIVER.findElement(By.id("main_container"));

		final WebElement parentTag = tag.findElement(By.xpath("./.."));

		final String actual = parentTag.getAttribute("id");
		final String expected = "body";

		assertEquals(expected, actual);
	}
	
	/**
	 * Test of immediate following sibling of the tag with id==main_container.
	 * An {@link NoSuchElementException} is expected, since there is no following sibling.
	 */
	@Test
	public void testMainContainerFollowingSibling() {

		final WebElement tag = DRIVER.findElement(By.id("main_container"));

		assertThrows(NoSuchElementException.class, () -> tag.findElement(By.xpath("following-sibling::*[1]")));
	}

	/**
	 * Test of immediate preceding sibling of the tag with id==main_container.
	 * An {@link NoSuchElementException} is expected, since there is no preceding sibling.
	 */
	@Test
	public void testMainContainerPrecedingSibling() {

		final WebElement tag = DRIVER.findElement(By.id("main_container"));

		assertThrows(NoSuchElementException.class, () -> tag.findElement(By.xpath("preceding-sibling::*[1]")));
	}
	
	/**
	 * Test if the class attribute of tag with id==main_container is set to class==cls_main_container.
	 */
	@Test
	public void testMainContainerAttrClass() {

		final WebElement tag = DRIVER.findElement(By.id("main_container"));

		final String expected = "cls_main_container";
		final String actual = tag.getAttribute("class");

		assertEquals(expected, actual, "wrong class");
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
	public void testMainHontainerHorizontalTagName() {

		final WebElement tag = DRIVER.findElement(By.id("main_container_horizontal"));

		final String actual = tag.getTagName();

		assertEquals("div", actual);
	}

	/**
	 * Test if the parent of the tag with id==main_container_horizontal is the tag with id==main_container. 
	 */
	@Test
	public void testMainHontainerHorizontalParent() {

		final WebElement tag = DRIVER.findElement(By.id("main_container_horizontal"));

		final WebElement parentTag = tag.findElement(By.xpath("./.."));

		final String actual = parentTag.getAttribute("id");
		final String expected = "main_container";

		assertEquals(expected, actual);
	}
	
	/**
	 * Test of immediate following sibling of the tag with id==main_container_horizontal.
	 * An {@link NoSuchElementException} is expected, since there is no following sibling.
	 */
	@Test
	public void testMainContainerHorizontalFollowingSibling() {

		final WebElement tag = DRIVER.findElement(By.id("main_container_horizontal"));

		assertThrows(NoSuchElementException.class, () -> tag.findElement(By.xpath("following-sibling::*[1]")));
	}

	/**
	 * Test of immediate preceding sibling of the tag with id==main_container_horizontal.
	 * An {@link NoSuchElementException} is expected, since there is no preceding sibling.
	 */
	@Test
	public void testMainContainerHorizontalPrecedingSibling() {

		final WebElement tag = DRIVER.findElement(By.id("main_container_horizontal"));

		assertThrows(NoSuchElementException.class, () -> tag.findElement(By.xpath("preceding-sibling::*[1]")));
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
	 * Test if the tag with id==main_container_vertical has the tag name div.
	 */
	@Test
	public void testMainContainerVerticalTagName() {

		final WebElement tag = DRIVER.findElement(By.id("main_container_vertical"));

		final String actual = tag.getTagName();

		assertEquals("div", actual);
	}

	/**
	 * Test if the parent of the tag with id==main_container_vertical is the tag with id==main_container_horizontal. 
	 */
	@Test
	public void testMainContainerVerticalParent() {

		final WebElement tag = DRIVER.findElement(By.id("main_container_vertical"));

		final WebElement parentTag = tag.findElement(By.xpath("./.."));

		final String actual = parentTag.getAttribute("id");
		final String expected = "main_container_horizontal";

		assertEquals(expected, actual);
	}
	
	/**
	 * Test of immediate following sibling of the tag with id==main_container_vertical.
	 * An {@link NoSuchElementException} is expected, since there is no following sibling.
	 */
	@Test
	public void testMainContainerVerticalFollowingSibling() {

		final WebElement tag = DRIVER.findElement(By.id("main_container_vertical"));

		assertThrows(NoSuchElementException.class, () -> tag.findElement(By.xpath("following-sibling::*[1]")));
	}

	/**
	 * Test of immediate preceding sibling of the tag with id==main_container_vertical.
	 * An {@link NoSuchElementException} is expected, since there is no preceding sibling.
	 */
	@Test
	public void testMainContainerVerticalPrecedingSibling() {

		final WebElement tag = DRIVER.findElement(By.id("main_container_vertical"));

		assertThrows(NoSuchElementException.class, () -> tag.findElement(By.xpath("preceding-sibling::*[1]")));
	}
	
	/**
	 * Test if the class attribute of tag with id==main_container_vertical is set to class==cls_main_container_vertical.
	 */
	@Test
	public void testMainContainerVerticalAttrClass() {

		final WebElement tag = DRIVER.findElement(By.id("main_container_vertical"));

		final String expected = "cls_main_container_vertical";
		final String actual = tag.getAttribute("class");

		assertEquals(expected, actual, "wrong class");
	}
	
	/**
	 * Test if the header with id==welcome_address_header has the tag name h2.
	 */
	@Test
	public void testWelcomeAddressHeaderTagName() {

		final WebElement tag = DRIVER.findElement(By.id("welcome_address_header"));

		final String actual = tag.getTagName();

		assertEquals("h2", actual);
	}

	/**
	 * Test if the parent of the header with id==welcome_address_header is the tag with id==main_container_vertical. 
	 */
	@Test
	public void testWelcomeAddressHeaderParent() {

		final WebElement tag = DRIVER.findElement(By.id("welcome_address_header"));

		final WebElement parentTag = tag.findElement(By.xpath("./.."));

		final String actual = parentTag.getAttribute("id");
		final String expected = "main_container_vertical";

		assertEquals(expected, actual);
	}

	/**
	 * Test if the text of the header with id==welcome_address_header text is correct. 
	 */
	@Test
	public void testWelcomeAddressHeaderText() {

		final WebElement tag = DRIVER.findElement(By.id("welcome_address_header"));

		final String actual = tag.getText();
		final String expected = "Welcome " + user.getAlias() + " to your home page!";

		assertEquals(expected, actual);
	}
	
	/**
	 * Test of immediate preceding sibling of the tag with id==welcome_address_header.
	 * An {@link NoSuchElementException} is expected, since there is no preceding sibling.
	 */
	@Test
	public void testWelcomeAddressHeaderPrecedingSibling() {

		final WebElement tag = DRIVER.findElement(By.id("welcome_address_header"));

		assertThrows(NoSuchElementException.class, () -> tag.findElement(By.xpath("preceding-sibling::*[1]")));
	}
	
	/**
	 * Test of immediate following sibling of the tag with id==welcome_address_header.
	 */
	@Test
	public void testWelcomeAddressHeaderFollowingSibling() {

		final WebElement tag = DRIVER.findElement(By.id("welcome_address_header"));

		final WebElement followingSibling = tag.findElement(By.xpath("following-sibling::*[1]"));

		final String expectedId = "logout_form";
		final String actualId = followingSibling.getAttribute("id");

		assertEquals(expectedId, actualId, "wrong following sibling");
		
		//1
	}
	
	/**
	 * Test if the class attribute of tag with id==welcome_address_header is set to class==cls_main_header.
	 */
	@Test
	public void testWelcomeAddressHeaderAttrClass() {

		final WebElement tag = DRIVER.findElement(By.id("welcome_address_header"));

		final String expected = "cls_main_header";
		final String actual = tag.getAttribute("class");

		assertEquals(expected, actual, "wrong class");
	}
	
	/**
	 * Test of the style of the tag with the id==welcome_address_header.
	 */
	@Test
	public void testWelcomeAddressHeaderStyle() {

		final Map<String, String> expectedStyle = new HashMap<String, String>();
		expectedStyle.put("font-weight", DemoWebApplicationTests.BOLD); //BOLD == 700

		final WebElement tag = DRIVER.findElement(By.id("welcome_address_header"));

		final String testResult = SeleniumCore.checkStyle(DRIVER, tag, expectedStyle);

		assertEquals("", testResult, testResult);
	}
}
