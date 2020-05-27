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
	
	/*
	 * Is the the last user object which has been found in the database.
	 */
	private User lastFoundUser = NULL_USER;

	private final List<User> database = new ArrayList<>();

	DatabaseDummy(){
		this.init();
	}

	/**
	 * Searches in the database for the user with the given alias, and checks if the
	 * password in the database matches with the given password.
	 * 
	 * If the search for the alias was successful the found user will be written to the lastFoundUser attribute
	 * no matter if the password matches.
	 * @see DatabaseDummy#getLastFoundUser()
	 * 
	 * @param alias    Login name of the user.
	 * @param password    Password of the user.
	 */
	boolean existsAliasPasswordCombination(String alias, String password){
		
		User foundUser = this.getByAlias(alias);
				
		return (foundUser != NULL_USER && foundUser.getPassword().equals(password));
	}
	
	/**
	 * Resets the lastFoundUser attribute to the NUL_USER object again.
	 * 
	 * @see DatabaseDummy#getLastFoundUser()
	 */
	void clearLastFoundUser() {
		this.lastFoundUser = NULL_USER;
	}
	
	/**
	 * Returns the user object which has been searched and found last.
	 * If no search has been performed or nothing has been found NULL_USER will be returned.
	 * @return {@link User}
	 */
	User getLastFoundUser() {
		return this.lastFoundUser;
	}

	/**
	 * Returns the {@link User} for the given alias or {@link User#NULL_USER} if not available.
	 * 
	 * If the search was successful the found user will be written to the lastFoundUser attribute.
	 * @see DatabaseDummy#getLastFoundUser()
	 * 
	 * @param alias    Unique identifier of the user.
	 */
	User getByAlias(String alias){
		
		for(User user : this.database) {
		
			if(user.getAlias().equals(alias)) {
				
				this.lastFoundUser = user;
				
				return user;
			}
		}
		
		return NULL_USER;
	}

	/*
	 * Creates the dummy data base entries.
	 */
	private void init(){

		User user = new User();
		user.setAge(28);
		user.setAlias("brainy");
		user.setMale(true);
		user.setName("David Brain");
		user.setPassword("qwertz1");
		
		this.database.add(user);
		
		user.setAge(31);
		user.setAlias("mila");
		user.setMale(false);
		user.setName("Mina LaRoss");
		user.setPassword("0815Witz");
		
		this.database.add(user);
		
		user.setAge(47);
		user.setAlias("McCabe");
		user.setMale(true);
		user.setName("Robert Calf");
		user.setPassword("asd98");
		
		this.database.add(user);
		
		user.setAge(19);
		user.setAlias("coloso");
		user.setMale(true);
		user.setName("Coby Losoro");
		user.setPassword("myson12");
		
		this.database.add(user);
		
		user.setAge(22);
		user.setAlias("gabö");
		user.setMale(false);
		user.setName("Gaby Drösel");
		user.setPassword("ilikeu");
		
		this.database.add(user);
	}
}