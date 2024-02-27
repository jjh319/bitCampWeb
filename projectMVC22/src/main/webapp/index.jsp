<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/menu.css" />
<link rel="stylesheet" href="./css/index.css" />

</head>
<body>

<div id="wrap">
    <div id="header">
    	<h1>
	    	<img alt="1" src="image/1.jpg" onclick="location.href='./index.do'">
	    	MVC를 활용한 미니프로젝트
    	</h1>
    	<ul class="mainnav">
    		<c:if test="${sessionScope.id == null}">
				<li><a href="board/board.do?pg=1">목록</a></li>
			</c:if>
			<c:if test="${sessionScope.id != null }">
				<li><a href="./board/boardWriteForm.do?pg=1">글쓰기</a></li>
				<li><a href="board/board.do?pg=1">목록</a></li>
			</c:if>
		</ul>
    </div>
    <div id="container">
        <div id="nav">
        	<c:if test="${sessionScope.id == null}">
	        	<input type="button" value="로그인" onclick="location.href='member/loginForm.do'"><br><br>
				<input type="button" value="회원가입" onclick="location.href='member/writeForm.do'"><br><br>
			</c:if>
			
			<c:if test="${sessionScope.id != null }">
				<strong>${id}님 로그인</strong><br>
				<input type="button" value="회원정보수정" onclick="location.href='member/updateForm.do'" ><br><br>
				<input type="button" value="로그아웃" onclick="location.href='member/logout.do'" ><br><br>
			</c:if>
        </div>
        <div id="section">
        	<h3>
        		저희 홈페이지를 방문해주셔서 감사합니다.<br><br>
        		Have a nice day!!<br><br>
        		<img alt="" src="image/망상토끼.gif">
        	</h3>
        </div>
    </div>
    <div id="footer">
    	<h4>지훈캠프</h4>
    </div>

</div>


</body>
</html>