<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table tr th{padding : 10px;}
	table tr td{padding : 5px;}
	#checkSubject, #checkContent {color : red; font-size: 8pt;}
	body form{
	  display: flex;
	  align-items: center;
	  justify-content: flex-start;
	  margin: 50px 0 0 50px;
	}
</style>
</head>
<body>
	<div id="header" style="text-align: center;">
		<h1>
			<img alt="사과" src="/projectMVC/image/apple.png" width="50" height="50"
				onclick="location.href='/projectMVC/index.jsp'" style="cursor:pointer">
			MVC를 활용한 미니 프로젝트
		</h1>
		<hr>
	</div>
	
	<jsp:include page="../main/boardMenu.jsp"></jsp:include>
	
	<div id="section">
		<form name="boardReplyForm" id="boardReplyForm">
			<input type="text" name="pseq" id="pseq" value="${pseq}" >
			<input type="text" name="pg" id="pg" value="${pg}" >
			<table border=1 cellspacing=0>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="subject" id="subject" size=40>
						<div id="checkSubject"></div>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea name="content" id="content" cols="40" rows="8"></textarea>
						<div id="checkContent"></div>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="답글쓰기" id="boardReplyBtn">
						<input type="reset" value="다시작성">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<script src="https://code.jQuery.com/jquery-3.7.1.min.js"></script>
    <script type="text/javascript">
       $('#boardReplyBtn').click(function(){
    	   $('#checkSubject').empty();
    	   $('#checkContent').empty();
    	   if($('#subject').val()==''){
    		   $('#checkSubject').html('제목을 입력해주세요');
    	   }else if($('#content').val()==''){
    		   $('#checkContent').html('내용을 입력해주세요');
    	   }else {
    		   $.ajax({
    			   type: 'post'
    			   , url: '/projectMVC/board/boardReply.do'
    			   , data: $("#boardReplyForm").serialize()//pseq, pg, subject, content
    			   , dataType: 'text'
    			   , success: function(data){
    				   data = data.trim();
 					   alert('게시글 등록에 성공하였습니다.')
    				   location.href='/projectMVC/board/boardList.do?pg='+$('#pg').val();
    			   }
    			   , error: function(e){
    				   console.log(e)
    			   }
    		   })
    	   }
       })
    </script>
</body>
</html>