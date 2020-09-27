package com.gessica.chapter11.aop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.gessica.chapter11.aop.aspect.RoleAspect;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.gessica.chapter11.aop")
@Component
public class AopConfig {
	@Bean
	public RoleAspect getRoleAspect() {
		return new RoleAspect();
	}
}
