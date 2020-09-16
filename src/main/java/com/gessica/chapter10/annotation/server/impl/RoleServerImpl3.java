package com.gessica.chapter10.annotation.server.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.gessica.chapter10.annotation.pojo.Role;
import com.gessica.chapter10.annotation.server.RoleServer;
@Component("RoleServer3")
@Primary
public class RoleServerImpl3 implements RoleServer{
	public void printRoleinfo(Role role) {
		System.out.println(role.getRoleName());
	}
}
