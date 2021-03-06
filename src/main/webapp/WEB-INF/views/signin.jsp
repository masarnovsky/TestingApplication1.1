<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:import url="header.jsp"/>
<div id="imgBack"/>
<div class="container valign-wrapper fullHeight">
    <div class="row valign">
        <div class="col s12 l8 offset-l2 white z-depth-2">
            <h3 class="center-align col s12">Регистрация</h3>
            <form:form class="col s12" action="/user/signin" method="post" modelAttribute="user">
                <div class="input-field col l6">
                    <label for="name">Имя</label>
                    <form:input path="name" id="name"/>
                </div>
                <div class="input-field col l6">
                    <label for="surname">Фамилия</label>
                    <form:input path="surname" id="surname"/>
                </div>
                <div class="input-field col l6">
                    <label for="email">email</label>
                    <form:input path="email" id="email"/>
                </div>
                <div class="input-field col l6">
                    <label for="login">Логин</label>
                    <form:input path="login" id="login"/>
                </div>
                <div class="input-field col l6">
                    <label for="password">Пароль</label>
                    <form:password path="password" id="password"/>
                </div>
                <div class="input-field col l6">
                    <label for="repeatPassword">Повторите пароль</label>
                    <input type="password" id="repeatPassword" name="repeatPassword">
                </div>
                <div class="col s12 red-text center-align">
                    <h6 class="light">${message}</h6>
                    <h6><form:errors path="email" cssClass="error col s12 light"/></h6>
                    <h6><form:errors path="login" cssClass="error col s12 light"/></h6>
                    <h6><form:errors path="password" cssClass="error col s12 light"/></h6>
                    <div class="row"></div>
                </div>
                <div class="col s12 l6">
                    <a class="btn waves-effect waves-light indigo col s12" href="/">На главную</a>
                </div>
                <div class="col s12 l6">
                    <button class="btn waves-effect waves-light indigo col s12" type="submit">Регистрация</button>
                </div>
            </form:form>
        </div>
    </div>
</div>

<c:import url="footer.jsp"/>
