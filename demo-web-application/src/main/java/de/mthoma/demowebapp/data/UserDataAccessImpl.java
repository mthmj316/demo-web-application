package de.mthoma.demowebapp.data;

/**
 * @author mthoma
 * @version 1.0
 * @created 27-Mai-2020 08:38:37
 */
public class UserDataAccessImpl implements UserDataAccess {
	
	private DatabaseDummy databaseDummy = new DatabaseDummy();

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
		return this.databaseDummy.getByAlias(alias);
	}

	/**
	 * Returns true if the combination of the alias and password is stored in the
	 * database.
	 * 
	 * @param alias    The login name of the user.
	 * @param password    The password of the user.
	 */
	public boolean verifyLogin(String alias, String password){
		return this.databaseDummy.existsAliasPasswordCombination(alias, password);
	}

}