package com.gessica.arithmetic.tree20_09_01;

public class MyClassLoder extends ClassLoader{

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return defineClass(null, 0, 10);
	}

}
