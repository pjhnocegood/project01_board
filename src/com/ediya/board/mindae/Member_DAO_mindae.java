package com.ediya.board.mindae;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Member_DAO_mindae {
	private Connection conn = null;
	
	public Member_DAO_mindae(Connection conn) {
		this.conn = conn;
	}
	
	public int insertData(Member_DTO_mindae dto){
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "insert into member_kmk (userId_kmk,userPwd_kmk,userName_kmk,"
					+ "userBirth_kmk,userTel_kmk,userAddr_kmk,userEmail_kmk,userDate_kmk) ";
			sql+= "values (?,?,?,?,?,?,?,now())";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getUserId_kmk());
			pstmt.setString(2, dto.getUserPwd_kmk());
			pstmt.setString(3, dto.getUserName_kmk());
			pstmt.setString(4, dto.getUserBirth_kmk());
			pstmt.setString(5, dto.getUserTel_kmk());
			pstmt.setString(6, dto.getUserAddr_kmk());
			pstmt.setString(7, dto.getUserEmail_kmk());
			
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}
	public Member_DTO_mindae getReadData(String userId){
		
		Member_DTO_mindae dto = null;
		PreparedStatement pstmt = null;	
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql = "select userId_kmk,userPwd_kmk,userName_kmk,date_format(userBirth_kmk,'yyyy-mm-dd') as userBirth_kmk,"
					+ "userTel_kmk,userAddr_kmk,userEmail_kmk ";
			sql += "from member_kmk where userId_kmk=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,userId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				dto = new Member_DTO_mindae();
			
				dto.setUserId_kmk(rs.getString("userId_kmk"));
				dto.setUserPwd_kmk(rs.getString("userPwd_kmk"));
				dto.setUserName_kmk(rs.getString("userName_kmk"));
				dto.setUserBirth_kmk(rs.getString("userBirth_kmk"));
				dto.setUserTel_kmk(rs.getString("userTel_kmk"));
				dto.setUserAddr_kmk(rs.getString("userAddr_kmk"));
				dto.setUserEmail_kmk(rs.getString("userEmail_kmk"));
							
			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return dto;
	}
	
	

}
