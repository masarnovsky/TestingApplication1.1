<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url="header.jsp"/>

<div class="container">
    <div class="row">
        <div class="col s12 center-align">
            <h4>Модули</h4><i class="material-icons">info</i>
        </div>
    </div>
    <div class="row">
        <div class="col s12">
            <h4 class="col s12 center-align">${msg}</h4>
            <div class="col s12">
                <ul class="collapsible" data-collapsible="expandable">
                    <c:set var="ind" value="${0}"/>
                    <c:forEach var="module" items="${modules}">
                        <li>
                            <div class="collapsible-header" onclick="expand(${ind})">
                                <c:set var="ind" value="${ind + 1}"/>
                                <div class="col s12">
                                    <div class="col s6">${module.getTheme()}</div>
                                    <div class="col s3">
                                        <a  href="/test/module?${module.getId()}&type?training">Тренировка</a>
                                    </div>
                                    <div class="col s3">
                                        <a href="/test/module?${module.getId()}&type?testing">Тестирование</a>
                                    </div>
                                </div>
                            </div>
                            <div class="collapsible-body"><p class="col s10 offset-s1">Lorem for module ${module.getTheme()}</p></div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>

        <div class="col s12">
            <a class="col s4 offset-l2 btn waves-effect waves-light indigo" href="/test/start/testing">Тестовый режим (6 questions)</a>
            <a class="col s4 offset-l2 btn waves-effect waves-light indigo" href="/test/start/training">Тренировочный режим (3 questions)</a>
        </div>

    </div>
</div>

<c:import url="footer.jsp"/>
