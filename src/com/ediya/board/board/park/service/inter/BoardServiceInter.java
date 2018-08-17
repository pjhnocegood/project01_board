package com.ediya.board.board.park.service.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BoardServiceInter{
	
	public void board_list(HttpServletRequest request, HttpServletResponse response);

	public void board_insert(HttpServletRequest request, HttpServletResponse response);

	public void board_content(HttpServletRequest request, HttpServletResponse response);

	public void board_delete(HttpServletRequest request, HttpServletResponse response);

	public void board_update_start(HttpServletRequest request, HttpServletResponse response);
	
	
}
