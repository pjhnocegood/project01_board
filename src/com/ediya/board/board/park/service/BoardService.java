package com.ediya.board.board.park.service;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ediya.board.board.park.dao.TestDAO;
import com.ediya.board.board.park.dto.Board_DTO;
import com.ediya.board.board.park.service.inter.BoardServiceInter;

public class BoardService implements BoardServiceInter{

	@Override
	public void board_list(HttpServletRequest request, HttpServletResponse response) {
		
		
		int select_page=Integer.parseInt(request.getParameter("select_page"));
		
		
		System.out.println("board_list");
		TestDAO dao =new TestDAO();
		List<Board_DTO> list =dao.select(select_page);
		request.setAttribute("board_list", list);
		 
		 
		 
		 
	}

	
	
}
