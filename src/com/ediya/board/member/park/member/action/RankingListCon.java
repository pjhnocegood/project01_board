package com.ediya.board.member.park.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ediya.board.member.park.member.dao.TestDAO;

/**
 * Servlet implementation class RankingListCon
 */
@WebServlet("/RankingListCon.do")
public class RankingListCon extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("서블렛 테스트");
		TestDAO dao =new TestDAO();
		dao.insert();
		
		
		
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
