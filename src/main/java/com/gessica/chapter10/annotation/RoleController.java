package com.gessica.chapter10.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.gessica.chapter10.annotation.server.RoleServer;

@Component
public class RoleController {
	@Autowired
	@Qualifier("RoleServer3")
	private RoleServer roleserver;
//	......

}
