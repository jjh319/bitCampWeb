package board.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardWriteService implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		// 데이터
		
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		// 페이징 처리
		int endNum = pg*5;
		int startNum = endNum - 4;
	
		HttpSession session = request.getSession(); 
		
		String id = (String) session.getAttribute("memId");
		String name = (String) session.getAttribute("memName");
		String email = (String) session.getAttribute("memEmail");
		
		Map<String, String> map = new HashMap<>();
		
		map.put("id", id);
		map.put("name", name);
		map.put("email", email);
		map.put("subject", subject);
		map.put("content", content);
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.boardWrite(map);
		
		
		List<BoardDTO> boardDTO =  boardDAO.boardList(startNum,endNum);
		
		int totalA = boardDAO.getTotalA(); // 총글수
		int totalP = (totalA + 4) / 5; // 총 페이지 수
		
		session.setAttribute("boardDTO", boardDTO);
		session.setAttribute("totalP", totalP);
		session.setAttribute("pg", pg);
		
		return "/board/boardWrite.jsp";
	} // requestPro

} // end class
