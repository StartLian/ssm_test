package com.gessica.service05;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.gessica.service02.Chapter3Main;
import com.gessica.service02.SqlSessionFactoryUtils;
import com.gessica.service02.mapper.RoleMapper;
import com.gessica.service02.pojo.Role;
import com.gessica.service02.utils.SexEnum;

public class Test51 {
	public static void main(String[] args) {
		Logger log = Logger.getLogger(Chapter3Main.class);
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
			HashMap<String,Object> hashMap = new HashMap<String,Object>();
			hashMap.put("roleName","1");
			hashMap.put("note","123");
//			List<Role> roles = mapper.getRoles(hashMap);
//			List<Role> roles = mapper.getRoles("jessicas","me");
			Role roleBean = new Role();
			roleBean.setRoleName("lianjipengaidali123");
			roleBean.setNote("updata36j");
			roleBean.setId(36);
//			boolean insert1 = mapper.insertRoleID2(roleBean);
			boolean insert1 = mapper.updateRole(roleBean);
			mapper.deleteRole(33L);
			sqlSession.commit();
//			boolean updateRole = mapper.updateRole(roleBean);
//			log.info("updateRole:"+updateRole);
			log.info("insert1:"+insert1);
//			List<Role> roles = mapper.findByRowBounds("jessica","me",new RowBounds(0, 100));
//			PageParams pageParams = new PageParams();
//			pageParams.setStart(0);
//			pageParams.setLimit(1);
//			List<Role> roles = mapper.findByMix(roleBean,pageParams);
			Role role = mapper.getRoleBySQL1(29L);
			log.info(role.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}
