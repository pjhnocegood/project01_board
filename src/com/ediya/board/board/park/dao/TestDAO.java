package com.ediya.board.board.park.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.ediya.board.board.park.dto.Board_DTO;
import com.ediya.board.common.dbcp.DBCP;

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
			  int result = pstmt.executeUpdate();

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
    
    public List<Board_DTO> select(int select_page){
    	conn = DBCP.getConnection();
        
        String sql = null;
        
        sql="select @ROWNUM := @ROWNUM + 1 as rnum, b.*\r\n" + 
        		"from board b, (select @ROWNUM := 0) A\r\n" + 
        		"order by board_num\r\n" + 
        		"limit  "+(select_page*10)+", 10;";
        
        List<Board_DTO> list = new ArrayList<Board_DTO>();
        
        
        try {
        	pstmt = conn.prepareStatement(sql);
			  rs = pstmt.executeQuery();

        	 while (rs.next()) {
                 
        		 Board_DTO dto = new Board_DTO();
        		 dto.setBoard_num(rs.getInt("board_num"));
        		 dto.setBoard_subject(rs.getString("board_subject"));
        		 dto.setBoard_writer(rs.getString("board_writer"));
                 dto.setBoard_view(rs.getInt("board_view"));
        		 dto.setBoard_sub(rs.getInt("board_sub"));
                 dto.setBoard_dt(rs.getDate("board_dt"));
        		 list.add(dto);
               
              }
        	 
			
			  
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
		return list;

    }
    
  
}
