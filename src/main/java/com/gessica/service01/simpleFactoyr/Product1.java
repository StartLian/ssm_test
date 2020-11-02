package com.gessica.service01.simpleFactoyr;

public class Product1 implements IProductFactory {

	public IProduct createProduct(String name) {
		System.out.println("具体工厂一:"+name);
		IProduct iProduct = new IProduct();
		iProduct.setName(name);
		iProduct.setColor("red");
		return iProduct;

	}

}
