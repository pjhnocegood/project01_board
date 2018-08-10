package com.ediya.board.common.dbcp;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class DBCP {
	public static Connection getConnection() {
		Connection connection =null;
		try {
			Context context = new InitialContext();
		    DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
		    connection = dataSource.getConnection();     
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
}
