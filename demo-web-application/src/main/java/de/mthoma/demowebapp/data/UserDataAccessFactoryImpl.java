package de.mthoma.demowebapp.data;


/**
 * @author mthoma
 * @version 1.0
 * @created 27-Mai-2020 08:38:37
 */
public class UserDataAccessFactoryImpl implements UserDataAccessFactory {

	/**
	 * Instance of the UserDataAccess interface.
	 */
	private UserDataAccess userDataAccess;

	public UserDataAccessFactoryImpl(){

	}

	/**
	 * 
	 * @exception Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

	/**
	 * Instance of the UserDataAccess interface.
	 */
	public UserDataAccess getUserDataAccess(){
		return userDataAccess;
	}

	/**
	 * Instance of the UserDataAccess interface.
	 * 
	 * @param newVal    newVal
	 */
	public void setUserDataAccess(UserDataAccess newVal){
		userDataAccess = newVal;
	}

}