package com.gessica.chapter11.aop.service.impl;

import org.springframework.stereotype.Component;

import com.gessica.chapter11.aop.service.RoleServer;
import com.gessica.chapter11.game.pojo.Role;

@Component
public class RoleServerImpl implements RoleServer{

	public void printRoleinfo(Role role) {
		System.out.println("show:"+role.toString());
	}


}
