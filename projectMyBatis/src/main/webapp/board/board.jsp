<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.lang.reflect.Array"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="board.dao.BoardDAO"%>
<%@ page import="board.bean.BoardDTO"%>

<%

	int pg = Integer.parseInt(request.getParameter("pg"));
	
	// 페이징 처리
	int endNum = pg*5;
	int startNum = endNum - 4;

	BoardDAO boardDAO = BoardDAO.getInstance();
	
	List<BoardDTO> boardDTO =  boardDAO.boardList(startNum, endNum);
	
	int totalA = boardDAO.getTotalA(); // 총글수
	int totalP = (totalA + 4) / 5; // 총 페이지 수
	
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

	#currentPaging {
		color:red;
		
	}
	
	#paging {
		color:black;
	}
	
	span {
		border: 1px solid black;
		padding: 7px;
		margin: 10px 10px;
	}
	
	div {
		margin-top:15px;
	}
	
	a {
		text-decoration:none;
	}
	
	a:hover {
		text-decoration:underline;
	}

</style>

</head>
<body>

	<h2><img src="../image/1.jpg" width="60" height="60" alt="kakao" onclick="location.href='../index.jsp'"></h2>

	<table border="1" cellpadding="7" frame="hsides" rules="rows">
		<thead>
			<tr>
				<th>글번호</th>
				<th>id</th>
				<th>이름</th>
				<th>e-mail</th>
				<th>제목</th>
				<th>내용</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		
		<tbody>
		    <% for(BoardDTO board : boardDTO) { %>
		        <tr>
		        	
		            <th><%for(int i=0; i<board.getLev(); i++) { %>
		            	&emsp;
		            	<%} // for %>
		            <%if(board.getPseq() != 0) {%><img src="../image/reply.gif" alt="reply"> <%} // if %>
		            
		              <%= board.getSeq() %></th>
		              
		            <th><%= board.getId() %> </th>
		            <th><%= board.getName() %> </th>
		            <th><%= board.getEmail() %>  </th>
		            <th><%= board.getSubject() %>  </th>
		            <td><%= board.getContent() %>  </td>
		            <td><%= board.getLogtime() %>  </td>
		            <td><%= board.getHit() %>  </td>
		        </tr>
		    <% } // enhanced for%>
		 </tbody>
		 
		 <table>
		 	<div style="text-align:center; width:700px;">
			 	<%for(int i=1; i<=totalP; i++) { %>
			 		
			 		<%if(pg == i) { %>
			 			<span><a id="currentPaging"  href="board.jsp?pg=<%=i %>"><%=i %></a> </span>
			 		<%} else { %>
			 			<a  id="paging" href="board.jsp?pg=<%=i %>"><%=i %></a>
			 		<%} // if-else %>
				<%} // for %>
		 	
		 	</div>
		 	
		 </table>
		
	</table>
	
	<script src="http://code.jQuery.com/jquery-3.7.1.min.js"></script>
	<script type="text/javascript" src="../js/board.js"></script>

</body>
</html>