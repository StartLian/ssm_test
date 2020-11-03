package com.gessica.chapter13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gessica.chapter13.pojo.Role;
import com.gessica.chapter13.service.RoleService;

public class RoleController {
	@Autowired
	private RoleService roleservice;
	public void errorUseServices() {
		Role role1 = new Role("mane_1", "note_1");
		roleservice.insertRole(role1);
		Role role2 = new Role("mane_2", "note_2");
		roleservice.insertRole(role2);
		
	}
	@Transactional(propagation = Propagation.REQUIRED ,isolation = Isolation.READ_COMMITTED)
	public int insertRole(Role role) {
		int insertRole = roleservice.insertRole(role);
		//做非常多事情
		return insertRole;
	}
}
