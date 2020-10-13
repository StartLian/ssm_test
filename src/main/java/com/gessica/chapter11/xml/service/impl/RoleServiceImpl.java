package com.gessica.chapter11.xml.service.impl;

import com.gessica.chapter11.game.pojo.Role;
import com.gessica.chapter11.xml.service.RoleServeice;

public class RoleServiceImpl implements RoleServeice {
	@Override
	public void printRole(Role role) {
		System.out.println("xml.service.impl.RoleServiceImpl->"+role.toString());
	}
}
