<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:import url="header.jsp"/>

<div class="container">
    <div class="row">
        <div class="col s12 l8 offset-l2">
            <h3 class="center-align col s12">Регистрация</h3>
            <h5 class="red-text center-align">${message}</h5>
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
                    <form:errors path="email" cssClass="error"/>
                </div>
                <div class="input-field col l6">
                    <label for="login">Логин</label>
                    <form:input path="login" id="login"/>
                    <form:errors path="login" cssClass="error"/>
                </div>
                <div class="input-field col l6">
                    <label for="password">Пароль</label>
                    <form:password path="password" id="password"/>
                    <form:errors path="password" cssClass="error"/>
                </div>
                <div class="input-field col l6">
                    <label for="repeatPassword">Повторите пароль</label>
                    <input type="password" id="repeatPassword">
                </div>
                <button class="btn waves-effect waves-light indigo col s12 l4 offset-l4" type="submit" >Регистрация</button>
            </form:form>
        </div>
    </div>
</div>

<c:import url="footer.jsp"/>
