package com.person;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/PersonServlet")
public class PersonServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String name = request.getParameter("nameI");
	      String genderNum = request.getParameter("gender");
	      String gender;
	      
	      response.setContentType("text/html; charSet=utf-8");
			
	      if(genderNum.equals("0")) {
	         gender = "남자";
	      }else {
	         gender = "여자";
	      }
	      String color = request.getParameter("color");
	      String hobby = "취미가 없습니다.";
	      String[] hobbyArr = request.getParameterValues("hobby");
	      if(hobbyArr.length != 0) {
	         hobby = "";
	         for(int i = 0 ; i < hobbyArr.length ; i++) {
	            if(!hobbyArr[i].equals(null)) {
	               hobby += hobbyArr[i]+ " ";
	            } // if
	         } // for
	      } // if
	      
	      String subject = "" ;
	      String[] subjectArr = request.getParameterValues("subject");
	      for(String s : subjectArr) subject += s + " ";
	       String str = "<!DOCTYPE html>"
	            + "<html lang=\"en\">"
	            + "<head>"
	            + "  <meta charset=\"UTF-8\">"
	            + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
	            + "  <title>Document</title>"
	            + "  <style>"
	            + "    *{"
	            + "      color: "
	            + color
	            + "      ;"
	            + "    }"
	            + "    "
	            + "  </style>"
	            + "</head>"
	            + "<body>"
	            + "  <ul>"
	            + "    <li>"
	            + "      이름 : "
	            + name
	            + "    </li>"
	            + "    <li>"
	            + "      성별 : "
	            + gender
	            + "    </li>"
	            + "    <li>"
	            + "      색깔 : "
	            + color
	            + "    </li>"
	            + "    <li>"
	            + "      취미 : "
	            + hobby
	            + "    </li>"
	            + "    <li>\r\n"
	            + "      과목 : "
	            + subject
	            + "    </li>"
	            + "  </ul>"
	            + "</body>"
	            + "</html>";
	      PrintWriter out = response.getWriter();
	      out.println(str);
	         
	         
	   }

	}