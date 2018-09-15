package com.ediya.board.mindae;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
		//System.out.println("넘어갓니?");
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "insert into board_kmk (boardSubject_kmk,boardContent_kmk,";
			sql +="userId_kmk,userEmail_kmk,boardDate_kmk,boardCount_kmk) ";
			sql +="values (?,?,?,?,now(),0)";
			
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
	
	public List<Board_DTO_mindae> getLists(int start, int end){
		
		List<Board_DTO_mindae> lists = new ArrayList<Board_DTO_mindae>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			
			/*sql = "select * from(";
			sql += "select rownum rnum,data.* from(";
			sql += "select boardNo_kmk,boardSubject_kmk,baordCount,";
			sql += "to_char(boardDate_kmk,'yyyy/mm/dd') boardDate_kmk";
			sql += "from board_kmk where" + searchKey + "like ? ";
			sql += "order by num desc) data) ";
			sql += "where rnum>=? and rnum<=?";*/
			
//			sql = "select @rnum:=@rnum+1 as rownum, data.* from(";
//			sql +="select boardNo_kmk,boardSubject_kmk,boardCount_kmk,";
//			sql += "DATE_FORMAT(boardDate_kmk,'%Y-%m-%d') as boardDate_kmk";
//			sql += "from board_kmk ";
//			sql += "order by boardNo_kmk LIMIT ?,?) data,(select @rnum=0)R ";
			
			sql = " select boardNo_kmk,boardSubject_kmk,boardCount_kmk,"
					+ "DATE_FORMAT(boardDate_kmk,'%Y/%m/%d') as boardDate_kmk,userId_kmk "
					+ "from board_kmk order by boardNo_kmk desc limit ?,?";
			
			
			pstmt =  conn.prepareStatement(sql);
			
			pstmt.setInt(1, start-1);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery()
					;
			while (rs.next()) {
				
				Board_DTO_mindae dto = new Board_DTO_mindae();
				
				dto.setBoardNo_kmk(rs.getInt("boardNo_kmk"));
				dto.setBoardSubject_kmk(rs.getString("boardSubject_kmk"));
/*				dto.setBoardContent_kmk(rs.getString("boardContent_kmk"));*/
				dto.setUserId_kmk(rs.getString("userId_kmk"));
				//dto.setUserEmail_kmk(rs.getString("userEmail_kmk"));
				dto.setBoardCount_kmk(rs.getInt("boardCount_kmk"));
				dto.setBoardDate_kmk(rs.getString("boardDate_kmk"));
				
				lists.add(dto);
				
			}
			
			rs.close();
			pstmt.close();
						
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return lists;
		
	}
	// 전체 데이터의 갯수
		public int getDataCount() {

			int dataCount = 0;

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql;

			try {

				sql = "select IFNULL(count(*),0) from board_kmk ";

				pstmt = conn.prepareStatement(sql);

				rs = pstmt.executeQuery();

				if (rs.next())
					dataCount = rs.getInt(1);

				rs.close();
				pstmt.close();

			} catch (Exception e) {
				System.out.println(e.toString());
			}
			return dataCount;
		}
		
		public Board_DTO_mindae getReadData(int num) {

			Board_DTO_mindae dto = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql;

			try {

				sql = "select boardNo_kmk,boardSubject_kmk,userId_kmk,userEmail_kmk,boardContent_kmk,";
				sql += "boardCount_kmk,boardDate_kmk from board_kmk where boardNo_kmk=?";

				pstmt = conn.prepareStatement(sql);

				pstmt.setInt(1, num);

				rs = pstmt.executeQuery();

				if (rs.next()) {

					dto = new Board_DTO_mindae();
					
					dto.setBoardNo_kmk(rs.getInt("boardNo_kmk"));
					dto.setBoardSubject_kmk(rs.getString("boardSubject_kmk"));
					dto.setBoardContent_kmk(rs.getString("boardContent_kmk"));
					dto.setUserId_kmk(rs.getString("userId_kmk"));
					dto.setUserEmail_kmk(rs.getString("userEmail_kmk"));
					dto.setBoardCount_kmk(rs.getInt("boardCount_kmk"));
					dto.setBoardDate_kmk(rs.getString("boardDate_kmk"));

				}

				rs.close();
				pstmt.close();

			} catch (Exception e) {
				System.out.println(e.toString());
			}
			return dto;
		}
		
		// 조회수 증가
		public int updateHitCount(int num) {

			int result = 0;
			PreparedStatement pstmt = null;
			String sql;

			try {

				sql = "update board_kmk set boardCount_kmk=boardCount_kmk +1 where boardNo_kmk = ?";

				pstmt = conn.prepareStatement(sql);

				pstmt.setInt(1, num);

				result = pstmt.executeUpdate();

				pstmt.close();

			} catch (Exception e) {
				System.out.println(e.toString());
			}
			return result;
		}
		public int updateData(Board_DTO_mindae dto) {

			int result = 0;
			PreparedStatement pstmt = null;
			String sql;

			try {

				sql = "update board_kmk set boardSubject_kmk=?,userId_kmk=?,userEmail_kmk=?,boardContent_kmk=? where boardNo_kmk=?";

				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, dto.getBoardSubject_kmk());
				pstmt.setString(2, dto.getUserId_kmk());
				pstmt.setString(3, dto.getUserEmail_kmk());
				pstmt.setString(4, dto.getBoardContent_kmk());
				pstmt.setInt(5, dto.getBoardNo_kmk());

				result = pstmt.executeUpdate();

				pstmt.close();

			} catch (Exception e) {
				System.out.println(e.toString());
			}
			return result;
		}

		// 삭제
		public int deletedData(int num) {

			int result = 0;
			PreparedStatement pstmt = null;
			String sql;

			try {

				sql = "delete from board_kmk where boardNo_kmk=?";

				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, num);
				result = pstmt.executeUpdate();

				pstmt.close();

			} catch (Exception e) {
				System.out.println(e.toString());
			}
			return result;
		}
		
		
		
		

		
	
	
	

}
