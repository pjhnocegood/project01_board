package com.ediya.board.member.park.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.ediya.board.member.common.DBCP;

public class TestDAO {
	
	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private static TestDAO instance;
	public TestDAO() {
	}
	
	public static TestDAO getInstance() {
		if(instance==null){
			instance=new TestDAO();
		}
		return instance;
	}
	
	
    public void insert(){
    	conn = DBCP.getConnection();
        
        String sql = null;
        
        sql=" insert into ajax_rf(rf_name,rf_content,board_num) values('1','1',1)";
        
        try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				
			}
		}

    }
    
  
}
