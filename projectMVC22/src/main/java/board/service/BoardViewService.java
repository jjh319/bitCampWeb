package board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardViewService implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		HttpSession session = request.getSession();
		
		String seq = request.getParameter("seq");
	
		BoardDAO baBoardDAO = BoardDAO.getInstance();
		List<BoardDTO> list = baBoardDAO.boardView(seq);
		
		session.setAttribute("list", list);
//		session.setAttribute("seq", seq);
//		session.setAttribute("hit", hit);
		
		return "/board/boardView.jsp";
	} // requestPro

} // end class
