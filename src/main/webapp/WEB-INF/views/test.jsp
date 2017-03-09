<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>

<div style="border: 1px solid black;">
    <c:set var="qId" value="${qId}"/>
    <c:set var="qType" value="${questions[qId].getType()}"/>
    <div>
        IT'S ${qId} | ${qCount} <br>
        Right answers: ${rightAnswers}
    </div>
    <div> Question:  ${questions[qId].getQuestion()}</div>
    <c:if test="${questions[qId].getImg() ne null and qType ne 4}">
        <img src="/resources/img/${questions[qId].getImg()}"/>
    </c:if>

    <form:form modelAttribute="answer"  id="answerForm">
        <c:if test="${qType ne 4}">
            <div>
                <c:forEach var="answer" items="${answersMap[questions[qId].getId()]}">
                    <input type="radio" value="${answer.getId()}" onclick="submitForm(${answer.getId()})"> ${answer.getText()}<br>
                </c:forEach>
                <%--<form:radiobuttons path="text" items="${answersMap[questions[qId].getId()]}"/>--%>
            </div>
        </c:if>
        <c:if test="${qType eq 4}">
            <img src="/resources/img/${questions[qId].getImg()}" usemap="#${questions[qId].getId()}"></div>
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
        document.getElementById("answerForm").setAttribute("action", "/getNextQuestion/" + id);
        document.getElementById("submitButton").removeAttribute("disabled");
        console.log(document.getElementById("selectedAnswer"));
    }
</script>
<jsp:include page="footer.jsp"/>
