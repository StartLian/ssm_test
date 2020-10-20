package com.gessica.chapter11.xml.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

import com.gessica.chapter11.aop.verifier.RoleVerifier;
import com.gessica.chapter11.game.pojo.Role;

public class XmlAspect {
	public RoleVerifier roleverifier;
	public void before(Role role) {
		System.out.println("XmlAspect->before->role1111:"+role.toString());
	}
	public void after() {
		System.out.println("XmlAspect->after");
	}
	public void afterreturning() {
		System.out.println("XmlAspect->afterreturning");
	}
	public void afterthrowing() {
		System.out.println("XmlAspect->afterthrowing");
	}
	public void around(ProceedingJoinPoint jp) {
		System.out.println("XmlAspect->around");
		System.out.println("XmlAspect->around-before");
		try {
			jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("XmlAspect->around-after");
	}
}
