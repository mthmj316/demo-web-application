package de.mthoma.demowebapp.data;


/**
 * Interface to data layer.
 * @author mthoma
 * @version 1.0
 * @created 27-Mai-2020 06:47:45
 */
public interface UserDataAccess {

	/**
	 * The User object for the given alias. If there is no user with that alias null
	 * will be returned.
	 * 
	 * @param alias    The unquie name of the user which shall be returned.
	 */
	public User getUser(String alias);

	/**
	 * Returns true if the combination of the alias and password is stored in the
	 * database.
	 * 
	 * @param alias    The login name of the user.
	 * @param password    The password of the user.
	 */
	public abstract boolean verifyLogin(String alias, String password);

}