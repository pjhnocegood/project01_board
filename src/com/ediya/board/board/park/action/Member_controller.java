package com.ediya.board.board.park.action;

import com.ediya.board.board.park.dao.TestDAO;

public class Member_controller {

	public static void main(String[] args) {
		TestDAO dao =new TestDAO();
		dao.insert();
	}
}
