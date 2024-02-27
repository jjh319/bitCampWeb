package board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardUpdateService implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq", seq);
		map.put("subject", subject);
		map.put("content", content);
		
		// 데이터
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.boardUpdae(map);
		
		return "/board/update.jsp";
	} // requestPro

} // end class
