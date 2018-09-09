package com.ediya.board.mindae;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class Board_DAO_mindae {
	
	private Connection conn = null;
	
	public Board_DAO_mindae(Connection conn) {
		this.conn = conn;
	}

	public int getMaxNum() {
		
		int maxNum = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql = "select nvl(max(num),0) from board_kmk";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next())
				maxNum = rs.getInt(1);
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return maxNum;
	}
	
	public int insetData (Board_DTO_mindae dto) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "insert into board (boardNo_kmk,boardSubject_kmk,"
					+ "boardContent_kmk,userId_kmk,userEmail_kmk,boardDate_kmk,boardCount_kmk)"
					+ "values (?,?,?,?,?,sysdate,0)";		;
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getBoardNo_kmk());
			pstmt.setString(2, dto.getBoardSubject_kmk());
			pstmt.setString(3, dto.getBoardContent_kmk());
			pstmt.setString(4, dto.getUserId_kmk());
			pstmt.setString(5, dto.getUserEmail_kmk());
			
			result = pstmt.executeUpdate();
			
			pstmt.close();					
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
}
