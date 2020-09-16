package com.gessica.server9;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserRoleAssembly {
	private long id;
	private List<Role> list;
	private Set<Role> set;
	private Map<Role,User> map;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Role> getList() {
		return list;
	}
	public void setList(List<Role> list) {
		this.list = list;
	}
	public Map<Role, User> getMap() {
		return map;
	}
	public void setMap(Map<Role, User> map) {
		this.map = map;
	}
	@Override
	public String toString() {
		return "UserRoleAssembly [id=" + id + ", list=" + list + ", map=" + map + ", getId()=" + getId()
				+ ", getList()=" + getList() + ", getMap()=" + getMap() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
