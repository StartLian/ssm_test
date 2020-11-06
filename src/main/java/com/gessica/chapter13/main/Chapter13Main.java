package com.gessica.chapter13.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gessica.chapter13.pojo.Role;
import com.gessica.chapter13.service.RoleListService;

public class Chapter13Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("chapter13_spring_mybatis.xml");
		
		RoleListService roleListService = context.getBean(RoleListService.class);
//		RoleService roleListService = context.getBean(RoleService.class);
		List<Role> roleList = new ArrayList<Role>();
		for (int i = 0; i < 2; i++) {
			Role role = new Role("Role_name"+i, "role_note"+i);
			roleList.add(role);
			
		}
		int insertRoleList = roleListService.insertRoleList(roleList);
		System.out.println("insertRoleList:"+insertRoleList);
	}

}
