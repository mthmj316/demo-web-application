package de.mthoma.demowebapp.utils;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public final class SeleniumCore {

	private static final String WEB_DRIVER_FIRRFOX = "webdriver.gecko.driver";
	private static final String WEB_DRIVER_FIREFOX_LOCATION = "/home/mthoma/selenium/geckodriver";

	private SeleniumCore() {
	}

	/**
	 * Returns the web driver.
	 * Before the driver is created it is checked if the web driver system property
	 * is set, and if not it'll set it.
	 * @return {@link WebDriver}
	 */
	public static WebDriver getDriver() {
		
		setWebDriverSystemProperty();
		
		return new FirefoxDriver();
	}

	/*
	 * Sets the web driver system property if not already done.
	 */
	private static void setWebDriverSystemProperty() {
		
		if(!isWebDriverSystemPropertySet()) {
			System.setProperty(SeleniumCore.WEB_DRIVER_FIRRFOX, SeleniumCore.WEB_DRIVER_FIREFOX_LOCATION);
		}	
	}

	/*
	 * Return true if the web driver system property is set.
	 */
	private static boolean isWebDriverSystemPropertySet() {
		return SeleniumCore.WEB_DRIVER_FIREFOX_LOCATION.equals(System.getProperty(SeleniumCore.WEB_DRIVER_FIRRFOX));
	}
	
	
	/**
	 * Compares the style of the given {@link WebElement} with the values passed by the {@link Map} expectedStyle.
	 * @param driver {@link WebDriver} 
	 * @param element2Test {@link WebElement} HTML element which must be checked
	 * @param expectedStyle {@link Map} Contains the expected style: key=style property name value=style property value
	 * @return {@link String} Returns an empty string if the style is as defined in the {@link Map} expectedStyle.
	 * The string is not empty in case the actual style differs from the expected.
	 * Each line of the return value contains one diffenence: error for style property: <property name> -> <expected value> != <actual value>
	 */
	public static String checkStyle(final WebDriver driver, final WebElement element2Test, final Map<String, String> expectedStyle) {
		
		final StringBuffer errorReport = new StringBuffer();
		
		final JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		
		expectedStyle.forEach((property, expected) -> {
			
			String actual = (String) javascriptExecutor.executeScript(
					"return window.getComputedStyle(arguments[0]).getPropertyValue('" + property + "');", element2Test);
			
			if(!expected.equals(actual)) {
				
				if(errorReport.length() > 0) {
					errorReport.append(System.lineSeparator());
				}
				
				errorReport.append("error for style property: ").append(property);
				errorReport.append(" -> ").append(expected).append(" != ").append(actual);
			}
		});
		
		return errorReport.toString();
	}
}
