<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style type="text/css">
table {
	border-collapse: collapse;
}

#boardForm  div {
	color: red;
	font-size: 8pt;
	font-weight: bold;
}

#boardReplyForm {
	display: flex;
	flex-direction: column;
	align-items: center;
	margin: 30px auto;
	text-align: left;
}
</style>

<div id="header" style="text-align: center;">
	<h1>
		<a href="/projectMVC/index.jsp">
			<img alt="사과" src="/projectMVC/image/apple.png" width="50" height="50"></a>
		MVC를 활용한 미니 프로젝트
	</h1>
</div>
<hr style="border-color: yellowgreen;">

<div id="container">
	
	<jsp:include page="../main/boardMenu.jsp" />
	
	<div id="section">
		<form id="boardReplyForm" name="boardReplyForm">
		
			<input type="text" name="pseq" id="pseq" value="${pseq }"> 
			<input type="text" name="pg" id="pg" value="${pg }">
			 
			<h3>답글쓰기</h3>
			<table border="1" cellpadding="7">
				<tr>
					<th width="100">제목</th>
					<td>
						<input type="text" name="subject" id="subject" size="45">
						<div id="subjectDiv"></div>
					</td>
				</tr>
				
				<tr>
					<th>내용</th>
					<td>
						<textarea name="content" id="content" cols="50" rows="15"></textarea>
						<div id="contentDiv"></div>
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
</div>

<script src="http://code.jQuery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
$('#boardReplyBtn').click(function(){
	$('#subjectDiv').empty();
	$('#contentDiv').empty();
	
	if($('#subject').val() == '')
		$('#subjectDiv').html('제목 입력');
	else if($('#content').val() == '')
		$('#contentDiv').html('내용 입력');
	else
		$.ajax({
			type: 'post',
			url: '/projectMVC/board/boardReply.do',
			data: $('#boardReplyForm').serialize() , //pseq, pg, subject, content
					
			dataType: 'text',
			success: function(data){
				//alert(data.trim());
				
				if(data.trim() == 'ok'){
					alert("작성하신 글을 등록하였습니다.");
					location.href = "/projectMVC/board/boardList.do?pg="+$('#pg').val();
				}
			},
			error: function(e){
				console.log(e);
			}
		});
});
</script>









