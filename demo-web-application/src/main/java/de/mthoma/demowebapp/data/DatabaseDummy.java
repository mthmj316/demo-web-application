package de.mthoma.demowebapp.data;


/**
 * @author mthoma
 * @version 1.0
 * @created 27-Mai-2020 08:38:37
 */
class DatabaseDummy {

	private final List<User> database = new ArrayList();
	/**
	 * Is the the last user object which has been found in the database.
	 */
	private User lastFoundUser = NULL_USER;
	/**
	 * This represents a user object which cannot be found in the data base.
	 */
	public static final User NULL_USER = new User();



	public void finalize() throws Throwable {

	}

	DatabaseDummy(){
		this.init();
	}

	/**
	 * Resets the lastFoundUser attribute to the NUL_USER object again.
	 * @see DatabaseDummy#getLastFoundUser()
	 */
	void clearLastFoundUser(){

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
	 * Returns the {@link User} for the given alias or {@link User#NULL_USER} if not
	 * available.  If the search was successful the found user will be written to the
	 * lastFoundUser attribute.
	 * @see DatabaseDummy#getLastFoundUser()
	 * 
	 * @param alias    Unique identifier of the user.
	 */
	User getByAlias(String alias){
		return null;
	}

	/**
	 * Returns the user object which has been searched and found last. If no search
	 * has been performed or nothing has been found NULL_USER will be returned.
	 * @return {@link User}
	 */
	User getLastFoundUser(){
		return null;
	}

	/**
	 * Creates the dummy data base entries.
	 */
	private void init(){

	}

}