<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2><img src="../image/1.jpg" width="60" height="60" alt="kakao" style="cursor:pointer;" onclick="location.href='../index.do'">MVC를 활용한 미니프로젝트</h2>
	
	<div id="container">
		<table border="1" cellpadding="7" frame="hsides" rules="rows">
			<c:forEach var="boardDTO" items="${list }">
				<tr>
					<th>
						<th><h3>제목 : <span id="subjectSpan">${boardDTO.subject }</span></h3>
					</th>
				</tr>
			
				<tr>
					<td align="center" width="200">글번호 : <span id="seqSpan">${boardDTO.seq }</span></td>
					<td align="center" width="200">작성자 : <span id="idSpan">${boardDTO.id }</span></td>
					<td align="center" width="200">조회수 : <span id="hitSpan">${boardDTO.hit }</span></td>
				</tr>
				
				<tr>
					<td height="300" valign="top">
						<span id="contentSpan">${boardDTO.content }</span>
					</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<input type="button" value="목록" 
				onclick="location.href='/projectMVC/board/board.do?pg=1'">
	</div>
	
</body>
</html>