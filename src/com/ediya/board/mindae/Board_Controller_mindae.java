package com.ediya.board.mindae;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ediya.board.common.dbcp.DBCP;
import com.ediya.board.mindae.util.MyUtil;

public class Board_Controller_mindae extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void forward(HttpServletRequest req, HttpServletResponse resp, String url)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		Connection conn = DBCP.getConnection();
		Board_DAO_mindae b_dao = new Board_DAO_mindae(conn);
		Member_DAO_mindae m_dao = new Member_DAO_mindae(conn);

		MyUtil myUtil = new MyUtil();

		String cp = req.getContentType();
		String uri = req.getRequestURI();

		String url;

		// 작성
		if (uri.indexOf("m_created.do") != -1) {

			String pageNum = req.getParameter("pageNum");

			HttpSession session = req.getSession();

			CustomInfo_mindae info = (CustomInfo_mindae) session.getAttribute("customInfo");

			if (info == null) {

				url = "/bbs/m_login.do?pageNum=" + pageNum;
				forward(req, resp, url);
				return;
			}

			req.setAttribute("pageNum", pageNum);
			url = "/bbs/m_created.jsp";
			forward(req, resp, url);

		} else if (uri.indexOf("m_created_ok.do") != -1) { // 글쓰기 버튼 누르면

			String pageNum = req.getParameter("pageNum");

			Board_DTO_mindae bdto = new Board_DTO_mindae();

			int maxNum = b_dao.getMaxNum();

			// bdto.setBoardNo_kmk(maxNum + 1);
			bdto.setBoardSubject_kmk(req.getParameter("boardSubject_kmk"));
			bdto.setUserId_kmk(req.getParameter("userId_kmk"));
			bdto.setBoardContent_kmk(req.getParameter("boardContent_kmk"));
			bdto.setUserEmail_kmk(req.getParameter("userEmail_kmk"));
			System.out.println(req.getParameter("boardContent_kmk"));
			System.out.println(req.getParameter("userId_kmk"));
			b_dao.insertData(bdto);

			req.setAttribute("pageNum", pageNum);

			url = cp + "/bbs/m_list.do";
			resp.sendRedirect(url);

			// 리스트
		} else if (uri.indexOf("m_list.do") != -1) {

			String pageNum = req.getParameter("pageNum");

			HttpSession session = req.getSession();

			CustomInfo_mindae info = (CustomInfo_mindae) session.getAttribute("customInfo");

			int currentPage = 1;

			if (pageNum != null)
				currentPage = Integer.parseInt(pageNum);

			// 전체 데이터 갯수
			int dataCount = b_dao.getDataCount();

			// 전체 페이지수
			int numPerPage = 5;
			int totalPage = myUtil.getPageCount(numPerPage, dataCount);

			// 삭제로인해서 페이수변화
			if (currentPage > totalPage)
				currentPage = totalPage;

			int start = (currentPage - 1) * numPerPage + 1;
			int end = currentPage * numPerPage;

			// 데이터 가져오기
			List<Board_DTO_mindae> lists = b_dao.getLists(start, end);

			int listNum, n = 0;
			ListIterator<Board_DTO_mindae> it = lists.listIterator();
			while (it.hasNext()) {

				Board_DTO_mindae data = (Board_DTO_mindae) it.next();
				listNum = dataCount - (start + n - 1);
				data.setListNum(listNum);

				n++;

			}

			// 페이징 처리

			String listUrl = cp + "/bbs/m_list.do";

			String pageIndexList = myUtil.pageIndexList(currentPage, totalPage, listUrl);

			// 글보기 주소
			String articleUrl = cp + "/bbs/m_article.do?pageNum=" + currentPage;
			String loginUrl = cp + "/bbs/m_login.do?pageNum=" + currentPage;
			String logoutUrl = cp + "/bbs/m_logout.do?pageNum=" + currentPage;
			String createdUrl = cp + "/bbs/m_created.do?pageNum=" + currentPage;

			// 포워딩 페이지에 데이터 넘김
			req.setAttribute("lists", lists);
			req.setAttribute("pageIndexList", pageIndexList);
			req.setAttribute("dataCount", dataCount);
			req.setAttribute("articleUrl", articleUrl);
			req.setAttribute("loginUrl", loginUrl);
			req.setAttribute("logoutUrl", logoutUrl);
			req.setAttribute("createdUrl", createdUrl);

			url = "/bbs/m_list.jsp";
			forward(req, resp, url);

		}
		// 게시물
		else if (uri.indexOf("m_article.do") != -1) {

			int num = Integer.parseInt(req.getParameter("boardNo_kmk"));

			HttpSession session = req.getSession();

			CustomInfo_mindae info = (CustomInfo_mindae) session.getAttribute("customInfo");

			// int num =1;

			String pageNum = req.getParameter("pageNum");
			if (pageNum == null) {
				pageNum = "1";
			}

			b_dao.updateHitCount(num);

			Board_DTO_mindae dto = b_dao.getReadData(num);

			if (dto == null) {

				url = cp + "/bbs/m_list.do";
				resp.sendRedirect(url);
			}

			dto.setBoardContent_kmk(dto.getBoardContent_kmk().replaceAll("\n", "<br/>"));

			req.setAttribute("b_dto", dto);
			req.setAttribute("pageNum", pageNum);

			url = "/bbs/m_article.jsp";
			forward(req, resp, url);
		}
		// 수정
		else if (uri.indexOf("updated.do") != -1) {

			int num = Integer.parseInt(req.getParameter("num"));
			String pageNum = req.getParameter("pageNum");

			HttpSession session = req.getSession();

			CustomInfo_mindae info = (CustomInfo_mindae) session.getAttribute("customInfo");

			Board_DTO_mindae dto = b_dao.getReadData(num);

			if (dto == null) {
				url = cp + "/bbs/list.do?pageNum=" + pageNum;
				resp.sendRedirect(url);
			}

			req.setAttribute("b_dto", dto);
			req.setAttribute("pageNum", pageNum);

			url = "/bbs/m_updated.jsp?pageNum=" + pageNum;
			forward(req, resp, url);

		} else if (uri.indexOf("updated_ok.do") != -1) {

			String pageNum = req.getParameter("pageNum");

			Board_DTO_mindae dto = new Board_DTO_mindae();

			dto.setBoardNo_kmk(Integer.parseInt(req.getParameter("boardNo_kmk")));
			dto.setBoardSubject_kmk(req.getParameter("boardSubject_kmk"));
			dto.setUserId_kmk(req.getParameter("userId_kmk"));
			dto.setUserEmail_kmk(req.getParameter("userEmail_kmk"));
			dto.setBoardContent_kmk(req.getParameter("content"));

			b_dao.updateData(dto);

			req.setAttribute("pageNum", pageNum);

			url = cp + "/bbs/m_list.do?pageNum=" + pageNum;
			resp.sendRedirect(url);

			// 삭제
		} else if (uri.indexOf("deleted_ok.do") != -1) {

			int num = Integer.parseInt(req.getParameter("num"));
			String pageNum = req.getParameter("pageNum");

			int result = b_dao.deletedData(num);

			req.setAttribute("pageNum", pageNum);

			url = cp + "/bbs/m_list.do?pageNum=" + pageNum;
			resp.sendRedirect(url);

		} else if (uri.indexOf("m_join.do") != -1) {

			String pageNum = req.getParameter("pageNum");

			req.setAttribute("pageNum", pageNum);
			url = "/bbs/m_join.jsp";
			forward(req, resp, url);

		} else if (uri.indexOf("m_join_ok.do") != -1) {

			String pageNum = req.getParameter("pageNum");

			Member_DTO_mindae dto = new Member_DTO_mindae();

			dto.setUserId_kmk(req.getParameter("userId_kmk"));
			dto.setUserPwd_kmk(req.getParameter("userPwd_kmk"));
			dto.setUserName_kmk(req.getParameter("userName_kmk"));
			dto.setUserBirth_kmk(req.getParameter("userBirth_kmk"));
			dto.setUserTel_kmk(req.getParameter("userTel_kmk"));
			dto.setUserAddr_kmk(req.getParameter("userAddr_kmk"));
			dto.setUserEmail_kmk(req.getParameter("userEmail_kmk"));

			m_dao.insertData(dto);

			// url = cp + "/index.jsp"; web.xml제일윗부분참고
			req.setAttribute("pageNum", pageNum);

			url = cp + "/bbs/m_login.do?pageNum=" + pageNum;
			resp.sendRedirect(url);

		} else if (uri.indexOf("login.do") != -1) {

			String pageNum = req.getParameter("pageNum");

			req.setAttribute("pageNum", pageNum);
			url = "/bbs/m_login.jsp";
			forward(req, resp, url);

			// login_ok
		} else if (uri.indexOf("login_ok.do") != -1) {

			String userId = req.getParameter("userId_kmk");
			String userPwd = req.getParameter("userPwd_kmk");
			String pageNum = req.getParameter("pageNum");

			System.out.println(userPwd);

			Member_DTO_mindae dto = m_dao.getReadData(userId);

			if (dto == null || (!dto.getUserPwd_kmk().equals(userPwd))) {

				req.setAttribute("message", "아이디 또는 패스워드를 정확히 입력하세요!");
				req.setAttribute("message2", "비밀번호 찾기");
				url = cp + "/bbs/login.do?pageNum=" + pageNum;
				forward(req, resp, url);
				return;

			} else if ((dto.getUserId_kmk().equals(userId)) && (dto.getUserPwd_kmk().equals(userPwd))) {

				// HttpSession session = req.getSession();//기본세션영역호출

				// 임의의세션을 여러개 만드는법
				HttpSession session = req.getSession(true);

				/*
				 * HttpSession session2 = req.getSession(true); HttpSession session3 =
				 * req.getSession(true);
				 */

				// 세션에 올리기
				CustomInfo_mindae info = new CustomInfo_mindae();

				info.setUserId_kmk(dto.getUserId_kmk());
				info.setUserEmail_kmk(dto.getUserEmail_kmk());

				System.out.println(info.getUserEmail_kmk() + "   이메일");

				session.setAttribute("customInfo", info);

				req.setAttribute("pageNum", pageNum);
				url = cp + "/bbs/m_list.do?pageNum=" + pageNum;
				resp.sendRedirect(url);
			}

			// 로그아웃
		} else if (uri.indexOf("logout.do") != -1) {

			String pageNum = req.getParameter("pageNum");
			HttpSession session = req.getSession();

			session.removeAttribute("customInfo");
			session.invalidate();

			url = cp + "/bbs/m_list.do?pageNum=" + pageNum;

			req.setAttribute("pageNum", pageNum);
			resp.sendRedirect(url);
		}

	}

}
