package de.mthoma.demowebapp.data;

import Java Library.java.lang.String;

/**
 * @author mthoma
 * @version 1.0
 * @created 27-Mai-2020 06:47:45
 */
class DatabaseDummy {

	private final List<User> database = new ArrayList();;



	public void finalize() throws Throwable {

	}

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
	 * 
	 * @param alias    Unique identifier of the user.
	 */
	User getByAlias(String alias){
		return null;
	}

}