package com.gessica.service02.factory;

import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;

import com.gessica.service02.transation.MyTransation;

public class MyTransactionFactory implements TransactionFactory{

	public void setProperties(Properties props) {
		// TODO Auto-generated method stub
		
	}

	public Transaction newTransaction(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
		// TODO Auto-generated method stub
		return new MyTransation(dataSource,level,autoCommit);
	}

}
