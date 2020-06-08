package de.mthoma.demowebapp.utils;

import org.openqa.selenium.WebDriver;
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
}
