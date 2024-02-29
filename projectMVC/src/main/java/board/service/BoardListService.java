package board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardListService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse reponse) throws Throwable {
		//데이터
		int pg = Integer.parseInt(request.getParameter("pg"));
		System.out.println("pg 값: " + pg);
		//페이징 처리
		
		request.setAttribute("pg", pg);
		return "/board/boardList.jsp";
	}

}
