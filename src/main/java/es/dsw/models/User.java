package es.dsw.models;

public class User {
	
	private String username;
	private String userpassword;
	
	public User(String username, String userpassword) {
		this.username = username;
		this.userpassword = userpassword;
	}
	
	public User() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
}
