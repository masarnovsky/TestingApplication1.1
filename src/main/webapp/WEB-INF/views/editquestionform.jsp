<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:import url="header.jsp"/>
<div class="container ">
    <div class="row white z-depth-2 margin-top-15px">
        <div class="col s12">
            <div class="row">
                <div class="col s12 center-align">
                    <h4>Редактирование вопроса</h4>
                </div>
            </div>
            <div class="row">
                <div class="col s10 offset-s1">
                    <form enctype="multipart/form-data" method="post" action="/admin/updateQuestionInDatabase">
                        <div class="row">
                            <div class="col s6">
                                <div class="input-field col s12">
                                    <select name="module">
                                        <c:forEach var="module" items="${modulesList}">
                                            <c:if test="${module.getId() eq question.getModule()}">
                                                <option value="${module.getId()}" selected>${module.getTheme()}</option>
                                            </c:if>
                                            <c:if test="${module.getId() ne question.getModule()}">
                                                <option value="${module.getId()}" disabled>${module.getTheme()}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                    <label>Модуль для вопроса</label>
                                </div>
                            </div>
                            <div class="col s6">
                                <div class="input-field col s12">
                                    <select name="qType">
                                        <c:forEach var="questionType" items="${qtList}">
                                            <c:if test="${questionType.getId() eq question.getType()}">
                                                <option value="${questionType.getId()}" selected>${questionType.getDescr()}</option>
                                            </c:if>
                                            <c:if test="${questionType.getId() ne question.getType()}">
                                                <option value="${questionType.getId()}" disabled>${questionType.getDescr()}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                    <label>Тип ответа</label>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col s12">
                                <div class="input-field col s12">
                                    <input size="400" value="${question.getQuestion()}" id="questionInput" name="questionInput" type="text"/>
                                    <label for="questionInput">Текст вопроса</label>
                                </div>
                            </div>
                        </div>
                        <div id="module">
                            <%--<c:if test="${question.getType() ne 4}">--%>
                                <c:if test="${question.getImg() ne null}">
                                    <div class="col s12 center-align" id="imgPlaceholder">
                                        <img id="imgPic" class="responsive-img" src="/resources/img/${question.getImg()}" style="border: 1px solid black;"/>
                                    </div>
                                    <div class="margin-top-15px"></div>
                                </c:if>
                                <c:set var="ind" value="1"/>
                                <c:forEach var="answer" items="${answers}" >
                                    <c:if test="${ind eq 1}">
                                        <div class="input-field col s12">
                                            <label>Правильный ответ:</label>
                                            <input value="${answer.getText()}" name="answer${ind}" type="text" />
                                        </div>
                                    </c:if>
                                    <c:if test="${ind ne 1}">
                                        <div class="input-field col s12">
                                            <label>Ответ:</label>
                                            <input value="${answer.getText()}" name="answer${ind}" type="text" />
                                        </div>
                                    </c:if>
                                    <c:set var="ind" value="${ind + 1}"/>
                                </c:forEach>
                            <%--</c:if>--%>
                        </div>
                        <div class="row">
                            <div class="col s12">
                                <input type="submit" class="btn col s6 offset-s3" value="Обновить">
                            </div>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
</div>

<c:import url="footer.jsp"/>