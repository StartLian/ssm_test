package com.gessica.chapter11.game.server.impl;

import org.springframework.stereotype.Component;

import com.gessica.chapter11.game.pojo.Role;
import com.gessica.chapter11.game.server.RoleServer;


@Component
public class RoleServerImpl implements RoleServer{

	public void printRoleinfo(Role role) {
		System.out.println(role.getRoleName());
	}


}
