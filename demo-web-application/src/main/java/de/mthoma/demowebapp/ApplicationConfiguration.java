package de.mthoma.demowebapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.mthoma.demowebapp.data.UserDataAccess;
import de.mthoma.demowebapp.data.UserDataAccessFactory;
import de.mthoma.demowebapp.data.UserDataAccessFactoryImpl;
import de.mthoma.demowebapp.data.UserDataAccessImpl;

@Configuration
public class ApplicationConfiguration {

	/**
	 * @return {@link UserDataAccessFactory}
	 */
	@Bean
	public UserDataAccessFactory userDataAccessFactory() {
		return new UserDataAccessFactoryImpl();
	}

	/**
	 * @return {@link UserDataAccessTest}
	 */
	@Bean
	public UserDataAccess userDataAccess() {
		return new UserDataAccessImpl();
	}
}
