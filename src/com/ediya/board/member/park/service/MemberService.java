package com.ediya.board.member.park.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ediya.board.member.park.dao.MemberDAO;
import com.ediya.board.member.park.dto.MemberDTO;
import com.ediya.board.member.park.dto.SessionDTO;
import com.ediya.board.member.park.service.inter.MemberServiceInter;

public class MemberService implements MemberServiceInter{

	@Override
	public void join_write(HttpServletRequest request, HttpServletResponse response) {
		
		
	}

	@Override
	public void member_insert(HttpServletRequest request, HttpServletResponse response) {
		MemberDTO dto=new MemberDTO();
		MemberDAO dao=new MemberDAO();
		
		String member_id=request.getParameter("member_id");
		String member_pass=request.getParameter("member_pass");
		String member_name=request.getParameter("member_name");
		String member_email=request.getParameter("member_email");
		
		String member_phon=request.getParameter("member_phon");
		String member_sex=request.getParameter("member_sex");
		String member_address=request.getParameter("member_address");
		String member_post=request.getParameter("member_post");
		String member_birth=request.getParameter("member_birth");
		
		
		
		dto.setMember_id(member_id);
		dto.setMember_pass(member_pass);
		dto.setMember_name(member_name);
		dto.setMember_phon(member_phon);
		dto.setMember_sex(member_sex);
		dto.setMember_address(member_address);
		dto.setMember_post(member_post);
		dto.setMember_birth(member_birth);
		dto.setMember_email(member_email);
		
		dao.member_insert(dto);
	
	}

	@Override
	public int login_check(HttpServletRequest request, HttpServletResponse response) {
		int rs=0;
		MemberDTO dto=new MemberDTO();
		MemberDAO dao=new MemberDAO();
		
		String member_id=request.getParameter("member_id");
		String member_pass=request.getParameter("member_pass");
		dto.setMember_id(member_id);
		dto.setMember_pass(member_pass);
		SessionDTO sessionDTO=dao.login_check(dto);
		
		if(sessionDTO.getUserNo_park()==0) {
			System.out.println("0개입니다.");
			rs=0;
		}else {
			System.out.println("1개입니다.");
			HttpSession session = request.getSession();
			session.setAttribute("session", sessionDTO);
			rs=1;
		}
		
		
		
		
		return rs;
	}

}
