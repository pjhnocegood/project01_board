package com.ediya.board.member.park.member.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
public class RankingListCon extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서블렛 테스트");
		TestDAO dao =new TestDAO();
		
		
		dao.insert();
		 List<Board_DTO> list =dao.select();
		
		 for (int i = 0; i < list.size(); i++) {
			 Board_DTO dto=new Board_DTO();
			 dto=list.get(i);
			 System.out.println(dto.getRf_name());
			 
				
		}
		 
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
