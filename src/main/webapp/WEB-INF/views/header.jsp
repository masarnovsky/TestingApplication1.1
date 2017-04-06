<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ECDL тестирование</title>
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="/resources/css/materialize.min.css"  media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/style.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
<nav class="light-blue lighten-1" role="navigation">
    <div class="nav-wrapper container"><a id="logo-container" href="/" class="brand-logo">ECDL</a>
        <ul class="right hide-on-med-and-down">
            <li><a href="#">Тесты</a></li>
            <c:if test="${isLogged == true}">
                <li><a href="/user/account">Пользователь: ${user.getLogin()}</a></li>
                <li><a href="/user/logout">Выйти</a></li>
            </c:if>
        </ul>

        <ul id="nav-mobile" class="side-nav">
            <li><a href="#">Тесты</a></li>
        </ul>
        <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
</nav>
<%--<script type="text/javascript" src="/resources/js/jquery.js"></script>--%>
<%--&lt;%&ndash;<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>&ndash;%&gt;--%>
<%--<script type="text/javascript" src="/resources/js/materialize.min.js"></script>--%>