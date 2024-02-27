package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardUpdateFormService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		 // 데이터
		HttpSession session = request.getSession();
        int seq = Integer.parseInt(request.getParameter("seq"));
        int pg = Integer.parseInt(request.getParameter("pg"));
        
        // DB
        BoardDAO boardDAO = BoardDAO.getInstance();
        BoardDTO boardDTO = boardDAO.getBoard(seq);
        
        request.setAttribute("boardDTO", boardDTO);
        request.setAttribute("pg", pg);
        return "/board/boardUpdateForm.jsp";
	}

}
