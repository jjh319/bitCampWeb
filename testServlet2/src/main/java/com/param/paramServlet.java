package com.param;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/paramServlet")
public class paramServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//데이터
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		
		// 응답
		res.setContentType("text/html; charSet=utf-8");
		PrintWriter out = res.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<br>");
		out.println("나의 이름은 " + name + " 이고, 나이는 " + age + "살 입니다. <br>");
		
		if(age >= 20) {
			out.println("그래서 <font size='5' color='red'><strong>성인</strong></font>입니다.");
		} else {
			out.println("그래서 <span id='textSpan'>청소년</span> 입니다.");
		}
		out.println("<br>");
//		out.println("<input type='button' value='뒤로' onclick=javascript:location.href='http://localhost:8080/testServlet2/exam/param.html'>");
		out.println("<input type='button' value='뒤로' onclick=javascript:history.go(-1)>");
		
		out.println("</body>");
		out.println("</html>");
	} // doGet

} // end class
