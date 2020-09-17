package com.gessica.chapter11.game;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBeanUtils implements InvocationHandler {

	private Object obj;
	private Interceptor interceptor;

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		boolean exceptionFlag = false;
		Object retObj = null;
		interceptor.before(obj);
		try {
			retObj = method.invoke(obj, args);
		} catch (Exception e) {
			exceptionFlag =true;
			e.printStackTrace();
		}finally {
			interceptor.after(obj);
		}
		if (exceptionFlag) {
			interceptor.afterThoreing(obj);
		}else {
			interceptor.afterReturning(obj);
		}
		return retObj;
	}

	public static Object getBean(Object obj, Interceptor interceptor) {
		ProxyBeanUtils _this = new ProxyBeanUtils();
		_this.obj = obj;
		_this.interceptor = interceptor;
		return Proxy.
				newProxyInstance(obj.getClass().getClassLoader(), 
						obj.getClass().getInterfaces(), _this);
	}

}
