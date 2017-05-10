<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url="header.jsp"/>

<c:set var="qId" value="${testingSession.getCurrentIndex()}"/>
<c:set var="currentQuestion" value="${testingSession.getCurrentQuestion()}"/>
<c:set var="qType" value="${currentQuestion.getQuestion().getType()}"/>
<c:set var="answers" value="${currentQuestion.getAnswers()}"/>

<div class="container white z-depth-2">
    <div class="row">
        <div class="col s12 l10 offset-l1">
                <h5 class="center-align col s12">Вопрос ${qId + 1} из ${testingSession.getQuestionCount()}</h5>
                <h5 class="center-align col s12">Правильных ответов: ${rightAnswers}</h5>
                <div class="row">
                    <div class="col s12">
                        <p class="center-align col s12">Question:  ${currentQuestion.getQuestion().getQuestion()}</p>
                        <c:if test="${currentQuestion.getQuestion().getImg() ne null and qType ne 4}">
                            <div class="col s12 center-align">
                                <img src="/resources/img/${currentQuestion.getQuestion().getImg()}"/>
                            </div>
                        </c:if>
                    </div>
                </div>

            <form:form class="col s12" modelAttribute="answer"  id="answerForm" action="/testing/getNextQuestion">
            <input id="userAnswer" name="userAnswer" hidden>
            <c:if test="${qType ne 4}">
                <div class="row">
                    <div class="col s12">
                        <c:forEach var="answer" items="${answers}">
                            <div class="row">
                                <input class="col s1" name="group1" type="radio" id="id${answer.getId()}" onclick="submitForm(${answer.getId()})">
                                <label class="col s12" for="id${answer.getId()}">
                                    <div class="col s12">
                                            ${answer.getText()}
                                    </div>
                                </label>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </c:if>
            <c:if test="${qType eq 4}">
                <div class="row">
                    <div class="col s12 center-align">
                        <img src="/resources/img/${currentQuestion.getQuestion().getImg()}" usemap="#${currentQuestion.getQuestion().getId()}"></div>
                            <map name="#${currentQuestion.getQuestion().getId()}">
                                <c:forEach var="answer" items="${answers}">
                                    <area shape="poly" href="#${answer.getId()}" coords="${answer.getText()}" onclick="submitForm(${answer.getId()})">
                                </c:forEach>
                            </map>
                </div>
                </div>
            </c:if>

        <c:set var="testType" value="${testingSession.getTestType().getStringValue()}"/>
        <c:if test="${testType eq 'training'}">
            <div class="col s12">
                <button class="btn waves-effect waves-light indigo col s4 offset-s2" id="prevButton" type="submit">Назад</button>
                <button class="btn waves-effect waves-light indigo col s4 offset-s2" id="submitButton" type="submit">Далее</button>
            </div>
        </c:if>
        <c:if test="${testType eq 'testing'}">
            <button class="btn waves-effect waves-light indigo col s12 l4 offset-l4" id="submitButton" type="submit">Далее</button>
        </c:if>
        </form:form>


        </div>
    </div>
</div>
<c:import url="footer.jsp"/>
