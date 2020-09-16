package com.gessica.service01.test5;

import java.util.Observable;
import java.util.Observer;
/**
 * 京东电商接口
 * @author 廉吉鹏
 * @date2019年4月23日下午10:00:57
 * TODO
 */
public class JingdongOberver implements Observer {

	public void update(Observable o, Object arg) {
		String newProduct = (String) arg;
		System.out.println("发布新产品："+newProduct+"同步到京东");

	}

}
