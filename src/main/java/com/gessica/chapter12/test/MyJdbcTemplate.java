package com.gessica.chapter12.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.mybatis.spring.SqlSessionFactoryBean;

import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.StatementCallback;

public class MyJdbcTemplate {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("Spring_jdbcTemplata.xml");
		JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
		Object[] a=new Object[5]; 
		String list = jdbcTemplate.query("", a, new ResultSetExtractor<String>() {

			@Override
			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				return null;
			}
		});
		String str= jdbcTemplate.execute(new ConnectionCallback<String>() {

			@Override
			public String doInConnection(Connection con) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				PreparedStatement ps = con.prepareStatement("sql");
				ResultSet resultSet = ps.executeQuery();
				return null;
			}
		});
//		SqlSessionFactoryBean
	}
	
}
