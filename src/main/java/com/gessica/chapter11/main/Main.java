package com.gessica.chapter11.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gessica.chapter11.aop.config.AopConfig;
import com.gessica.chapter11.aop.service.RoleServer;
import com.gessica.chapter11.aop.verifier.RoleVerifier;
import com.gessica.chapter11.game.pojo.Role;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);
		RoleServer bean = ctx.getBean(RoleServer.class);
		RoleVerifier roleVerifier = (RoleVerifier) bean;
		Role role = new Role(1L, "testaop", "aoptest");
		if (roleVerifier.verify(role)) {
			bean.printRoleinfo(role);
		}
//		bean.printRoleinfo(role,1);
		System.out.println("###################");
		role=null;
		bean.printRoleinfo(role);
		
	}

}
