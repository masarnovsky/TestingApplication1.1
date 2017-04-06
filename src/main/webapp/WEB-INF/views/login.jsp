<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:import url="header.jsp"/>
<div id="imgBack"/>
<div class="container valign-wrapper fullHeight">
    <div class="row valign">
        <div class="col s12 l10 offset-l4 white z-depth-2">
            <h3 class="center-align col s12">Авторизация</h3>
            <h5 class="red-text center-align light">${message}</h5>
            <form:form class="col s12 l12" method="post" modelAttribute="user" action="/user/login">
                <div class="input-field col s12 l6">
                    <label for="login">Логин</label>
                    <form:input path="login" id="login"/>
                </div>
                <div class="input-field col s12 l6">
                    <label for="password">Пароль</label>
                    <form:password path="password" id="password"/>
                </div>
                <div class="col s12 l6">
                    <a class="btn waves-effect waves-light indigo col s12" href="/">На главную</a>
                </div>
                <div class="col s12 l6">
                    <button class="btn waves-effect waves-light indigo col s12" type="submit">Войти</button>
                </div>
            </form:form>
        </div>
    </div>
</div>

<c:import url="footer.jsp"/>

