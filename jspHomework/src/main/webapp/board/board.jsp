<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="board.dao.BoardDAO"%>
<%@ page import="board.bean.BoardDTO"%>

<%

	
	BoardDAO boardDAO = BoardDAO.getInstance();
	
	ArrayList<BoardDTO> boardDTO =  boardDAO.loadContents();
	
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2><img src="../image/1.jpg" width="60" height="60" alt="kakao" onclick="location.href='../index.jsp'"></h2>

	<table border="1" cellpadding="7">
		<thead>
			<tr>
				<th>글번호</th>
				<th>id</th>
				<th>이름</th>
				<th>e-mail</th>
				<th>제목</th>
				<th>내용</th>
				<th>날짜</th>
			</tr>
		</thead>
		
		<tbody>
		    <% for(BoardDTO board : boardDTO) { %>
		        <tr>
		            <th><%= board.getSeq() %>  </th>
		            <th><%= board.getId() %> </th>
		            <th><%= board.getName() %> </th>
		            <th><%= board.getEmail() %>  </th>
		            <th><%= board.getSubject() %>  </th>
		            <td><%= board.getContent() %>  </td>
		            <td><%= board.getLogtime() %>  </td>
		        </tr>
		    <% } %>
		 </tbody>
		
	</table>

</body>
</html>