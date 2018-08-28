package com.ediya.board.member.park.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ediya.board.member.park.service.MemberService;
import com.ediya.board.member.park.service.inter.MemberServiceInter;

/**
 * Servlet implementation class RankingListCon
 */
@WebServlet("/member/park/insert.do")
public class Member_insert_con extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPre(request,response);
		
	
		 
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPre(request,response);
		
	}
	
	
	protected void doPre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MemberServiceInter memberservice= new MemberService();
		memberservice.member_insert(request,response);
		
		System.out.println("회원가입 성공");
		/*RequestDispatcher dis = request.getRequestDispatcher("./member/park/login.jsp");
		dis.forward(request,response);
		 */
	}
	
}
