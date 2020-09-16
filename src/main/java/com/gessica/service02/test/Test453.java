package com.gessica.service02.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.gessica.service02.Chapter3Main;
import com.gessica.service02.SqlSessionFactoryUtils;
import com.gessica.service02.mapper.UserMapper;
import com.gessica.service02.pojo.User;

public class Test453 {

	public static void main(String[] args) {
		Logger log = Logger.getLogger(Chapter3Main.class);
		try {
			SqlSession sqlSession = null;
				sqlSession = SqlSessionFactoryUtils.openSqlSession();
				UserMapper mapper = sqlSession.getMapper(UserMapper.class);
				User role =  mapper.getUser(1L);
				log.info(role.toString());
				log.info(role.getSex().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
