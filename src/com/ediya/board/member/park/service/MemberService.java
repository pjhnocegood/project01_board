package com.ediya.board.member.park.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ediya.board.member.park.dao.MemberDAO;
import com.ediya.board.member.park.dto.MemberDTO;
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
		String member_phon=request.getParameter("member_phon");
		String member_sex=request.getParameter("member_sex");
		String member_address=request.getParameter("member_address");
		
		dto.setMember_id(member_id);
		dto.setMember_pass(member_pass);
		dto.setMember_name(member_name);
		dto.setMember_phon(member_phon);
		dto.setMember_sex(member_sex);
		dto.setMember_address(member_address);
		
		dao.member_insert(dto);
	
	}

}
