package com.gessica.service01.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.gessica.service01.simplejdkproxy.HelloWord;
import com.gessica.service01.simplejdkproxy.HelloWordImpl;

public class InterceptorJdkProxy implements InvocationHandler {
	
	private Object targer;//真实对象
	private String interptorClass;//拦截器权限类名

	public InterceptorJdkProxy(Object targer,String interptorClass){
		this.targer = targer;
		this.interptorClass =interptorClass;
	}
	/**
	  * 绑定委托对象并返回一个（代理占位）
	 * @param targer 真实对象
	 * @param interceptorClass 代理对象【占位】
	 * @return
	 */
	 public static Object bind(Object targer,String interceptorClass) {
		 //取代代理对象
		 return Proxy.newProxyInstance(targer.getClass().getClassLoader(), targer.getClass().getInterfaces(), new InterceptorJdkProxy(targer, interceptorClass));
	 }
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(interptorClass == null) {
			//没有设置拦截器则直接反射原有方法
			return method.invoke(targer, args);
		}
		Object result = null;
		//通过反射生成拦截器
		Interceptor interptor = (Interceptor) Class.forName(interptorClass).newInstance();
		//调用前置方法
		System.out.println("开始调用befer");
		if (interptor.before(proxy, args, method, args)) {
			
			//反射原有对象方法
			result = method.invoke(targer, args);
		} else {//返回false则执行around
			System.out.println("开始调用around");
			interptor.around(proxy, targer, method, args);
		}
		//调用后方法
		System.out.println("开始调用after");
		interptor.after(proxy, targer, method, args);
		return result;
	}
	public static void main(String[] args) {
//		HelloWord proxy = (HelloWord) InterceptorJdkProxy.bind(new HelloWordImpl(), "com.gessica.service01.jdkproxy.MyInterceptor");
//		proxy.sayHelloWord();
		HelloWord proxy1 = (HelloWord) InterceptorJdkProxy.bind(new HelloWordImpl(), "com.gessica.service01.jdkproxy.Interceptor1");
		HelloWord proxy2 = (HelloWord) InterceptorJdkProxy.bind(proxy1, "com.gessica.service01.jdkproxy.Interceptor2");
		HelloWord proxy3 = (HelloWord) InterceptorJdkProxy.bind(proxy2, "com.gessica.service01.jdkproxy.Interceptor3");
		proxy3.sayHelloWord();
	}

}
