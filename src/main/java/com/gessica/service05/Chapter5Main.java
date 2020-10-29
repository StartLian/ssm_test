package com.gessica.service05;

import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.gessica.service02.SqlSessionFactoryUtils;
import com.gessica.service02.mapper.RoleMapper;
import com.gessica.service02.pojo.Role;

public class Chapter5Main {
	static Logger log = Logger.getLogger(Chapter5Main.class);
	public static void main(String[] args) {
		/*SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
		SqlSession sqlSession2 = SqlSessionFactoryUtils.openSqlSession();
		RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
//		List<Role> findRoles2 = mapper.findRoles("me");
		Role role = mapper.getRole(19L);
		sqlSession.commit();
		log.debug(	role.toString());
		log.debug(	"again......");
		RoleMapper mapper2 = sqlSession2.getMapper(RoleMapper.class);
		Role role1 = mapper2.getRole(19L);
		sqlSession2.commit();
		log.debug(	role1.toString());*/
//		ExpressionParser
		SpelExpressionParser parser = new SpelExpressionParser();
		Expression parseExpression = parser.parseExpression("'hello world'");
		String str = (String) parseExpression.getValue();
		log.info("str:"+str);
	}
}
