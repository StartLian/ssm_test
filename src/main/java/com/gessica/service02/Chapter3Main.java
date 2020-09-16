package com.gessica.service02;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.transaction.Transaction;
import org.apache.log4j.Logger;

import com.gessica.service02.mapper.RoleMapper;
import com.gessica.service02.pojo.Role;

public class Chapter3Main {


	public static void main(String[] args) {
		Logger log = Logger.getLogger(Chapter3Main.class);
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
//			List<Role> findRoles2 = mapper.findRoles("me");
			Role role = mapper.getRole(0L);
			log.debug(	role.toString());
//			List<Role> roles = mapper.findRoles("Jessca");
//			log.debug(roles.toString());
//			Transaction
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

}
