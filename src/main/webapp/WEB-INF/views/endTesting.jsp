<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
UUU - ${users}
    Hey! you got ${rightAnsw} right answers!
<br>
    <c:if test="${rightAnsw >= avg}">
        Your got great result!
    </c:if>
<c:if test="${rightAnsw <= avg}">
    Bad result!
</c:if>
</body>
</html>
