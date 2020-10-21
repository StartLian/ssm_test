package com.gessica.chapter11.multi.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(3)
public class Aspect3 {
	@Pointcut("execution(* com.gessica.chapter11.multi.bean.impl.MultiBeanImpl.testMulti(..))")
	public void print() {
		
	}
	@Before("print()")
	public void before() {
		System.out.println("Aspect3->before");
	}
	@After("print()")
	public void after() {
		System.out.println("Aspect3->after");
	}
	@AfterReturning("print()")
	public void afterreturning() {
		System.out.println("Aspect3->afterreturning");
	}
	@AfterThrowing("print()")
	public void afterthrowing() {
		System.out.println("Aspect3->afterthrowing");
	}
//	@Around("print()")
//	public void around(ProceedingJoinPoint jp) {
}
