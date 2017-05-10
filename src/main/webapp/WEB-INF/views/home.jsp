<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url="header.jsp"/>

<div class="container">
        <div class="col s12 center-align">
            <h4>Модули   <i class="material-icons">info</i></h4>
            <h5 class="col s12 center-align">${msg}</h5>
        </div>
    <div class="row">
        <div class="col s12">
            <div class="col s12">
                <ul class="collection">
                    <c:set var="ind" value="${0}"/>
                    <c:forEach var="module" items="${modules}">
                        <li class="collection-item">
                                <c:set var="ind" value="${ind + 1}"/>
                                ${module.getTheme()}
                                <span>
                                    <a class="secondary-content" href="/test/start?module=${module.getId()}&type=training">Тренировка</a>
                                    <span class="secondary-content">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                                    <a class="secondary-content" href="/test/start?module=${module.getId()}&type=testing">Тестирование</a>
                                </span>
                            <%--<div class="collapsible-body"><p class="col s10 offset-s1">Lorem for module ${module.getTheme()}</p></div>--%>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>

        <div class="col s12">
            <a class="col s4 offset-l2 btn waves-effect waves-light indigo" href="/testing/start/training?module=6">training режим (6 questions)</a>
            <%--<a class="col s4 offset-l2 btn waves-effect waves-light indigo" href="/test/start/training">Тренировочный режим (3 questions)</a>--%>
        </div>

    </div>
</div>

<c:import url="footer.jsp"/>
