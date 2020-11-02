package com.gessica.service01.cglibproxy;

import java.lang.reflect.Method;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxyExample implements MethodInterceptor {
	/**
	 * 生成CGLIB代理对象
	 * @param clazz
	 * @return
	 */
	public Object getProxy(Class clazz) {
		//CGLIB 增强类对象
		 Enhancer enhancer = new Enhancer();
		 //设置增强类
		 enhancer.setSuperclass(clazz);
		 //定义代理逻辑对象为当前对象，要求当前对象实现MethodInterceptor
		 enhancer.setCallback(this);
		 //生成并返回代理对象
		 return enhancer.create();
	}

	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		System.out.println("调用前");
		Object result = arg3.invokeSuper(arg0, arg2);
		System.out.println("调用后");
		return result;
	}
	public static void main(String[] args) {
		CglibProxyExample cglibProxyExample = new CglibProxyExample();
		ReflectServiceImpl object = (ReflectServiceImpl) cglibProxyExample.getProxy(ReflectServiceImpl.class);
		object.sayHello("Jessica");
	}
	
}
