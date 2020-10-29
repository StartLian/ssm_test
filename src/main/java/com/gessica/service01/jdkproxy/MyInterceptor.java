package com.gessica.service01.jdkproxy;

import java.lang.reflect.Method;
/**
 * @author 廉吉鹏
 * @date2019年4月16日下午10:03:49
 * TODO CFLIB动态代理拦截器实现类
 */

public class MyInterceptor implements Interceptor {

	public boolean before(Object proxy, Object targer, Method method, Object[] agrs) {
		System.out.println("反射方法前逻辑");
		return false;
	}

	public void around(Object proxy, Object targer, Method method, Object[] agrs) {
		System.out.println("取代了被代理方法");

	}

	public void after(Object proxy, Object targer, Method method, Object[] agrs) {
		System.out.println("反射方法后逻辑");
	}

}
