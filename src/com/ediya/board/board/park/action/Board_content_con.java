package com.ediya.board.board.park.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ediya.board.board.park.dao.BoardDAO;
import com.ediya.board.board.park.dto.Board_DTO;
import com.ediya.board.board.park.service.BoardService;
import com.ediya.board.board.park.service.inter.BoardServiceInter;

/**
 * Servlet implementation class RankingListCon
 */
@WebServlet("/board_content_park.do")
public class Board_content_con extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPre(request,response);
	
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPre(request,response);
		
	}
	
	
	protected void doPre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardServiceInter boardservice= new BoardService();
		boardservice.board_content(request,response);
		RequestDispatcher dis = request.getRequestDispatcher("./board/park/board_content_park.jsp");
		dis.forward(request,response);
		
		 
	}
	
}
