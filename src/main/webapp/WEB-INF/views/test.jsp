<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url="header.jsp"/>

<c:set var="qId" value="${testingSession.getCurrentIndex()}"/>
<c:set var="currentQuestion" value="${testingSession.getCurrentQuestion()}"/>
<c:set var="qType" value="${currentQuestion.getQuestion().getType()}"/>
<c:set var="answers" value="${currentQuestion.getAnswers()}"/>
<c:set var="testType" value="${testingSession.getTestType().getStringValue()}"/>

<div>
    <div class="row margin-top-15px padding-right-left-15px">
        <div class="col l3">
            <div class="row">
                <div class="col l12 white z-depth-2">
                    <div class="row"></div>
                    <h6 class="center-align col s12">Вопрос ${qId + 1} из ${testingSession.getQuestionCount()}</h6>
                    <h6 class="center-align col s12">Правильных ответов: ${rightAnswers}</h6>
                    <div class="row"></div>
                </div>
            </div>
        </div>

        <div class="col l9 ">
            <div class="row white z-depth-2">
                <div class="col l12">
                    <div class="row">
                        <div class="col l12 ">
                            <div class="row"></div>
                            <h5 class="center-align col s12">Вопрос:    ${currentQuestion.getQuestion().getQuestion()}</h5>
                            <c:if test="${currentQuestion.getQuestion().getImg() ne null and qType ne 4}">
                                <div class="col s12 center-align">
                                    <img src="/resources/img/${currentQuestion.getQuestion().getImg()}"/>
                                </div>
                            </c:if>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col l8 offset-l2">
                            <form:form modelAttribute="answer"  id="answerForm" action="/testing/getNextQuestion">
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
                                            <img src="/resources/img/${currentQuestion.getQuestion().getImg()}" usemap="#${currentQuestion.getQuestion().getId()}"/>
                                            <map name="#${currentQuestion.getQuestion().getId()}">
                                                <c:forEach var="answer" items="${answers}">
                                                    <area shape="poly" href="#${answer.getId()}" coords="${answer.getText()}" onclick="submitForm(${answer.getId()})"/>
                                                </c:forEach>
                                            </map>
                                        </div>
                                    </div>
                                </c:if>


                                <c:if test="${testType eq 'training'}">
                                    <div class="row">
                                        <div class="col s12">
                                            <button class="btn waves-effect waves-light indigo col s4 offset-s1" id="prevButton" onclick="setActionToPrevQ()" type="submit" hidden>Назад</button>
                                            <button class="btn waves-effect waves-light indigo col s4 offset-s2" id="submitButton" onclick="setActionToNextQ()" type="submit">Далее</button>
                                        </div>
                                    </div>
                                </c:if>
                                <c:if test="${testType eq 'testing'}">
                                    <div class="row">
                                        <div class="col s12">
                                            <button class="btn waves-effect waves-light indigo col s12 l4 offset-l4" id="submitButton" type="submit">Далее</button>
                                        </div>
                                    </div>
                                </c:if>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<c:import url="footer.jsp"/>

