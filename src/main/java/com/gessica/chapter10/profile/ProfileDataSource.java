package com.gessica.chapter10.profile;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
public class ProfileDataSource {
	 @Bean(name = "devDataSource")
	 @Profile("dev")
	 public DataSource getdevdataSource() { 
		 Properties props = new Properties(); 
		 props.setProperty("driver", "com.mysql.jdbc.Driver"); 
		 props.setProperty("url",
		 "jdbc:mysql://localhost:3306/chapter12"); 
		 props.setProperty("username","root"); 
		 props.setProperty("password", "123456"); 
		 DataSource dataSource = null; 
		 try { 
			 dataSource = BasicDataSourceFactory.createDataSource(props); 
		 } catch (Exception e) {
				 // TODO Auto-generated catch block e.printStackTrace();
		 } 
		 return dataSource; 
	}
	 @Bean(name = "testDataSource")
	 @Profile("test")
	 public DataSource getTestdataSource() { 
		 Properties props = new Properties(); 
		 props.setProperty("driver", "com.mysql.jdbc.Driver"); 
		 props.setProperty("url",
				 "jdbc:mysql://localhost:3306/chapter12"); 
		 props.setProperty("username","root"); 
		 props.setProperty("password", "123456"); 
		 DataSource dataSource = null; 
		 try { 
			 dataSource = BasicDataSourceFactory.createDataSource(props); 
		 } catch (Exception e) {
			 // TODO Auto-generated catch block e.printStackTrace();
		 } 
		 return dataSource; 
	 }
		 
}
