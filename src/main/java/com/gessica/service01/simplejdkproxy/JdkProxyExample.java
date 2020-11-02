package com.gessica.service01.simplejdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyExample implements InvocationHandler {
	
	private Object target;

	public Object bind(Object target){
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("调用真实对向前");
		Object object = method.invoke(target, args);
		System.out.println("调用真实对向后");
		return object;
	}

	public static void main(String[] args) {
		 JdkProxyExample jdkProxyExample = new JdkProxyExample();
		 HelloWord helloWord = (HelloWord) jdkProxyExample.bind(new HelloWordImpl());
		 helloWord.sayHelloWord();
	}


}
