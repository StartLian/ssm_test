package com.gessica.server9;

public class Role {
	private long id;
	private String roleName;
	private String note;
	/*******setter and getter****/
	public Role(String roleName, String note) {
		super();
		this.roleName = roleName;
		this.note = note;
	}
}
