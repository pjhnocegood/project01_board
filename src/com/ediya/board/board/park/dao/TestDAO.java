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
        int start_page=(select_page-1)*10;
        int end_page=start_page+10;
        
        System.out.println("start_page="+start_page);
        System.out.println("end_page="+end_page);
        
        sql="select @ROWNUM := @ROWNUM + 1 as rnum, b.*\r\n" + 
        		"from board b, (select @ROWNUM := 0) A\r\n" + 
        		"order by board_num\r\n" + 
        		"limit  "+start_page+", "+end_page+";";
        
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
                 dto.setBoard_dt(rs.getDate("board_dt"));
        		 list.add(dto);
        		 System.out.println("ㅠㅠ");
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

	public void board_insert(Board_DTO dto) {
conn = DBCP.getConnection();
        
        String sql = null;
        
        sql=" insert into BOARD(board_subject,board_writer,board_email,board_content,board_pass,"
        		+ "board_view,board_like,board_dt) values(?,?,?,?,?,0,0,now())";
        
     
        
        try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBoard_subject());
			pstmt.setString(2, dto.getBoard_writer());
			pstmt.setString(3, dto.getBoard_email());
			pstmt.setString(4, dto.getBoard_content());
			pstmt.setString(5, dto.getBoard_pass());
			
			
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

	public Board_DTO board_content(int board_num) {
		conn = DBCP.getConnection();
        String sql = null;
        
        
        sql="SELECT *FROM BOARD WHERE board_num=?";
        
        
        Board_DTO dto = new Board_DTO();
		 
        try {
        	pstmt = conn.prepareStatement(sql);
        	pstmt.setInt(1, board_num);
			  rs = pstmt.executeQuery();

        	 while (rs.next()) {
                 
        		 dto.setBoard_num(rs.getInt("board_num"));
        		 dto.setBoard_subject(rs.getString("board_subject"));
        		 dto.setBoard_writer(rs.getString("board_writer"));
                 dto.setBoard_view(rs.getInt("board_view"));
                 dto.setBoard_content(rs.getString("board_content"));
                 dto.setBoard_email(rs.getString("board_email"));
                 dto.setBoard_like(rs.getInt("board_like"));
                 dto.setBoard_dt(rs.getDate("board_dt"));
        		
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
		return dto;
	}

	public void board_delete(int board_num) {
		conn = DBCP.getConnection();
        String sql = null;
        
        
        sql="DELETE FROM BOARD WHERE board_num=?";
        
        
        Board_DTO dto = new Board_DTO();
		 
        try {
        	pstmt = conn.prepareStatement(sql);
        	pstmt.setInt(1, board_num);
			pstmt.executeUpdate();

        	
        	 
			
			  
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

	public void board_update_start(Board_DTO dto) {
		conn = DBCP.getConnection();
        String sql = null;
        
        
        sql=" UPDATE BOARD SET board_subject=?,board_content=? WHERE board_num=?;";
        
        
        
        try {
        	pstmt = conn.prepareStatement(sql);
        	pstmt.setString(1, dto.getBoard_subject());
        	pstmt.setString(2, dto.getBoard_content());
        	pstmt.setInt(3, dto.getBoard_num());
			
        	pstmt.executeUpdate();

        	
        	 
			
			  
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
