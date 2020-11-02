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
@MappedTypes(String.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class MyTypeHandler implements TypeHandler<String> {
	Logger logger = Logger.getLogger(MyTypeHandler.class);
	public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
		logger.info("setParameter:"+parameter);
		ps.setString(i, parameter);
	}

	public String getResult(ResultSet rs, String columnName) throws SQLException {
		String result = rs.getString(columnName);
		logger.info("读取一:"+result);
		return result;
	}

	public String getResult(ResultSet rs, int columnIndex) throws SQLException {
		String result = rs.getString(columnIndex);
		logger.info("读取二:"+result);
		return result;
	}

	public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
		String result = cs.getString(columnIndex);
		logger.info("读取三:"+result);
		return result;
	}

}
