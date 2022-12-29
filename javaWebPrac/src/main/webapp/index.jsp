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
</div>
</body>
</html>