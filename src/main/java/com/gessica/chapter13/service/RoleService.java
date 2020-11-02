package com.gessica.chapter13.service;


import java.util.List;

import com.gessica.chapter13.pojo.Role;

public interface RoleService {
	public int insertRole(Role role);
	public int insertRoleList(List<Role> roleList);
}
