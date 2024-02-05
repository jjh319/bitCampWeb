<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="member.dao.MemberDAO"%>
<%@ page import="member.bean.MemberDTO"%>
<%
    //데이터
    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");

    MemberDTO memberDTO = new MemberDTO();
    //DB - Select
    MemberDAO memberDAO = MemberDAO.getInstance();
    memberDTO = memberDAO.login(id, pwd);
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
<% if(memberDTO == null) { %>
    아이디 또는 비밀번호가 틀렸습니다.
<%} else{%>
    <%= memberDTO.getName() %>님 로그인<br>
<input type="button" id="update" value="회원정보수정" onclick="location.href='updateForm.jsp'">
<%} %>
<%--<%if (ic != null) { %>--%>
<%--<%=ic %>님 로그인<br>--%>
<%--<input type="button" id="update" value="회원정보수정" onclick="location.href='updateForm.jsp'">--%>
<%--<%} else { %>--%>
<%--아이디 또는 비밀번호가 일치하지 않습니다. <br>--%>
<%--<%} %>--%>
</body>
</html>
