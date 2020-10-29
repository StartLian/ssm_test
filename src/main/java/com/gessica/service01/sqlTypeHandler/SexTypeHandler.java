package com.gessica.service01.sqlTypeHandler;

import java.sql.CallableStatement;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.Logger;

import com.gessica.service02.utils.SexEnum;
@MappedTypes(SexEnum.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class SexTypeHandler implements TypeHandler<SexEnum> {
	Logger logger = Logger.getLogger(SexTypeHandler.class);

	public void setParameter(PreparedStatement ps, int i, SexEnum parameter, JdbcType jdbcType) throws SQLException {
		
		
	}

	public SexEnum getResult(ResultSet rs, String columnName) throws SQLException {
		return null;
	}

	public SexEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public SexEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
