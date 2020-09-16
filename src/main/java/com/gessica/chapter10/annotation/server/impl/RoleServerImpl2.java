package com.gessica.chapter10.annotation.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gessica.chapter10.annotation.pojo.Role;
import com.gessica.chapter10.annotation.server.RoleServer2;
@Component("RoleServer2")
public class RoleServerImpl2 implements RoleServer2{
	@Autowired
	private Role role= null;
	public void printRoleinfo() {
		System.out.println(role.getRoleName());
	}

//	@Autowired
//	public void setRole(Role role) {
//		this.role =role;
//	}
}
