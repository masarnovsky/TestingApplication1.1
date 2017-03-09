<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>

<div>
    <%--<a href="/startTestNow">Начать тест(old)</a>--%>
    <a href="/startTest/testing">Тестовый режим (6 questions)</a>
    <a href="/startTest/training">Тренировочный режим (3 questions)</a>
</div>

<jsp:include page="footer.jsp"/>
