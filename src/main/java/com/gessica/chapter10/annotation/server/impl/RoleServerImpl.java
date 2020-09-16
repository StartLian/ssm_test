package com.gessica.chapter10.annotation.server.impl;

import org.springframework.stereotype.Component;

import com.gessica.chapter10.annotation.pojo.Role;
import com.gessica.chapter10.annotation.server.RoleServer;
@Component
public class RoleServerImpl implements RoleServer{

	public void printRoleinfo(Role role) {
		System.out.println(role.getRoleName());
	}

}
