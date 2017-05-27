<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">
    <div class="col l12">
        <div class="col s12">
            <ul class="collection">
                <c:forEach var="q" items="${questions}">
                    <li class="collection-item">${q.getQuestion()}<span><a class="secondary-content black-text" href="/admin/editQuestionById?id=${q.getId()}"><i class="material-icons">edit</i> </a></span></li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>