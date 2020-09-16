package com.gessica.chapter11.game.interceptor;

import com.gessica.chapter11.game.Interceptor;

public class RoleInterceptor implements Interceptor {

	@Override
	public void before(Object obj) {
		System.out.println("ready");

	}

	@Override
	public void after(Object obj) {
		System.out.println("after");

	}

	@Override
	public void afterReturning(Object obj) {
		System.out.println("afterReturning");
	}

	@Override
	public void afterThoreing(Object obj) {
		System.out.println("afterThoreing");
	}

}
