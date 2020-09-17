package com.gessica.chapter11.game.main;

import com.gessica.chapter11.game.ProxyBeanFactory;
import com.gessica.chapter11.game.interceptor.RoleInterceptor;
import com.gessica.chapter11.game.pojo.Role;
import com.gessica.chapter11.game.server.RoleServer;
import com.gessica.chapter11.game.server.impl.RoleServerImpl;

public class GameMain {

	public static void main(String[] args) {
		RoleServer roleServerImpl = new RoleServerImpl();
		RoleInterceptor roleInterceptor = new RoleInterceptor();
		RoleServer bean = ProxyBeanFactory.getBean(roleServerImpl, roleInterceptor);
		Role role = new Role(1L, "roleInterceptor", "roleInterceptor_test");
		bean.printRoleinfo(role);
		role =null;
		bean.printRoleinfo(role);
		
	}

}
