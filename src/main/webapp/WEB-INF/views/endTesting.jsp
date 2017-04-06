<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url="header.jsp"/>

<div class="container">
    <div class="row">
        <div class="col s12 center-align">
            <h5>${msg}</h5>
            <h5>Вы ответили на ${rightAnswers} правильных вопросов из ${qCount}</h5>
            <c:if test="${rightAnswers >= avg}">
                <h4>Отличный результат!</h4>
            </c:if>
            <c:if test="${rightAnswers < avg}">
                <h4>Плохой результат!</h4>
            </c:if>
        </div>

        <div class="col s12 center-align">
            <h4>Результаты ответов:</h4>
        </div>

        <c:set var="answ" value="${questionsAnsw}"/>
        <c:set var="ind" value="${0}"/>

        <div class="col s12">
            <ul class="left-align">
                <c:forEach var="a" items="${answ}">
                    <li class="${a}">${ind} - ${questions[ind].getQuestion()} - ${a}</li>
                    <c:set var="ind" value="${ind+1}"/>
                </c:forEach>
            </ul>
        </div>

        <a class="btn waves-effect waves-light indigo col s12 m6 l4 offset-l4" href="/home">На главную</a>
    </div>
</div>

<c:import url="footer.jsp"/>

</body>
</html>
