package com.gessica.service02.transation;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;

public class MyTransation extends JdbcTransaction implements Transaction {

	public MyTransation(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	public MyTransation(DataSource ds, TransactionIsolationLevel desiredLevel, boolean desiredAutoCommit) {
		super(ds, desiredLevel, desiredAutoCommit);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		return super.getConnection();
	}

	@Override
	public void commit() throws SQLException {
		// TODO Auto-generated method stub
		super.commit();
	}

	@Override
	public void rollback() throws SQLException {
		// TODO Auto-generated method stub
		super.rollback();
	}

	@Override
	public void close() throws SQLException {
		// TODO Auto-generated method stub
		super.close();
	}

	@Override
	protected void setDesiredAutoCommit(boolean desiredAutoCommit) {
		// TODO Auto-generated method stub
		super.setDesiredAutoCommit(desiredAutoCommit);
	}

	@Override
	protected void resetAutoCommit() {
		// TODO Auto-generated method stub
		super.resetAutoCommit();
	}

	@Override
	protected void openConnection() throws SQLException {
		// TODO Auto-generated method stub
		super.openConnection();
	}

	@Override
	public Integer getTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return super.getTimeout();
	}

	
}
