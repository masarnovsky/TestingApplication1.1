<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url="header.jsp"/>
<div class="container valign-wrapper">
    <div class="row valign">
        <div class="col s12 l10 offset-l4 white z-depth-2">
            <h3 class="center-align col s12">Авторизация администратора</h3>
            <h5 class="red-text center-align light">${message}</h5>
            <form:form class="col s12 l12" method="post" modelAttribute="admin" action="/admin/login">
                <div class="input-field col s12 l6">
                    <label for="login">Логин</label>
                    <form:input path="login" id="login"/>
                </div>
                <div class="input-field col s12 l6">
                    <label for="password">Пароль</label>
                    <form:password path="password" id="password"/>
                </div>
                <div class="col s12 l6 offset-l3">
                    <button class="btn waves-effect waves-light indigo col s12" type="submit">Войти</button>
                </div>
            </form:form>
        </div>
    </div>
</div>