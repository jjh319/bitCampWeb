<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
	<% for(int i=1; i<=9; i++) { %>
	<tr>
		<%for(int dan=2; dan<=9; dan++) { %>
			
			<td><%=dan %> * <%=i %> = <%=dan*i %>&emsp;</td>
			
		<%} // for %>
	</tr>
	<% } // for %>
	</table>
</body>
</html>