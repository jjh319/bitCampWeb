package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardUpdateFormService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse reponse) throws Throwable {
		
		//데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		System.out.println("1111");
		//DB
		//BoardDAO boardDAO = BoardDAO.getInstance();
		//BoardDTO boardDTO = boardDAO.getBoard(seq);
		//request.setAttribute("boardDTO", boardDTO);
		
		//DB
		request.setAttribute("seq", seq);
		request.setAttribute("pg", pg);
		
		return "/board/boardUpdateForm.jsp";
	}
}