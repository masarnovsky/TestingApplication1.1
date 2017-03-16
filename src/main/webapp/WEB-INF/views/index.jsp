<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="header.jsp"/>

<div class="container">
    <div class="row">
        <div class="col s12 l8 offset-l2">
            <h3 class="center-align col s12">ECDL Тестирование</h3>
            <h5 class="center-align col s12">Для прохождения тестов нужно авторизоваться</h5>
            <h5 class="center-align col s12">${message}</h5>
            <a class="btn waves-effect waves-light indigo col s12 l4 offset-l1" href="/user?login">Войти</a>
            <a class="btn waves-effect waves-light indigo col s12 l4 offset-l2" href="/user?signin">Регистрация</a>
        </div>
    </div>
</div>

<c:import url="footer.jsp"/>
