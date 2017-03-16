<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url="header.jsp"/>

<div style="border: 1px solid black;">
    <c:set var="qId" value="${qId}"/>
    <c:set var="qType" value="${questions[qId].getType()}"/>
    <div>
        Вопрос ${qId + 1} из ${qCount} <br>
        Правильных ответов: ${rightAnswers}
    </div>
    <div> Question:  ${questions[qId].getQuestion()}</div>
    <c:if test="${questions[qId].getImg() ne null and qType ne 4}">
        <img src="/resources/img/${questions[qId].getImg()}"/>
    </c:if>

    <form:form modelAttribute="answer"  id="answerForm">
        <c:if test="${qType ne 4}">
            <div>
                <c:forEach var="answer" items="${answersMap[questions[qId].getId()]}">
                    <input name="group1" type="radio" id="id${answer.getId()}" onclick="submitForm(${answer.getId()})">
                    <%--<br>--%>
                    <label for="id${answer.getId()}">${answer.getText()}</label>
                </c:forEach>
                <%--<form:radiobuttons path="text" items="${answersMap[questions[qId].getId()]}"/>--%>
            </div>
        </c:if>
        <c:if test="${qType eq 4}">
            <img class="responsive-img" src="/resources/img/${questions[qId].getImg()}" usemap="#${questions[qId].getId()}"></div>
            <map name="#${questions[qId].getId()}">
                <c:forEach var="answer" items="${answersMap[questions[qId].getId()]}">
                    <area shape="poly" href="#${answer.getId()}" coords="${answer.getText()}" onclick="submitForm(${answer.getId()})">
                </c:forEach>
            </map>
        </c:if>

        <div><input type="hidden" id="selectedAnswer" name="selectedAnswer" value=""></div>
        <div><input id="submitButton" type="submit" value="Send" disabled></div>
    </form:form>
</div>


<script>
    function submitForm(id) {
        document.getElementById("answerForm").setAttribute("action", "/test/getNextQuestion/" + id);
        document.getElementById("submitButton").removeAttribute("disabled");
        console.log(document.getElementById("selectedAnswer"));
    }
</script>


<c:import url="footer.jsp"/>
