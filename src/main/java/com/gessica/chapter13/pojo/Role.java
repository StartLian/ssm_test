package com.gessica.chapter13.pojo;

import org.springframework.beans.factory.annotation.Value;

public class Role {
	private Long id;
	private String roleName;
	private String note;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	
	public Role(Long id, String roleName, String note) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.note = note;
	}
	
	public Role(String roleName, String note) {
		super();
		this.roleName = roleName;
		this.note = note;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", note=" + note + "]";
	}
	
}
