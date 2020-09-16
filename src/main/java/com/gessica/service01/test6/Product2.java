package com.gessica.service01.test6;

public class Product2 implements IProductFactory {

	public IProduct createProduct(String name) {
		System.out.println("具体工厂二:"+name);
		return null;

	}

}
