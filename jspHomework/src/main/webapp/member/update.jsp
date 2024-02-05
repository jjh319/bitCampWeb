<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="member.dao.MemberDAO"%>
<%@ page import="member.bean.MemberDTO"%>
<%
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");

        String gender = request.getParameter("gender");
        String email1 = request.getParameter("email1");
        String email2 = request.getParameter("email2");

        String tel1 = request.getParameter("tel1");
        String tel2 = request.getParameter("tel2");
        String tel3 = request.getParameter("tel3");

        String zipcode = request.getParameter("zipcode");
        String addr1 = request.getParameter("addr1");
        String addr2 = request.getParameter("addr2");

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName(name);
        memberDTO.setId(id);
        memberDTO.setAddr1(addr1);
        memberDTO.setAddr2(addr2);
        memberDTO.setEmail1(email1);
        memberDTO.setEmail2(email2);
        memberDTO.setGender(gender);
        memberDTO.setPwd(pwd);
        memberDTO.setTel1(tel1);
        memberDTO.setTel2(tel2);
        memberDTO.setTel3(tel3);
        memberDTO.setZipcode(zipcode);

    MemberDAO memberDAO = MemberDAO.getInstance();
    boolean su = memberDAO.updateData(memberDTO);

%>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%if (su){%>}
    <script>
        alert("회원정보 수정 완료");
        location.href="loginForm.jsp";
    </script>
    <%} else { %>
    수정 실패 <br>
    <%} %>
</body>
</html>
