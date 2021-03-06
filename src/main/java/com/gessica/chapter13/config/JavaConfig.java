package com.gessica.chapter13.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
@ComponentScan("com.gessica.chapter13.*")
//使用事务驱动管理器
@EnableTransactionManagement
public class JavaConfig implements TransactionManagementConfigurer{
	private DataSource datasource=null;
	/**
	 * 配置数据库
	 * @return
	 */
	@Bean(name = "dataSource")
	public DataSource initDataSource() {
		//...
		return datasource;
	}
	@Bean(name = "dataSource")
	public JdbcTemplate initJdbcTemplate() {
		//...
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(initDataSource());
		return jdbcTemplate;
	}
	
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(initDataSource());
		return dataSourceTransactionManager;
	}

}
