package com.gessica.chapter13.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gessica.chapter13.mapper.RoleMapper;
import com.gessica.chapter13.pojo.Role;
import com.gessica.chapter13.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleMapper roleMapper;
	Logger log=Logger.getLogger(RoleServiceImpl.class);
	@Override
//	@Transactional(propagation = Propagation.NESTED ,isolation = Isolation.READ_COMMITTED)
	@Transactional(propagation = Propagation.REQUIRES_NEW ,isolation = Isolation.READ_COMMITTED)
	public int insertRole(Role role) {
		return roleMapper.insertRole(role);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED ,isolation = Isolation.READ_COMMITTED)
	public int insertRoleList(List<Role> roleList) {
		int count = 0;
		for (Role role : roleList) {
			//调用类自身方法，产生的自调用问题
			insertRole(role);
			count++;
		}
		return count;
	}

}
