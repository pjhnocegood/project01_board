package com.ediya.board.member.park.member.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ediya.board.member.park.member.dao.TestDAO;
import com.ediya.board.member.park.member.dto.Board_DTO;

/**
 * Servlet implementation class RankingListCon
 */
@WebServlet("/RankingListCon.do")
public class Board_con extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPre(request,response);
		
	
		 
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPre(request,response);
		
	}
	
	
	protected void doPre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("서블렛 테스트");
		TestDAO dao =new TestDAO();
		
		
		 List<Board_DTO> list =dao.select();
		
		
		
		 request.setAttribute("board_list", list);
		 
		 
		 RequestDispatcher dis = request.getRequestDispatcher("./board_park.jsp");
		dis.forward(request,response);
		 
	}
	
}
