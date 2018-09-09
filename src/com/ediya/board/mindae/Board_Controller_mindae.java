package com.ediya.board.mindae;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ediya.board.common.dbcp.DBCP;
import com.ediya.board.common.dbcp.DBCPConn;
import com.ediya.board.mindae.util.MyUtil;

public class Board_Controller_mindae extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	protected void forward(HttpServletRequest req, HttpServletResponse resp, String url) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		Connection conn = DBCP.getConnection();
		Board_DAO_mindae b_dao = new Board_DAO_mindae(conn);
		
		MyUtil myUtill = new MyUtil();
		
		String cp = req.getContentType();
		String uri = req.getRequestURI();
		
		String url;
		
		
		//작성
		if(uri.indexOf("m_created.do") != -1) {
			
		/*	HttpSession session = req.getSession();
			
			Board_Custominfo_mindae info = (Board_Custominfo_mindae)session.getAttribute("customInfo");
			
		if(info==null) {
				
				url ="/kim/member/m_login.jsp";
				forward(req, resp, url);
				return;
			}
			*/
		
			url = "/bbs/m_created.jsp";
			System.out.println(url);
			forward(req, resp, url);
			System.out.println(url);
			System.out.println("포워딩?");
		
		} else if (uri.indexOf("m_created_ok.do") != -1) { //글쓰기 버튼 누르면
			
			Board_DTO_mindae bdto = new Board_DTO_mindae();
			
			int maxNum = b_dao.getMaxNum();
			
//			bdto.setBoardNo_kmk(maxNum + 1);
			bdto.setBoardSubject_kmk(req.getParameter("boardSubject_kmk"));
			bdto.setUserId_kmk(req.getParameter("userId_kmk"));
			bdto.setBoardContent_kmk(req.getParameter("boardContent_kmk"));
			bdto.setUserEmail_kmk(req.getParameter("userEmail_kmk"));
			System.out.println(req.getParameter("boardContent_kmk"));
			System.out.println(req.getParameter("userId_kmk"));
			b_dao.insertData(bdto);
			
			url = cp + "/bbs/m_created.do";
			resp.sendRedirect(url);
						
		} else if (uri.indexOf("main.jsp")!= -1){
			
		}
		
		
		
		
		
		
		
	}
	
	
	
	

}
