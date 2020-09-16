package com.gessica.chapter11.game;

public class ProxyBeanFactory {
	public static <T> T getBean(T obj,Interceptor interceptor) {
		return (T)ProxyBeanUtils.getBean(obj,interceptor);
	}
}
