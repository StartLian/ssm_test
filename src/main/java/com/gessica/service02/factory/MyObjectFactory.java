package com.gessica.service02.factory;

import java.util.List;
import java.util.Properties;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

public class MyObjectFactory extends DefaultObjectFactory {
	private static final long serialVersionUID = 1L;
	private Object temp;
	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
		super.setProperties(properties);
		System.out.println("初始化参数："+properties.toString());
	}
	//方法二
	@Override
	public <T> T create(Class<T> type) {
		T res = super.create(type);
		System.out.println("创建对象："+res.toString());
		System.err.println("是否同一对象："+(temp == res));
		return res;
	}
	//方法一
	@Override
	public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
		// TODO Auto-generated method stub
		T res = super.create(type, constructorArgTypes, constructorArgs);
		System.out.println("chuangjianduixiang :"+res.toString());
		temp = res;
		return res;
	}
	@Override
	public <T> boolean isCollection(Class<T> type) {
		System.out.println("isCollection");
		// TODO Auto-generated method stub
		return super.isCollection(type);
	}
}
