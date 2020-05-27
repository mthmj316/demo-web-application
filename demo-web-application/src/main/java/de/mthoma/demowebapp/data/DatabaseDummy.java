package de.mthoma.demowebapp.data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mthoma
 * @version 1.0
 * @created 27-Mai-2020 06:47:45
 */
class DatabaseDummy {
	
	/**
	 * This represents a user object which cannot be found in the data base.
	 */
	public static final User NULL_USER = new User();

	private final List<User> database = new ArrayList<>();

	DatabaseDummy(){
		this.init();
	}

	/**
	 * Searches in the database for the user with the given alias, and checks if the
	 * password in the database matches with the given password.
	 * 
	 * @param alias    Login name of the user.
	 * @param password    Password of the user.
	 */
	boolean existsAliasPasswordCombination(String alias, String password){
		return false;
	}

	/**
	 * Returns the {@link User} for the given alias or {@link User#NULL_USER} if not available.
	 * @param alias    Unique identifier of the user.
	 */
	User getByAlias(String alias){
		
		for(User user : this.database) {
		
			if(user.getAlias().equals(alias)) {
				return user;
			}
		}
		
		return NULL_USER;
	}

	/*
	 * Creates the dummy data base entries.
	 */
	private void init(){

	}
}