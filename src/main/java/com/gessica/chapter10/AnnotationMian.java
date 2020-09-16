package com.gessica.chapter10;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gessica.chapter10.annotation.config.ApplicationConfig;
import com.gessica.chapter10.annotation.pojo.PojoConfig;
import com.gessica.chapter10.annotation.pojo.Role;
import com.gessica.chapter10.annotation.server.impl.RoleServerImpl2;

public class AnnotationMian {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PojoConfig.class);
		Role role = applicationContext.getBean(Role.class);
		Role role1 = applicationContext.getBean(Role.class);
		System.out.println(role.getId());
		System.out.println(role==role1);
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
//		String url = context.getEnvironment().getProperty("database.url");
//		System.err.println(url);
//		Role role = context.getBean(Role.class);
//		RoleServerImpl2 roleServerImpl = context.getBean(RoleServerImpl2.class);
////		roleServerImpl.printRoleinfo(role);
//		roleServerImpl.printRoleinfo();
//		context.close();
	}
	/*
	 * @Bean(name = "dataSource") public DataSource getdataSource() { Properties
	 * props = new Properties(); props.setProperty("driver",
	 * "com.mysql.jdbc.Driver"); props.setProperty("url",
	 * "jdbc:mysql://localhost:3306/chapter12"); props.setProperty("username",
	 * "root"); props.setProperty("password", "123456"); BasicDataSource dataSource
	 * = null; try { dataSource = BasicDataSourceFactory.createDataSource(props); }
	 * catch (Exception e) { // TODO Auto-generated catch block e.printStackTrace();
	 * } return dataSource; }
	 */
}
