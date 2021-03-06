<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url="header.jsp"/>

<div class="container white z-depth-2">
    <div class="row without-margin-bottom margin-top-15px">
        <div class="col s12 center-align">
            <h5>Модули   <i class="material-icons">info</i></h5>
            <c:if test="${msg ne null}">
                <h5 class="col s12 center-align">${msg}</h5>
            </c:if>
        </div>
    </div>
    <div class="row padding-bottom-15px">
        <div class="col s12">
            <div class="col s12">
                <ul class="collection">
                    <c:set var="ind" value="${0}"/>
                    <c:forEach var="module" items="${modules}">
                        <li class="collection-item">
                            <c:set var="ind" value="${ind + 1}"/>
                                ${module.getTheme()}
                            <span>
                                <a class="secondary-content" href="/testing/start/training?module=${module.getId()}">Тренировка</a>
                                <span class="secondary-content">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                                <a class="secondary-content" href="/testing/start/testing?module=${module.getId()}">Тестирование</a>
                            </span>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>

<c:import url="footer.jsp"/>
