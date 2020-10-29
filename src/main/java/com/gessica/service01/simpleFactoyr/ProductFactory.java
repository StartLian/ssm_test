package com.gessica.service01.simpleFactoyr;

public class ProductFactory implements IProductFactory {

	private IProductFactory product;

	public IProduct createProduct(String productNo) {
		char c = productNo.charAt(0);
		if (c == '1') {
			
			product = new Product1();
		}else if (c == '2'){
			product = new Product2();
		}
		if (product != null) {
			return product.createProduct(productNo);
		}
		return null;
	}
	public static void main(String[] args) {
		ProductFactory productFactory = new ProductFactory();
		IProduct createProduct = productFactory.createProduct("1警车");
		System.out.println("颜色："+createProduct.getColor());
	}

}
