package com.ediya.board.mindae;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//
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
			
			sql = "select nvl(max(num),0) from board_kmk ";
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return maxNum;
		
	}
	
	public int insertData(Board_DTO_mindae bdto) {
		System.out.println("³Ñ¾î°«´Ï?");
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "insert into board_kmk (boardSubject_kmk,boardContent_kmk,";
			sql +="userId_kmk,userEmail_kmk,boardDate_kmk) ";
			sql +="values (?,?,?,?,now())";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bdto.getBoardSubject_kmk());
			pstmt.setString(2, bdto.getBoardContent_kmk());
			pstmt.setString(3, bdto.getUserId_kmk());
			pstmt.setString(4, bdto.getUserEmail_kmk());
			
			result = pstmt.executeUpdate();
			System.out.println("result ="+result);
			pstmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	

}
