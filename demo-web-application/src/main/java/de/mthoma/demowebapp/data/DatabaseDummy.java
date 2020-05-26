package de.mthoma.demowebapp.data;


/**
 * @author mthoma
 * @version 1.0
 * @created 26-Mai-2020 17:04:48
 */
class DatabaseDummy {

	private final List<User> database = new ArrayList();;



	public void finalize() throws Throwable {

	}

	public DatabaseDummy(){
		this.init();
	}

	/**
	 * 
	 * @param alias    Unique identifier of the user.
	 */
	public User getByAlias(String alias){
		return null;
	}

	private void init(){

	}

}