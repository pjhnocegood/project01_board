package com.ediya.board.member.park.service.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface MemberServiceInter {

	void join_write(HttpServletRequest request, HttpServletResponse response);

	void member_insert(HttpServletRequest request, HttpServletResponse response);

	int login_check(HttpServletRequest request, HttpServletResponse response);

}
