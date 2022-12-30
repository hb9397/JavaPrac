<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-12-30
  Time: 오전 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>쿠키 생성</title>
</head>
<body>
    <%
        // 쿠키 생성 및 저장
        // value가 한글인 경우는 인코딩 해줘야 한다.

        Cookie cookie = new Cookie("name", java.net.URLEncoder.encode("군계", "UTF-8"));
        response.addCookie(cookie);
    %>
    <a href="viewcookies.jsp">쿠키 보기</a>
    <script>
        // 유효 시간 설정
        let expire = new Date();
        expire.setDate(expire.getDate() + 60 * 60 * 24); // -> 하루

        // 쿠키 모양 생성
        let cookie = "nickname" + "=" + encodeURI("군계") + "; path=/";

        // 쿠키에 앞서 만든 유효시간을 적용
        cookie += ";expires=" + expire.toGMTString() + ";"
        document.cookie = cookie;
    </script>
</body>
</html>
