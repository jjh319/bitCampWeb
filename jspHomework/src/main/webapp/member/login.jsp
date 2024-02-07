
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="member.dao.MemberDAO"%>
<%@ page import="member.bean.MemberDTO"%>
<%
    //데이터
    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");
	//String email1 = request.getParameter("email1");
    
    MemberDTO memberDTO = new MemberDTO();
    
    //DB - Select
    MemberDAO memberDAO = MemberDAO.getInstance();
    memberDTO = memberDAO.login(id, pwd);
    String email1 = memberDTO.getEmail1();
    String email2 = memberDTO.getEmail2();
     
    
//    String ic = memberDAO.checkIdPwd(memberDTO);

%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        body {
            color: red;
        }
        input {
            background-color: white;
            color : red;
            border: 1px solid red;
        }
    </style>
</head>
<body>
<% if(memberDTO == null) { 
    // 페이지 이동
    response.sendRedirect("loginFail.jsp");
    
} else{
	// 페이지 이동
   /*  response.sendRedirect("loginOk.jsp?name="+
	URLEncoder.encode(memberDTO.getName(),"utf-8") + "&id=" + id
    		); */
    		
    // 쿠키
    /* Cookie cookie = new Cookie("memName", memberDTO.getName());
    cookie.setMaxAge(30*60); // 3초
    response.addCookie(cookie); // 클라이언트로 보내기
    
 	// 쿠키
    Cookie cookie2 = new Cookie("memId",id);
    cookie2.setMaxAge(30*60); // 3초
    response.addCookie(cookie2); */ // 클라이언트로 보내기
    
    // 세션
    /* HttpSession session = request.getSession(); */
    session.setAttribute("memName", memberDTO.getName());
    session.setAttribute("memId", id);
    session.setAttribute("email1", email1+"@"+email2);
    
    response.sendRedirect("loginOk.jsp");
    
    
} %>
<%--<%if (ic != null) { %>--%>
<%--<%=ic %>님 로그인<br>--%>
<%--<input type="button" id="update" value="회원정보수정" onclick="location.href='updateForm.jsp'">--%>
<%--<%} else { %>--%>
<%--아이디 또는 비밀번호가 일치하지 않습니다. <br>--%>
<%--<%} %>--%>
</body>
</html>
