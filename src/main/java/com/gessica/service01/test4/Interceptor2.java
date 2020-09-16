package com.gessica.service01.test4;

import java.lang.reflect.Method;
/**
 * @author 廉吉鹏
 * @date2019年4月16日下午10:03:49
 * TODO CFLIB动态代理拦截器实现类
 */

public class Interceptor2 implements Interceptor {

	public boolean before(Object proxy, Object targer, Method method, Object[] agrs) {
		System.out.println("拦截器2的before方法");
		return true;
	}

	public void around(Object proxy, Object targer, Method method, Object[] agrs) {
		System.out.println("取代了被代理方法");

	}

	public void after(Object proxy, Object targer, Method method, Object[] agrs) {
		System.out.println("拦截器2的after方法");
	}

}
