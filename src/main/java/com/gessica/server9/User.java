package com.gessica.server9;

public class User {
	private long id;
	private String roleName;
	private String note;
	/*******setter and getter****/
	public User(String roleName, String note) {
		super();
		this.roleName = roleName;
		this.note = note;
	}
}
