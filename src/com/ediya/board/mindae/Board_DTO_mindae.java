package com.ediya.board.mindae;//

public class Board_DTO_mindae {
	
	private int boardNo_kmk; //게시판번호
	private String boardSubject_kmk; //글제목
	private String boardContent_kmk; //글내용
	private String userId_kmk; //아이디
	private String userEmail_kmk; //이메일
	private String boardDate_kmk; //작성일
	private int boardCount_kmk; //조회수
	private int listNum;
	
	public int getBoardNo_kmk() {
		return boardNo_kmk;
	}
	public void setBoardNo_kmk(int boardNo_kmk) {
		this.boardNo_kmk = boardNo_kmk;
	}
	public String getBoardSubject_kmk() {
		return boardSubject_kmk;
	}
	public void setBoardSubject_kmk(String boardSubject_kmk) {
		this.boardSubject_kmk = boardSubject_kmk;
	}
	public String getBoardContent_kmk() {
		return boardContent_kmk;
	}
	public void setBoardContent_kmk(String boardContent_kmk) {
		this.boardContent_kmk = boardContent_kmk;
	}
	public String getUserId_kmk() {
		return userId_kmk;
	}
	public void setUserId_kmk(String userId_kmk) {
		this.userId_kmk = userId_kmk;
	}
	public String getUserEmail_kmk() {
		return userEmail_kmk;
	}
	public void setUserEmail_kmk(String userEmail_kmk) {
		this.userEmail_kmk = userEmail_kmk;
	}
	public String getBoardDate_kmk() {
		return boardDate_kmk;
	}
	public void setBoardDate_kmk(String boardDate_kmk) {
		this.boardDate_kmk = boardDate_kmk;
	}
	public int getBoardCount_kmk() {
		return boardCount_kmk;
	}
	public void setBoardCount_kmk(int boardCount_kmk) {
		this.boardCount_kmk = boardCount_kmk;
	}
	public int getListNum() {
		return listNum;
	}
	public void setListNum(int listNum) {
		this.listNum = listNum;
	}
	
	

}
