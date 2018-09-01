package com.ediya.board.member.park.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ediya.board.member.park.service.MemberService;
import com.ediya.board.member.park.service.inter.MemberServiceInter;

/**
 * Servlet implementation class RankingListCon
 */
@WebServlet("/member/park/login_check.do")
public class Member_login_check_con extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPre(request,response);
		
	
		 
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPre(request,response);
		
	}
	
	
	protected void doPre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MemberServiceInter loginservice= new MemberService();
		int rs=loginservice.login_check(request,response);
		
		System.out.println("rs="+rs);
		
		
		response.getWriter().write(rs+"");
		
		 
	}
	
}
