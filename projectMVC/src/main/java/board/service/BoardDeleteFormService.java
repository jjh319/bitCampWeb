package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.control.CommandProcess;

public class BoardDeleteFormService implements CommandProcess {
    
	@Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        
		return "/board/boardDeleteForm.jsp";
    }
}
