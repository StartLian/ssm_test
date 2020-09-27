package com.gessica.chapter11.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;

import com.gessica.chapter11.aop.verifier.RoleVerifier;
import com.gessica.chapter11.aop.verifier.imei.RoleVerifierImpl;
import com.gessica.chapter11.game.pojo.Role;

@Aspect
public class RoleAspect {
	@DeclareParents(value = "com.gessica.chapter11.aop.service.impl.RoleServerImpl+",defaultImpl = RoleVerifierImpl.class)
	public RoleVerifier roleverifier;
	
	@Pointcut("execution(* com.gessica.chapter11.aop.service.impl.RoleServerImpl.printRoleinfo(..))")
	public void print() {
		
	}
//	@Before("execution(* com.gessica.chapter11.aop.service.impl.RoleServerImpl.printRoleinfo(..)) && args(role,sort)")
//	public void before(Role role,int sort) {
//		System.out.println("RoleAspect->before:"+role.toString()+" sort:"+sort);
//	}
	@Before("print()")
	public void before() {
		System.out.println("RoleAspect->before");
	}
	@After("print()")
	public void after() {
		System.out.println("RoleAspect->after");
	}
	@AfterReturning("print()")
	public void afterreturning() {
		System.out.println("RoleAspect->afterreturning");
	}
	@AfterThrowing("print()")
	public void afterthrowing() {
		System.out.println("RoleAspect->afterthrowing");
	}
	@Around("print()")
	public void around(ProceedingJoinPoint jp) {
		System.out.println("RoleAspect->around");
		System.out.println("RoleAspect->around-before");
		try {
			jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("RoleAspect->around-after");
	}
}
