package com.gessica.service05.pojo;

public class RoleBean {
	private String roleName;
	private String note;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "RoleBean [roleName=" + roleName + ", note=" + note + "]";
	}
	
}
