<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>

<div>

<c:set var="qId" value="${qId}"/>
<c:set var="qType" value="${questions[qId].getType()}"/>

         <div> Question:  ${questions[qId].getQuestion()}</div>
        <c:if test="${questions[qId].getImg() ne null and qType ne 4}">
            <img src="/resources/img/${questions[qId].getImg()}"/>
        </c:if>
         <c:if test="${qType ne 4}">
             <div>
                 <c:forEach var="answ" items="${answersMap[questions[qId].getId()]}">
                     <input type="radio" name="answer" value="${answ.getId()}"> ${answ.getText()}<Br>
                 </c:forEach>
             </div>
         </c:if>
    <c:if test="${qType eq 4}">
        <img src="/resources/img/${questions[qId].getImg()}" usemap="#${questions[qId].getId()}"></div>
        <map name="#${questions[qId].getId()}">

            <c:forEach var="answ" items="${answersMap[questions[qId].getId()]}">
        <area shape="poly" href="#${answ.getId()}" coords="${answ.getText()}">
            </c:forEach>
        </map>
    </c:if>


    <form:form modelAttribute="questions" action="/getNextQuestion" id="questionForm" method="post">
        <table>
            <thead>
            <%--<tr><th>Question ${idQ}</th></tr>--%>
            </thead>
            <tr>
                <%--<td colspan="2">${question[idQ].question}</td>--%>
            </tr>
            <tr>
                <td colspan="2">
                    <ul style="border: 1px solid black;">
                        <%--<form:radiobuttons delimiter="" element="li" path="answ" items="${answersMap[idQ]}" itemValue="id" itemLabel="text"/>--%>
                    </ul>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Send">
                </td>
            </tr>
        </table>
    </form:form>
</div>

<jsp:include page="footer.jsp"/>
