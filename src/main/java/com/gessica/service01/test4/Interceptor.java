package com.gessica.service01.test4;

import java.lang.reflect.Method;

public interface Interceptor {
	//proxy 代理对象， targer 真是对象，method 方法，agrs 参数
	//boobean 返回 true为反射真是对象，false则调用around，最后调用after
	public boolean before(Object proxy,Object targer,Method method,Object[] args );
	public void around(Object proxy,Object targer,Method method,Object[] args );
	public void after(Object proxy,Object targer,Method method,Object[] args );
}
