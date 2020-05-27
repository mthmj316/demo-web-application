package de.mthoma.demowebapp.data;


/**
 * @author mthoma
 * @version 1.0
 * @created 26-Mai-2020 17:04:48
 */
class UserDataAccessImpl implements UserDataAccess {

	public UserDataAccessImpl(){
		super();
	}

	/**
	 * The User object for the given alias. If there is no user with that alias null
	 * will be returned.
	 * 
	 * @param alias    The unquie name of the user which shall be returned.
	 */
	public User getUser(String alias){
		return null;
	}

	/**
	 * Returns true if the combination of the alias and password is stored in the
	 * database.
	 * 
	 * @param alias    The login name of the user.
	 * @param password    The password of the user.
	 */
	public boolean verifyLogin(String alias, String password){
		return false;
	}
}