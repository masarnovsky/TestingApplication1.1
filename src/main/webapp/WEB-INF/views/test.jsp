<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url="header.jsp"/>

<c:set var="qId" value="${qId}"/>
<c:set var="qType" value="${questions[qId].getType()}"/>

<div class="container white z-depth-2">
    <div class="row">
        <div class="col s12 l10 offset-l1">
                <h5 class="center-align col s12">Вопрос ${qId + 1} из ${qCount}</h5>
                <h5 class="center-align col s12">Правильных ответов: ${rightAnswers}</h5>
                <%--<div class="progress">--%>
                    <%--<div class="determinate" style="width: 70%"/>--%>
                <%--</div>--%>
                <div class="row">
                    <div class="col s12">
                        <p class="center-align col s12">Question:  ${questions[qId].getQuestion()}</p>
                        <c:if test="${questions[qId].getImg() ne null and qType ne 4}">
                            <div class="col s12 center-align">
                                <img src="/resources/img/${questions[qId].getImg()}"/>
                            </div>
                        </c:if>
                    </div>
                </div>

            <form:form class="col s12" modelAttribute="answer"  id="answerForm">

            <c:if test="${qType ne 4}">
                <div class="row">
                    <div class="col s12">
                        <c:forEach var="answer" items="${answersMap[questions[qId].getId()]}">
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

            <%----%>
            <c:if test="${qType eq 4}">
                <div class="row">
                    <div class="col s12 center-align">
                        <img src="/resources/img/${questions[qId].getImg()}" usemap="#${questions[qId].getId()}"></div>
                            <map name="#${questions[qId].getId()}">
                                <c:forEach var="answer" items="${answersMap[questions[qId].getId()]}">
                                    <area shape="poly" href="#${answer.getId()}" coords="${answer.getText()}" onclick="submitForm(${answer.getId()})">
                                </c:forEach>
                            </map>
                </div>
                </div>
            </c:if>

        <button class="btn waves-effect waves-light indigo col s12 l4 offset-l4" id="submitButton" type="submit">Далее</button>
        </form:form>


        </div>
    </div>
</div>


<script>
    function submitForm(id) {
        document.getElementById("answerForm").setAttribute("action", "/test/getNextQuestion/" + id);
//        document.getElementById("submitButton").removeAttribute("disabled");
    }
</script>


<c:import url="footer.jsp"/>
