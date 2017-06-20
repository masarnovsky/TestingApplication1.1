<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="header.jsp"/>

<div id="imgBack"/>
<div class="container valign-wrapper fullHeight">
    <div class="row valign">
        <div class="col s12 l8 offset-l2 white z-depth-2">
            <h3 class="center-align col s12">ECDL Тестирование</h3>
            <h5 class="center-align col s12 light">Для прохождения тестов нужно авторизоваться</h5>
            <h5 class="center-align col s12 light">${message}</h5>
            <div class="row"></div>
            <div class="col s12">
                <a class="btn waves-effect waves-light indigo col s12 l4 offset-l1" href="/user?login">Войти</a>
                <a class="btn waves-effect waves-light indigo col s12 l4 offset-l2" href="/user?signin">Регистрация</a>
            </div>
            <div class="row"></div>
        </div>
    </div>
</div>

<c:import url="footer.jsp"/>
