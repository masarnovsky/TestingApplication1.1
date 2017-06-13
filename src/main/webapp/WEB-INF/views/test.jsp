<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url="header.jsp"/>

<c:set var="qId" value="${testingSession.getCurrentIndex()}"/>
<c:set var="currentQuestion" value="${testingSession.getCurrentQuestion()}"/>
<c:set var="qType" value="${currentQuestion.getQuestion().getType()}"/>
<c:set var="answers" value="${currentQuestion.getAnswers()}"/>
<c:set var="testType" value="${testingSession.getTestType().getStringValue()}"/>

<div id="testPage">
    <div class="row margin-top-15px padding-right-left-15px">
        <div class="col l3">
            <c:if test="${testType eq 'testing'}">
                <div class="row">
                    <div id="timer" class="col s12 red btn-large accent-4">
                        Минут:&nbsp;&nbsp;&nbsp;секунд:&nbsp;&nbsp;
                    </div>
                </div>
            </c:if>
            <div class="row">
                <div class="col l12 white z-depth-2">
                    <div class="row"></div>
                    <h6 class="center-align col s12">Вопрос ${qId + 1} из ${testingSession.getQuestionCount()}</h6>
                    <c:if test="${testType eq 'training'}">
                        <h6 class="center-align col s12">Правильных ответов: ${rightAnswers}</h6>
                    </c:if>
                    <div class="row"></div>
                </div>
            </div>
            <div class="row">
                <div class="col l12">
                    <button onclick="openModal()" data-target="breakModel" class="btn red accent-4 col s8 offset-s2">Прервать тест</button>
                </div>
            </div>
        </div>
<%--MODAL WINDOW--%>
        <div id="breakModel" class="modal">
            <div class="modal-content">
                <h4>Прервать тест</h4>
                <p>Вы уверены, что хотите прервать тест? Все данные будут утеряны.</p>
            </div>
            <div class="modal-footer">
                <a href="/testing/breakTest" class="modal-action modal-close btn-flat">Прервать</a>
                <a href="#" class="modal-action modal-close btn-flat">Вернуться к тесту</a>
            </div>
        </div>

        <div id="timeIsOverModal" class="modal">
            <div class="modal-content">
                <h4>Время истекло</h4>
                <p>Будут засчитаны только те ответы, на которые Вы успели ответить.</p>
            </div>
            <div class="modal-footer">
                <a href="/testing/showResults" class="modal-action modal-close btn-flat">Показать результат</a>
            </div>
        </div>
<%--MODAL WINDOW--%>
        <div class="col l9 ">
            <div class="row white z-depth-2">
                <div class="col l12">
                    <div class="row">
                        <div class="col l12 ">
                            <div class="row"></div>
                            <h5 class="center-align col s12 flow-text">Вопрос:    ${currentQuestion.getQuestion().getQuestion()}</h5>
                            <c:if test="${currentQuestion.getQuestion().getImg() ne null and qType ne 4}">
                                <div class="col s12 center-align">
                                    <img src="/resources/img/${currentQuestion.getQuestion().getImg()}" style="border: 1px solid black;"/>
                                </div>
                            </c:if>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col l8 offset-l2">
                            <form:form modelAttribute="answer"  id="answerForm" action="/testing/getNextQuestion">
                                <input id="userAnswer" name="userAnswer" hidden>
                                <input id="minutes" name="minutes" value="${minutes}" hidden>
                                <input id="seconds" name="seconds" value="${seconds}" hidden>
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
                                            <img src="/resources/img/${currentQuestion.getQuestion().getImg()}" usemap="#${currentQuestion.getQuestion().getId()}" style="border: 1px solid black;"/>
                                            <map name="#${currentQuestion.getQuestion().getId()}">
                                                <c:forEach var="answer" items="${answers}">
                                                    <area shape="rect" href="#${answer.getId()}" coords="${answer.getText()}" onclick="submitForm(${answer.getId()})"/>
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
                                            <button class="btn waves-effect waves-light indigo col s12 l4 offset-l4" id="submitButton" onclick="setActionToNextQ()" type="submit">Далее</button>
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

