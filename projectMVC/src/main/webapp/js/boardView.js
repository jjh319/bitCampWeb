$(function(){
	$.ajax({
		type:'post',
		url:'/projectMVC/board/getBoard.do',
		data: 'seq=' + $('#seq').val(),
		dataType:'json',
		success: function(data){
			//console.log(JSON.stringify(data));
			
			$('#subjectSpan').text(data.subject);
			$('#seqSpan').text(data.seq);
			$('#idSpan').text(data.id);
			$('#hitSpan').text(data.hit);
			$('#contentSpan').text(data.content);
			
			//자기가 작성한 글인지 확인하기?
			/*if(내가 작성한 글이 맞다면)
				boardViewSpan 보이기
			else 
				boardViewSpan 감추기*/
			if($('#memId').val() == data.id)
				$('#boardViewSpan').show();
			else
				$('#boardViewSpan').hide();
		},
		error: function(e){
			console.log(e);
		}
	});
});

//글수정

//글삭제
$('#boardDeleteFormBtn').click(function(){
	$('#boardViewForm').attr('action','/projectMVC/board/boardDelete.do');
	$('#boardViewForm').submit();//seq ,pg 만 넘어감
});

//답글
$('#boardReplyFormBtn').click(function(){
	$('#boardViewForm').attr('action','/projectMVC/board/boardReplyForm.do');
	$('#boardViewForm').submit();//seq ,pg 만 넘어감
});


