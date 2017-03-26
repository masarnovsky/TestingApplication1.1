<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:import url="header.jsp"/>

<div class="container">
    <div class="row">
        <div class="col s12 l8 offset-l2">
            <h3 class="center-align col s12">Авторизация</h3>
            <h5 class="red-text error center-align">${message}</h5>
            <form:form class="col s12" method="post" modelAttribute="user" action="/user/login">
                <div class="input-field">
                    <label for="login">Логин</label>
                    <form:input path="login" id="login"/>
                </div>
                <div class="input-field">
                    <label for="password">Пароль</label>
                    <form:input path="password" id="password"/>
                </div>
                <button class="btn waves-effect waves-light indigo col s12 l4 offset-l4" type="submit">Войти</button>
            </form:form>
        </div>
    </div>
</div>

<c:import url="footer.jsp"/>

