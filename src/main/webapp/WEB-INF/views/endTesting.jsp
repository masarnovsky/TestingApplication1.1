<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${msg}
<br>
    Вы ответили на ${rightAnsw} правильных вопросов!
<br>
    <c:if test="${rightAnsw >= avg}">
        Отличный результат!
    </c:if>
<c:if test="${rightAnsw <= avg}">
    Плохой результат!
</c:if>
</body>
</html>
