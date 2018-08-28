package com.ediya.board.board.park.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import com.ediya.board.board.park.dao.BoardDAO;
import com.ediya.board.board.park.dto.Board_DTO;
import com.ediya.board.board.park.service.inter.BoardServiceInter;
import com.google.gson.JsonArray;



public class BoardService implements BoardServiceInter{
	BoardDAO dao =new BoardDAO();
	
	@Override
	public void board_list(HttpServletRequest request, HttpServletResponse response) {
		
		
		String s_select_page=request.getParameter("select_page");
		
		
		if(s_select_page==null) {
			
			s_select_page="1";
		}
		
		
		int select_page=Integer.parseInt(s_select_page);
		
		
		
		int total_num=dao.board_total_num();
		total_num=(total_num/10)+1;
		if(select_page>total_num) {
			select_page=total_num;
		}
		if(select_page<1) {
			select_page=1;
		}
		
		List<Board_DTO> list =dao.select(select_page);
		
		int start_page=0;
		int end_page=0;
		start_page=select_page-4;
		end_page=select_page+5;
		
		if(start_page<1) {
			start_page=select_page;
		}
		if(end_page>total_num) {
			end_page=total_num;
		}
		
		
		request.setAttribute("board_list", list);
		request.setAttribute("start_page", start_page);
		request.setAttribute("end_page", end_page);
		request.setAttribute("select_page", select_page);
		
		System.out.println("start_page="+start_page);
		System.out.println("end_page="+end_page);
		 
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
		int board_num=Integer.parseInt(request.getParameter("board_num"));
		
		
		
		dao.board_delete(board_num);
		
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

	@Override
	public void board_rf_insert(HttpServletRequest request, HttpServletResponse response) {
		
		int board_num=Integer.parseInt(request.getParameter("board_num"));
		
		
		
		
		String rf_content=request.getParameter("rf_content");
		System.out.println("rf_content="+rf_content);
		System.out.println("board_num="+board_num);
		
		
		Board_DTO dto=new Board_DTO();
		dto.setRf_content(rf_content);
		dto.setRf_writer("작성자");
		dto.setRf_pass("비밀번호");
		dto.setBoard_num(board_num);
		dao.board_rf_insert(dto);
		
	}

	@Override
	public void board_rf_list(HttpServletRequest request, HttpServletResponse response) {
		int board_num=Integer.parseInt(request.getParameter("board_num"));
		List<Board_DTO> list=dao.board_rf_list(board_num);
		JSONObject json_list = new JSONObject();
		JSONArray json_array=new JSONArray();;
		
		for (int i = 0; i < list.size(); i++) {
			
			JSONObject json_obj = new JSONObject();
			Board_DTO dto=list.get(i);
			
			json_obj.put("rf_num", dto.getRf_num());
			json_obj.put("rf_content", dto.getRf_content());
			json_obj.put("rf_writer", dto.getRf_writer());
			json_obj.put("rf_pass", dto.getRf_pass());
			json_obj.put("rf_dt", dto.getRf_dt());
			
			json_array.add(json_obj);
			
		}
		
		json_list.put("list", json_array);
		try {
			response.getWriter().write(json_list.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	

	
	
}
