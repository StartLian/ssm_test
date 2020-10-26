package com.gessica.chapter12.main;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import com.gessica.chapter12.mapper.RoleMapper;
import com.gessica.chapter12.pojo.Role;

public class TestMainSpringMybatis1 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("chapter12_spring_mybatis.xml");
		
		RoleMapper roleMapper = context.getBean(RoleMapper.class);
		Role role = new Role( "lianjipeng", "dashuagela");
		roleMapper.insertRole(role);
		Long id = role.getId();
		Role role2 = roleMapper.getRole(id);
		System.out.println(role2.toString());
		Role role3 = new Role( 7L,"lianjipeng_updata", "dashuagelala");
		roleMapper.updateRole(role3);
//		roleMapper.deleteRole(id);
//		DataSourceTransactionManager
		
	}

}
