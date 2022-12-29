<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<h1> JSP 에 TEXT 작성하기</h1>
<%
    int sum = 0;
    for(int i=0; i<10; i++){
        sum = sum + i;
    }
%>
<div><%=sum%></div>

<a href="sample.jsp">Hello sample</a>
<div>
    <%=
        request.getRemoteAddr()
    %>
</div><br/>
<a href="res.jsp?name=park">GET 요청</a>

<form method="post" action="res.jsp">
    별명: <input type="text" name="nickname"/>
    <input type="submit" /> 전송
</form>

<%

    // 모든 헤더 정보를 출력하게 하기
    // 브라우저나 운영체제 정보, 쿠키 등을 확인 할 수 있다.
    java.util.Enumeration <String> headerEnum = request.getHeaderNames();
    while (headerEnum.hasMoreElements()){
        String name  = headerEnum.nextElement();
        String value = request.getHeader(name);

%>
<%= name%>:<%= value %> <br/>
<%}%>


<% // web.xml 파일의 초기화 파라미터 읽어 오기
    String user = application.getInitParameter("User");
%>
<br/>
web.xml 에 설정한 초기화 파라미터 출력하기
<br/>
<%= // 가지고 온 파리미터 출력하기
   user
%>
<br/>
<button>
    <a href="input.jsp">요청 페이지(input.jsp)로 이동</a>
</button>
</body>
</html>