package com.calc;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/CalcServlet")
public class CalcServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.getWriter().append("Served at: ").append(req.getContextPath());
		
		// 데이터
		int x = Integer.parseInt(req.getParameter("x"));
		int y = Integer.parseInt(req.getParameter("y"));
		
		// 응답
		res.setContentType("text/html; charSet=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<br>");
		out.println(x + " + " + y + " = " + (x+y) + "<br>");
		out.println(x + " - " + y + " = " + (x-y) + "<br>");
		out.println(x + " * " + y + " = " + (x*y) + "<br>");
		out.printf(x + " / " + y + " = " + "%.2f", ((double)x/y));
		out.println("</body>");
		out.println("</html>");
		
	} // doGet

} // end class
