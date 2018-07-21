package com.ediya.board.member.park.member.action;

import com.ediya.board.member.park.member.dao.TestDAO;

public class Member_controller {

	public static void main(String[] args) {
		TestDAO dao =new TestDAO();
		dao.insert();
	}
}
