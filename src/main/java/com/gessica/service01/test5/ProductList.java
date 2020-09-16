package com.gessica.service01.test5;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ProductList extends Observable {
	private List<String> productList = null;//产品列表
	private static ProductList instance;//类唯一实例
	private ProductList() {};
	public static void main(String[] args) {
		ProductList productList = ProductList.getInstance();
		JingdongOberver jingdongOberver = new JingdongOberver();
		TaoBaoOberver taoBaoOberver = new TaoBaoOberver();
		productList.addObserver(taoBaoOberver);
		productList.addObserver(jingdongOberver);
		productList.addProduct("新增产品1");

	}
	/**
	 * 获取实例，产生产品列表
	 * @return
	 */
	public static ProductList getInstance() {
		if (instance == null) {
			instance = new ProductList();
			instance.productList = new  ArrayList<String>();
		}
		return instance;
	}
	/**
	 * 添加观察者
	 * @param observer
	 */
	public void addProductListObervable(Observer observer) {
		this.addObserver(observer);
	}
	/**
	 * 新增产品
	 * @param newProduct
	 */
	public void addProduct(String newProduct) {
		productList.add(newProduct);
		System.out.println("新添了产品："+newProduct);
		this.setChanged();//设置被观察者对象发生了变化
		this.notifyObservers(newProduct);//通知观察者，并传递新产品
	}
	
	
	
	
	
	
	
	
	
	
}
