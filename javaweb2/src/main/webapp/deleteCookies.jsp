<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-12-30
  Time: 오전 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>쿠키 삭제</title>
</head>
<body>
    <%
        // name Cookie 삭제
        // 실제로 삭제하는 것이 아니라 key에 대한 value를 null로 만료기간을 0으로 초기화 하는 것이다.
        // Cookie는 해당 브라우저의 session이 만료될 때 까지 유지 되기 때문
        Cookie [] cookies = request.getCookies();
        for(Cookie cookie : cookies){ // request 객체에 있는 모든 쿠키 요소에 순회하면서 접근해
            if(cookie.getName().equals("name")){ // name 이란 키를 가진 쿠키를 만나면
                Cookie cookie1 = new Cookie("name", ""); // 해당 cookie 값을 새로운 key = name, value = "" 로 만들어주고
                cookie.setMaxAge(0); // maxAge 를 0으로 해서 쿠키를 만료 시킨뒤
                response.addCookie(cookie1); // 응답으로 해당 쿠키를 적용한다.
            }
        }
    %>
</body>
</html>
