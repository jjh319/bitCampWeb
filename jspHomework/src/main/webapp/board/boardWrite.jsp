<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.dao.MemberDAO"%>
<%@ page import="member.bean.MemberDTO"%>
<%@ page import="board.dao.BoardDAO"%>

<%

	// 데이터
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	
	MemberDTO memberDTO = new MemberDTO();
	
	memberDTO.setSubject(subject);
	memberDTO.setContent(content);
	
	
	BoardDAO boardDAO = BoardDAO.getInstance();
	boardDAO.boardWrite(subject,content);
	
	String id = (String) session.getAttribute("memId");
	String email1 = (String) session.getAttribute("email1");
	
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2><img src="../image/1.jpg" width="60" height="60" alt="kakao" onclick="location.href='../index.jsp'"></h2>

	<table border="1px">
		<thead>
			<tr>
				<th>작성자</th>
				<th>e-mail</th>
				<th>제목</th>
				<th>내용</th>
			</tr>
		</thead>
		
		<tbody>
			<tr>
				<th><%=id %> </th>
				<th><%=email1 %>  </th>
				<th><%=subject %>  </th>
				<td><%=content %>  </td>
			</tr>
		</tbody>
		
		
	</table>

</body>
</html>