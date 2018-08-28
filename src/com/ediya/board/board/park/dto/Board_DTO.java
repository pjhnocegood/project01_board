package com.ediya.board.board.park.dto;

import java.sql.Date;

public class Board_DTO {

int board_num;
String board_subject;
String board_writer;
String board_email;
String board_pass;
String board_content;
int board_like;
int board_view;
int board_sub;
Date board_dt;

String rf_content;
String rf_writer;
String rf_pass;
String rf_dt;
int rf_num;





public int getRf_num() {
	return rf_num;
}
public void setRf_num(int rf_num) {
	this.rf_num = rf_num;
}
public String getRf_writer() {
	return rf_writer;
}
public void setRf_writer(String rf_writer) {
	this.rf_writer = rf_writer;
}
public String getRf_pass() {
	return rf_pass;
}
public void setRf_pass(String rf_pass) {
	this.rf_pass = rf_pass;
}
public String getRf_dt() {
	return rf_dt;
}
public void setRf_dt(String rf_dt) {
	this.rf_dt = rf_dt;
}
public String getRf_content() {
	return rf_content;
}
public void setRf_content(String rf_content) {
	this.rf_content = rf_content;
}
public String getBoard_email() {
	return board_email;
}
public void setBoard_email(String board_email) {
	this.board_email = board_email;
}
public String getBoard_pass() {
	return board_pass;
}
public void setBoard_pass(String board_pass) {
	this.board_pass = board_pass;
}
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
