<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url="header.jsp"/>
<div class="container ">
    <div class="row white z-depth-2 margin-top-15px">
        <div class="col s12">
            <div class="row">
                <div class="col s12 center-align">
                    <h4>Создание нового вопроса</h4>
                    <h5 class="flow-text">Для создания вопроса заполните необходимые поля</h5>
                    <h5 class="flow-text">Правильный ответ должен идти первым!</h5>
                    <h5 class="flow-text">${adminmessage}</h5>
                </div>
            </div>
            <div class="row">
                <div class="col s10 offset-s1">
                    <form enctype="multipart/form-data" method="post" action="/admin/insertQuestionIntoDatabase">
                        <div class="row">
                            <div class="col s6">
                                <div class="input-field col s12">
                                    <select name="module">
                                        <option value="" disabled selected>Выберите модуль</option>
                                        <c:forEach var="module" items="${modulesList}">
                                            <option value="${module.getId()}">${module.getTheme()}</option>
                                        </c:forEach>
                                    </select>
                                    <label>Модуль для вопроса</label>
                                </div>
                            </div>
                            <div class="col s6">
                                <div class="input-field col s12">
                                    <select name="qType" onchange="qTypeChanged(this.value)">
                                        <option value="" disabled selected>Выберите тип вопроса</option>
                                        <c:forEach var="questionType" items="${qtList}">
                                            <option value="${questionType.getId()}">${questionType.getDescr()}</option>
                                        </c:forEach>
                                    </select>
                                    <label>Тип вопроса</label>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col s12">
                                <div class="input-field col s12">
                                    <input id="questionInput" name="questionInput" type="text"/>
                                    <label for="questionInput">Текст вопроса</label>
                                </div>
                            </div>
                        </div>

                        <div id="module" class="row">

                        </div>
                        <div class="row">
                            <div class="col s12">
                                <input type="submit" class="btn col s6 offset-s3" value="Создать">
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