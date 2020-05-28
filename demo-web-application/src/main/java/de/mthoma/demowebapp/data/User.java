package de.mthoma.demowebapp.data;


/**
 * Represents one user in the Database
 * @author mthoma
 * @version 1.0
 * @created 27-Mai-2020 08:38:37
 */
public class User {

	private int age;
	/**
	 * The name which is used to login to the system.
	 * @return String
	 */
	private String alias;
	/**
	 * Per default this attribute is set to <i>true</i>
	 */
	private boolean male = true;
	private String name;
	private String password;

	public User(){
		super();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [age=");
		builder.append(age);
		builder.append(", ");
		if (alias != null) {
			builder.append("alias=");
			builder.append(alias);
			builder.append(", ");
		}
		builder.append("male=");
		builder.append(male);
		builder.append(", ");
		if (name != null) {
			builder.append("name=");
			builder.append(name);
			builder.append(", ");
		}
		if (password != null) {
			builder.append("password=");
			builder.append(password);
		}
		builder.append("]");
		return builder.toString();
	}

	public int getAge(){
		return age;
	}

	public String getAlias(){
		return alias;
	}

	public String getName(){
		return name;
	}

	public String getPassword(){
		return password;
	}

	/**
	 * Per default isMale returns true if not chnaged,
	 */
	public boolean isMale(){
		return male;
	}

	/**
	 * Set the age attribute.
	 * 
	 * @param newVal    newVal
	 */
	public void setAge(int newVal){
		age = newVal;
	}

	/**
	 * 
	 * @param newVal    newVal
	 */
	public void setAlias(String newVal){
		alias = newVal;
	}

	/**
	 * 
	 * @param newVal    newVal
	 */
	public void setMale(boolean newVal){
		male = newVal;
	}

	/**
	 * 
	 * @param newVal    newVal
	 */
	public void setName(String newVal){
		name = newVal;
	}

	/**
	 * 
	 * @param newVal    newVal
	 */
	public void setPassword(String newVal){
		password = newVal;
	}

}