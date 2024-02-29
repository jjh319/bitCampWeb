<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
#nav {
		margin: 50px 20px 0 100px;
		width: 15%;
		height: 100%;
		float: left;
	}
	#nav ul {
	  list-style: none;
	  padding: 0;
	}
	
	/* 각 항목에 스타일 적용 */
	#nav li {
	  margin-bottom: 10px;
	  padding: 8px;
	  border: 1px solid #ddd;
	  border-radius: 5px;
	  background-color: #f9f9f9;
	}
	
	/* 호버 효과 추가 */
	#nav li:hover {
	  background-color: #e5e5e5;
	}
	hr {border-color :  green;}
</style>
	<div id="nav" >
	seq = <input type="text" id="seq" value="${seq }">
	<h3>
			<c:if test="${memId != null  }">
				<p><a href="/projectMVC/board/boardWriteForm.do">글쓰기</a></p>
			<c:if test="${seq != null  }">
				<p><a href="/projectMVC/board/boardUpdateForm.do?seq=${seq }&pg=${pg }">글수정</a>
			</c:if>
		
		</c:if>
			<p><a href="/projectMVC/board/boardList.do?pg=1">목록</a></p>
		</h3>
		
		</div>