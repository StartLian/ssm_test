package com.gessica.chapter11.xml.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class XmlAspect {
	public void before() {
		System.out.println("XmlAspect->before");
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
