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
        
        sql=" insert into BOARD_MEMBER(member_id,member_pass,member_name,member_phon,member_sex,member_address)"
        		+ " values(?,?,?,?,?,?)";
        
     
        
        try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMember_id());
			pstmt.setString(2, dto.getMember_pass());
			pstmt.setString(3, dto.getMember_name());
			pstmt.setString(4, dto.getMember_phon());
			pstmt.setString(5, dto.getMember_sex());
			pstmt.setString(6, dto.getMember_address());
			
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


   
    
  
}
