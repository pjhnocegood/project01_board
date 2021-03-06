package com.ediya.board.common.dbcp;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	
	private static Connection conn = null;

	public static Connection getConnection() {

		String url = "jdbc:mysql:/localhost:3306:board_project";
		String user = "mindae";
		String pwd = "a123";

		if (conn == null) {

			try {

				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url, user, pwd);

			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		return conn;
	}

	public static void close() {

		if (conn == null)
			return;
		try {

			if (!conn.isClosed())
				conn.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		conn = null;
	}

}
