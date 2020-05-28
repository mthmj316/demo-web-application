package de.mthoma.demowebapp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoWebApplicationTests {
	
	@Autowired
	LoginController loginController;
	
	@Autowired
	HomeController homeController;
	
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

}
