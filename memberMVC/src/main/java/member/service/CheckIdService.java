package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import member.dao.MemberDAO;

public class CheckIdService implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String id = request.getParameter("id");
		
		//DB
		MemberDAO memberDAO = MemberDAO.getInstance(); //생성
		boolean exist = memberDAO.isExistId(id); //호출
		
		
		return "/member/checkId2.jsp";
	} // requestPro

} // end class
