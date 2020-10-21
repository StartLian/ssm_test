package com.gessica.chapter11.multi.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gessica.chapter11.multi.bean.MultiBean;
import com.gessica.chapter11.multi.config.MultiConfig;

public class MultiMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MultiConfig.class);
		MultiBean bean = ctx.getBean(MultiBean.class);
		bean.testMulti();
	}

}
