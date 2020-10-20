package com.gessica.chapter11.aop.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gessica.chapter11.game.pojo.Role;
import com.gessica.chapter11.game.server.RoleServer;

public class ProxyFactoryBeanAspectMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean/SpringAop_proxyfactory.xml");
		RoleServer roleServeice = applicationContext.getBean(RoleServer.class);
		Role role = new Role(1L,"xml_aspect_name","xml_aspect_note");
		roleServeice.printRoleinfo(role);
	}
}
