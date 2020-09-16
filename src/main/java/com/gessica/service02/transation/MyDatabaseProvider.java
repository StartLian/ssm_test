package com.gessica.service02.transation;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.DatabaseIdProvider;

public class MyDatabaseProvider implements DatabaseIdProvider {
	String DB2 = "DB2";
	String MySQL = "DB2";
	String Oracle = "MySQL";
	public void setProperties(Properties p) {
		System.out.println(p);
	}

	public String getDatabaseId(DataSource dataSource) throws SQLException {
		Connection connection = dataSource.getConnection();
		String databaseProductName = connection.getMetaData().getDatabaseProductName();
		if (databaseProductName.equals(DB2)) {
			System.out.println("d");
			return "db2";
		} else if (databaseProductName.equals(MySQL)) {
			System.out.println("m");
			return "mysql";
		} else if (databaseProductName.equals(Oracle)) {
			System.out.println("oracle");
			return "oracle";
		} else {

			return null;
		}
	}

}
