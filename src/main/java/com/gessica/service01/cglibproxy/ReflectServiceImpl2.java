package com.gessica.service01.cglibproxy;

import java.lang.reflect.Method;

public class ReflectServiceImpl2 {
	private String name;
	private Method method;
	public ReflectServiceImpl2(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void sayHello(String name) {
		System.out.println("Hello "+name);
	}
	public ReflectServiceImpl2 getInstance(){
		 ReflectServiceImpl2 object = null;
		try {
			object = (ReflectServiceImpl2)Class.forName("com.gessica.service01.cglibproxy.ReflectServiceImpl2").getConstructor(String.class).newInstance("Jessica");
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return object;
	}
	public static void main(String[] args) {
		ReflectServiceImpl2 reflectServiceImpl2 = new ReflectServiceImpl2("Jessica2");
		reflectServiceImpl2.getInstance().sayHello("Jessica3");
		
		System.out.println("name: "+reflectServiceImpl2.getInstance().getName());
		
		reflectServiceImpl2.reflectMothed();

	}
	Object reflectMothed() {
		ReflectServiceImpl2 reflectServiceImpl2 = new ReflectServiceImpl2("Jessica2");
		Object invoke = null;
		try {
			method = ReflectServiceImpl2.class.getMethod("sayHello",String.class);
			invoke = method.invoke(reflectServiceImpl2, "Jessica4");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return invoke; 
		
	}
}
