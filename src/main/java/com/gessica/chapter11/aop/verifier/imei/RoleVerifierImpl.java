package com.gessica.chapter11.aop.verifier.imei;

import com.gessica.chapter11.aop.verifier.RoleVerifier;
import com.gessica.chapter11.game.pojo.Role;

public class RoleVerifierImpl implements RoleVerifier {
	public boolean verify(Role role) {
		System.out.println("role != null->"+role.getNote());
		return role != null;
	}
}
