package com.gessica.chapter13;

import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class TestTrasactionmanager {

	private static PlatformTransactionManager transactionManager;
	private static TransactionStatus status;

	public static void main(String[] args) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("chapter13_spring_mybatis.xml");
			JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
			DefaultTransactionDefinition def = new DefaultTransactionDefinition();
			transactionManager = context.getBean(PlatformTransactionManager.class);
			status = transactionManager.getTransaction(def);
			jdbcTemplate.update("INSERT into t_role(role_name,note) VALUES('roleName_transactionManager','note_transactionManager')");
			transactionManager.commit(status);
		} catch (Exception e) {
			e.printStackTrace();
			transactionManager.rollback(status);
		} 
	}

}
