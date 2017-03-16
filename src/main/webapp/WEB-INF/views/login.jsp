<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:import url="header.jsp"/>

<div>
    <h3>Авторизация</h3>
    <h5>${message}</h5>
    <form:form method="post" modelAttribute="user" action="/user/login">
        <fieldset>
            <label for="login">Логин</label>
            <form:input path="login" id="login"/>
            <%--<form:errors path="login" cssClass="error"/>--%>
            <label for="password">Пароль</label>
            <form:password path="password" id="password"/>
            <%--<form:errors path="password" cssClass="error"/>--%>
            <input type="submit" value="Войти">
        </fieldset>
    </form:form>
</div>

<c:import url="footer.jsp"/>

