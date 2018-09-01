package com.ediya.board.member.park.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.ediya.board.board.park.dto.Board_DTO;
import com.ediya.board.common.dbcp.DBCP;
import com.ediya.board.member.park.dto.MemberDTO;
import com.ediya.board.member.park.dto.SessionDTO;

public class MemberDAO {
	
	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private static MemberDAO instance;
	public MemberDAO() {
	}
	
	public static MemberDAO getInstance() {
		if(instance==null){
			instance=new MemberDAO();
		}
		return instance;
	}
	
	
	public void member_insert(MemberDTO dto) {
    	conn = DBCP.getConnection();
        
        String sql = null;
        
        sql=" insert into member_park(userId_park,userPwd_park,userPost_park,userAddr_park,userTell_park,"
        		+ "userBirth_park,userEmail_park,userSex_park,userDate_park,userAdminNo_park)"
        		+ " values(?,?,?,?,?,?,?,?,now(),3)";
        
     
        
        try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMember_id());
			pstmt.setString(2, dto.getMember_pass());
			pstmt.setString(3, dto.getMember_post());
			pstmt.setString(4, dto.getMember_address());
			pstmt.setString(5, dto.getMember_phon());
			pstmt.setString(6, dto.getMember_birth());
			pstmt.setString(7, dto.getMember_email());
			pstmt.setString(8, dto.getMember_sex());
			
			
			
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

	public SessionDTO login_check(MemberDTO dto) {
		conn = DBCP.getConnection();
        String sql = null;
        
        sql="SELECT * FROM member_park WHERE userId_park=? AND userPwd_park=?";
        SessionDTO sessionDTO= new SessionDTO();
		
        
        
        try {
        	pstmt = conn.prepareStatement(sql);
        	pstmt.setString(1, dto.getMember_id());
        	pstmt.setString(2, dto.getMember_pass());
        	
        	
        	System.out.println(dto.getMember_id());
        	System.out.println(dto.getMember_pass());
        	
			  rs = pstmt.executeQuery();

        	 while (rs.next()) {
                 
        		 sessionDTO.setUserNo_park(rs.getInt("userNo_park"));
        		 sessionDTO.setUserId_park(rs.getString("userId_park"));
        		 sessionDTO.setUserPwd_park(rs.getString("userPwd_park"));
        		 sessionDTO.setUserPost_park(rs.getString("userPost_park"));
        		 sessionDTO.setUserAddr_park(rs.getString("userAddr_park"));
        		 sessionDTO.setUserTell_park(rs.getString("userTell_park"));
        		 sessionDTO.setUserBirth_park(rs.getString("userBirth_park"));
        		 sessionDTO.setUserEmail_park(rs.getString("userEmail_park"));
        		 sessionDTO.setUserSex_park(rs.getString("userSex_park"));
        		 sessionDTO.setUserDate_park(rs.getString("userDate_park"));
        		 sessionDTO.setUserAdminNo_park(rs.getString("userAdminNo_park"));
          		
        		
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
		
		
        return sessionDTO;
        
	}


   
    
  
}
