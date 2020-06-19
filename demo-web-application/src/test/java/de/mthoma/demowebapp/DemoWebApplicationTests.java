package de.mthoma.demowebapp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import de.mthoma.demowebapp.controller.HomeController;
import de.mthoma.demowebapp.controller.LoginController;

@SpringBootTest
public class DemoWebApplicationTests {
	
	public static final String TEST_HTTP_LOCALHOST_8080_LOGIN = "http://localhost:8080/login";
	
	@Autowired
	LoginController loginController;
	
	@Autowired
	HomeController homeController;

	public static final String BOLD = "700";
	
	@Test
	void contextLoads() {
		//Is a valid check, since this test case won't be
		//executed if the context is not available.
		assertTrue(true);
	}
	
	@Test
	void testLoginControllerExists() {
		
		assertThat(this.loginController).isNotNull();
	}
	
	@Test
	void testHomeControllerExists() {
		
		assertThat(this.homeController).isNotNull();
	}

	/**
	 * Test if the url of the demo web applikcation is available.
	 * @throws Exception
	 */
	@Test
	public void testLoginPageUrl() throws Exception {
		
		URL u = new URL (TEST_HTTP_LOCALHOST_8080_LOGIN);
		HttpURLConnection.setFollowRedirects(false);
		HttpURLConnection huc =  ( HttpURLConnection )  u.openConnection (); 
		huc.setRequestMethod ("HEAD");
		
		int actual = huc.getResponseCode() ;
		
		assertEquals(HttpURLConnection.HTTP_OK, actual);
	}
}
