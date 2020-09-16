package com.gessica.service02;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.gessica.service02.mapper.RoleMapper;
import com.gessica.service02.pojo.Role;
public class MySqlSessionFactory {
	private SqlSession openSession = null;

	public void readly() {
		String resource = "mybatis-config.xml";
		 try {
			InputStream in = Resources.getResourceAsStream("jdbc.propreties");
			Properties props = new Properties();
			props.load(in);
			String userName = props.getProperty("database.username");
			String passWord = props.getProperty("database.password");
			//解密用户名密码,并在属性中重置
//			props.put("database.username", decode(userName));
//			props.put("database.password", decode(password));
			
			InputStream inputStream = Resources.getResourceAsStream(resource);
			//使用从程序传递参数的方式覆盖原有properties中的属性
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,props);
			openSession  = sqlSessionFactory.openSession();
//			Role role= (Role)openSession.selectOne("com.gessica.service02.mapper.RoleMapper.getRole",1L);
//			RoleMapper mapper = openSession.getMapper(RoleMapper.class);
//			mapper.getRole(1L);
			//some code 
			openSession .commit();//提交事务
		 } catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (openSession != null) {
				openSession.close();
			}
		}
	}
}
