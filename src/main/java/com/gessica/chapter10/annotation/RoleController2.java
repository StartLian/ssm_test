package com.gessica.chapter10.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gessica.chapter10.annotation.server.RoleServer;

@Component
public class RoleController2 {
	@Autowired
	public RoleController2( RoleServer roleserver) {
		
	}
}
