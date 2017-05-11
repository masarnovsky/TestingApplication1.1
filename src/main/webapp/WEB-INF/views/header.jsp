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
    <c:if test="${testingSession eq null}">
        <div class="nav-wrapper container"><a id="logo-container" href="/home" class="brand-logo">ECDL</a>
            <ul class="right hide-on-med-and-down">
                <c:if test="${isLogged == true and user.getRole() eq 'user'}">
                    <li><a href="/home">Тесты</a></li>
                    <li><a href="/user/cabinet">Пользователь: ${user.getLogin()}</a></li>
                </c:if>
                <c:if test="${isLogged == true and user.getRole() == 'admin'}">
                    <li>Панель администратора</li>
                </c:if>
                <c:if test="${isLogged == true}">
                    <li><a href="/user/logout">Выйти</a></li>
                </c:if>
            </ul>
        </div>
    </c:if>
    <c:if test="${testingSession ne null}">
        <div class="nav-wrapper container"><a href="#" class="brand-logo">ECDL</a>
            <ul class="right hide-on-med-and-down">
                <li><a href="/testing/endTesting">Прервать тест</a></li>
                <c:if test="${isLogged == true}">
                    <li><a href="/user/logout">Выйти</a></li>
                </c:if>
            </ul>
        </div>
    </c:if>
</nav>