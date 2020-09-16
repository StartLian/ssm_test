package com.gessica.chapter10.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.gessica.chapter10.annotation.pojo.Role;
import com.gessica.chapter10.annotation.server.impl.RoleServerImpl;
import com.gessica.chapter10.annotation.server.impl.RoleServerImpl2;

//@ComponentScan(basePackageClasses = {Role.class,RoleServerImpl.class,RoleServerImpl2.class})
@ComponentScan(basePackages = {"com.gessica.chapter10.annotation.server","com.gessica.chapter10.annotation.pojo"})
//@ComponentScan(basePackages = {"com.gessica.chapter10.annotation.server","com.gessica.chapter10.annotation.pojo"},basePackageClasses = {Role.class,RoleServerImpl.class})
//@Import({ApplicationConfig1.class,ApplicationConfig2.class})
@Configuration
@PropertySource(value= {"classpath:jdbc.properties"},ignoreResourceNotFound = true)
public class ApplicationConfig {

}
