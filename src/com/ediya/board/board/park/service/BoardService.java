package com.ediya.board.board.park.service;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ediya.board.board.park.dao.TestDAO;
import com.ediya.board.board.park.dto.Board_DTO;
import com.ediya.board.board.park.service.inter.BoardServiceInter;

public class BoardService implements BoardServiceInter{
	TestDAO dao =new TestDAO();
	
	@Override
	public void board_list(HttpServletRequest request, HttpServletResponse response) {
		
		
		String s_select_page=request.getParameter("select_page");
		
			s_select_page="1";
		
		
		int select_page=Integer.parseInt(s_select_page);
		
		
		System.out.println("board_list");
		
		List<Board_DTO> list =dao.select(select_page);
		request.setAttribute("board_list", list);
		 
		System.out.println("list size="+list.size());
		 
		 
		 
	}

	@Override
	public void board_insert(HttpServletRequest request, HttpServletResponse response) {
		String board_subject=request.getParameter("board_subject");
		String board_writer=request.getParameter("board_writer");
		String board_email=request.getParameter("board_email");
		String board_content=request.getParameter("board_content");
		String board_pass=request.getParameter("board_pass");
		Board_DTO dto=new Board_DTO();
		dto.setBoard_subject(board_subject);
		dto.setBoard_writer(board_writer);
		dto.setBoard_email(board_email);
		dto.setBoard_content(board_content);
		dto.setBoard_pass(board_pass);
			
		dao.board_insert(dto);
	
	}

	@Override
	public void board_content(HttpServletRequest request, HttpServletResponse response) {
	int board_num=Integer.parseInt(request.getParameter("board_num"));
	
	
	
	Board_DTO dto=dao.board_content(board_num);
	request.setAttribute("info", dto);
	 
	}

	@Override
	public void board_delete(HttpServletRequest request, HttpServletResponse response) {
		
		
	}

	@Override
	public void board_update_start(HttpServletRequest request, HttpServletResponse response) {
		int board_num=Integer.parseInt(request.getParameter("board_num"));
		String board_subject=request.getParameter("board_subject");
		String board_content=request.getParameter("board_content");
		
		Board_DTO dto=new Board_DTO();
		dto.setBoard_subject(board_subject);
		dto.setBoard_content(board_content);
		dto.setBoard_num(board_num);
		dao.board_update_start(dto);
		
	}

	

	
	
}
