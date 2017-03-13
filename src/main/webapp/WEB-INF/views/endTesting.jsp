<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${msg}
<br>
    Вы ответили на ${rightAnsw} правильных вопросов из ${qCount}
<br>
    <c:if test="${rightAnsw >= avg}">
        Отличный результат!
    </c:if>
<c:if test="${rightAnsw <= avg}">
    Плохой результат!
</c:if>

<h3>Результаты ответов:</h3>
<c:set var="answ" value="${questionsAnsw}"/>
<c:set var="ind" value="${0}"/>
<ul>
    <c:forEach var="a" items="${answ}">
        <li>${ind} - ${questions[ind].getQuestion()} - ${a}</li>
        <c:set var="ind" value="${ind+1}"/>
    </c:forEach>
</ul>
<a href="/">На главную</a>
</body>
</html>
