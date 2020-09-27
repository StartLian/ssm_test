package com.gessica.chapter11.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class RoleAspect2 {
	@Before("execution(*com.gessica.chapter11.*.*.*.*.*(..) "
			+ "&& witkin(com.gessica.chapter11.aop.service.impl.*)")
	public void before() {
		System.out.println("RoleAspect->before");
	}
//	@Before("execution(*com.gessica.chapter11.aop.service.impl.RoleServerImpl.*(..)")
//	public void before() {
//		System.out.println("RoleAspect->before");
//	}
	@After("execution(*com.gessica.chapter11.aop.service.impl.RoleServerImpl.*(..)")
	public void after() {
		System.out.println("RoleAspect->after");
	}
	@AfterReturning("execution(*com.gessica.chapter11.aop.service.impl.RoleServerImpl.*(..)")
	public void afterreturning() {
		System.out.println("RoleAspect->afterreturning");
	}
	@AfterThrowing("execution(*com.gessica.chapter11.aop.service.impl.RoleServerImpl.*(..)")
	public void afterthrowing() {
		System.out.println("RoleAspect->afterthrowing");
	}
}
