<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ECDL тестирование</title>
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="/resources/css/materialize.min.css"  media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/style.css?var=3"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body class="grey lighten-3">
<nav class="light-blue lighten-1" role="navigation">

        <div class="nav-wrapper container">
            <c:if test="${user.getRole() == 'admin'}">
                <a id="logo-container" href="/admin/adminhome" class="brand-logo">ECDL</a>
            </c:if>
            <c:if test="${user.getRole() == 'user'}">
                <a id="logo-container" href="/u/home" class="brand-logo">ECDL</a>
            </c:if>
            <ul class="right hide-on-med-and-down">
                <c:if test="${testingSession eq null}">
                <c:if test="${isLogged == true and user.getRole() eq 'user'}">
                    <li><a href="/u/home">Тесты</a></li>
                    <li><a href="/user/u/cabinet">Пользователь: ${user.getLogin()}</a></li>
                </c:if>
                <c:if test="${isLogged == true and user.getRole() == 'admin'}">
                    <li><a id="adminhome" href="/admin/adminhome">Панель администратора</a></li>
                </c:if>
                </c:if>
                <c:if test="${isLogged == true}">
                    <li><a href="/user/logout">Выйти</a></li>
                </c:if>
            </ul>
        </div>
</nav>