package com.gessica.chapter11.xml.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gessica.chapter11.game.pojo.Role;
import com.gessica.chapter11.xml.service.RoleServeice;

public class XmlAspectMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("xmlaspect_bean.xml");
		RoleServeice roleServeice = applicationContext.getBean(RoleServeice.class);
		Role role = new Role(1L,"xml_aspect_name","xml_aspect_note");
		roleServeice.printRole(role);

	}

}
