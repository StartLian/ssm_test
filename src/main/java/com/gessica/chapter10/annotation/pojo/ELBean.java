package com.gessica.chapter10.annotation.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("elbean")
public class ELBean {
	@Value("#{role}")
	private Role role;
	@Value("#{role.id+1}")
	private Long id;
	@Value("#{role.getNote().tostring()+role.name}")
	private String note;
	@Value("#{T(Math).PI}")
	private double pi;
}
