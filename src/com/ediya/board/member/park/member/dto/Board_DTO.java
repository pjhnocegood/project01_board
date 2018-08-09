package com.ediya.board.member.park.member.dto;

import java.sql.Date;

public class Board_DTO {

int board_num;
String board_subject;
String board_writer;
String board_content;
int board_like;
int board_view;
int board_sub;
Date board_dt;




public int getBoard_like() {
	return board_like;
}
public void setBoard_like(int board_like) {
	this.board_like = board_like;
}
public int getBoard_view() {
	return board_view;
}
public void setBoard_view(int board_view) {
	this.board_view = board_view;
}
public int getBoard_num() {
	return board_num;
}
public void setBoard_num(int board_num) {
	this.board_num = board_num;
}
public String getBoard_subject() {
	return board_subject;
}
public void setBoard_subject(String board_subject) {
	this.board_subject = board_subject;
}
public String getBoard_writer() {
	return board_writer;
}
public void setBoard_writer(String board_writer) {
	this.board_writer = board_writer;
}
public String getBoard_content() {
	return board_content;
}
public void setBoard_content(String board_content) {
	this.board_content = board_content;
}
public int getBoard_sub() {
	return board_sub;
}
public void setBoard_sub(int board_sub) {
	this.board_sub = board_sub;
}
public Date getBoard_dt() {
	return board_dt;
}
public void setBoard_dt(Date board_dt) {
	this.board_dt = board_dt;
}
	
	
	
}
