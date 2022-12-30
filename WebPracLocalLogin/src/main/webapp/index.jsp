<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title> 로컬 로그인 처리 메인 </title>
</head>
<body>
<h1>프로젝트 구조 실습</h1>
<%
    Object loginInfo = session.getAttribute("logininfo"); // LoginController 에서 발급한 이름과 같아야한다.
    if(loginInfo == null) {

%>
<a href="/login">로그인</a>
  <% } else {
        dto.MemberDTO dto = (dto.MemberDTO)loginInfo;
   %>
        <%= dto.getMname()%> 님 환영합니다. <br/>
        <a href="/logout">로그아웃</a>
<%} %>
</body>
</html>