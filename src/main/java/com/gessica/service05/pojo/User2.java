package com.gessica.service05.pojo;

import java.util.List;

import com.gessica.service02.utils.SexEnum;

public class User2 {
	private Long id;
	private String userName;
	private String realName;
	private SexEnum sex;
	private String mobile;
	private String email;
	private String note;
	private List<Role2> roleList;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public SexEnum getSex() {
		return sex;
	}
	public void setSex(SexEnum sex) {
		this.sex = sex;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public List<Role2> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<Role2> roleList) {
		this.roleList = roleList;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	@Override
	public String toString() {
		return "User2 [id=" + id + ", userName=" + userName + ", realName=" + realName + ", sex=" + sex + ", mobile="
				+ mobile + ", email=" + email + ", note=" + note + ", roleList=" + roleList + "]";
	}
	
	
	
}
