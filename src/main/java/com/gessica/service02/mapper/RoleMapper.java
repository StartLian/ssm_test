package com.gessica.service02.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.gessica.service02.pojo.Role;
import com.gessica.service05.pojo.PageParams;
import com.gessica.service05.pojo.RoleBean;
/**
 * Role的DAO接口
 * @author 廉吉鹏
 * @date2019年5月9日下午10:04:38
 * TODO
 */
@Mapper
public interface RoleMapper {
	@Insert("INSERT into t_role(role_name,note) VALUES('12biubiu','biubiubiu')")
	public int insertRole1();
	public boolean insertRole(Role role);
	public boolean insertRoleID(Role role);
	public boolean insertRoleID2(Role role);
	public int deleteRole(Long id);
	public boolean updateRole(Role role);
	public Role getRole(Long id);
	public Role getRoleBySQL(Long id);
	public Role getRoleBySQL1(Long id);
	public List<Role> findRoles(String roleName);
	public List<Role> findRoles2(String roleName);
	public List<Role> getRoles( HashMap<String, Object> hashMap);
	public List<Role> getRoles(@Param("roleName") String roleName,@Param("note") String note);
	public List<Role> getRoles(RoleBean roleBean);
	public List<Role> findByMix(@Param("params") RoleBean params,@Param("page") PageParams page);
	public List<Role> findByRowBounds(@Param("roleName") String roleName,@Param("note") String note,RowBounds bounds);
}
