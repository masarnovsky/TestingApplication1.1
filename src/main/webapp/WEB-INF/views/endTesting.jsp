<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url="header.jsp"/>

<c:set var="avg" value="${atestingSession.getQuestionCount()/rightAnswers}" />
<c:set var="questions" value="${atestingSession.getQuestionWithAnswersList()}" />
<c:if test="${procent >= 75}">
    <c:set value="Тест пройден!" var="resultMsg"/>
</c:if>
<c:if test="${procent < 75}">
    <c:set value="Тест провален!" var="resultMsg"/>
</c:if>

<div class="container">
    <div class="row">
        <div class="col s12 white z-depth-2 margin-top-15px">
            <div class="row">
                <div class="col l12 padding-top-15px">
                    <h5 class="center-align">Вы ответили правильно на ${rightAnswers} из ${atestingSession.getQuestionCount()} вопросов. ${resultMsg}</h5>
                </div>
            </div>
            <div class="row">
                <div class="col s12 center-align">
                    <h4 class="light">Результаты ответов:</h4>
                </div>
                <div class="col s12">
                    <ul class="collection col s10 offset-s1" style="border: hidden;">
                        <c:forEach var="q" items="${questions}">
                            <c:if test="${q.isUserChoseRightAnswer() ne true}">
                                <c:set var="cl" value="red"/>
                            </c:if>
                            <c:if test="${q.isUserChoseRightAnswer() eq true}">
                                <c:set var="cl" value="green"/>
                            </c:if>
                            <li class="collection-item ${cl}">${q.getQuestion().getQuestion()}</li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div class="row">
                <div class="col s12">
                    <a class="btn waves-effect waves-light indigo col s12 m6 l4 offset-l4" href="/u/home">На главную</a>
                </div>
            </div>
        </div>
    </div>
</div>

<c:import url="footer.jsp"/>

</body>
</html>
