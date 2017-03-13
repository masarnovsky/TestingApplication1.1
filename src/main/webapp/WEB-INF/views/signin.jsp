<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:import url="header.jsp"/>

<div>
    <h3>Регистрация</h3>
    <form:form method="post" modelAttribute="user">
        <fieldset>
            <label for="name">Имя</label>
            <form:input path="name" id="name"/>
            <hr>
            <label for="surname">Фамилия</label>
            <form:input path="surname" id="surname"/>
            <hr>
            <label for="email">email</label>
            <form:input path="email" id="email"/>
            <hr>
            <label for="login">Логин</label>
            <form:input path="login" id="login"/>
            <hr>
            <label for="password">Пароль</label>
            <form:password path="password" id="password"/>
            <hr>
            <input type="submit" value="Регистрация">
        </fieldset>
    </form:form>
</div>

<c:import url="footer.jsp"/>
