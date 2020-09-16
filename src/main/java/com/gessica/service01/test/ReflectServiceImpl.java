package com.gessica.service01.test;

public class ReflectServiceImpl {
	public void sayHello(String name) {
		System.out.println("Hello "+name);
	}
	public ReflectServiceImpl getInstance(){
		 ReflectServiceImpl object = null;
		try {
			object = (ReflectServiceImpl)Class.forName("com.gessica.service01.test.ReflectServiceImpl").newInstance();
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return object;
	}
	public static void main(String[] args) {
		ReflectServiceImpl reflectServiceImpl = new ReflectServiceImpl();
		reflectServiceImpl.getInstance();

	}

}
