<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url="header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col s12 center-align">
            <h3>Создание нового вопроса</h3>
            <h5>Для создания вопроса заполите необходимые поля</h5>
            <h5>Правильный ответ должен идти первым!</h5>
            <h5>${adminmessage}</h5>
        </div>
    </div>
    <div class="row">
        <div class="col s12">
            <form enctype="multipart/form-data" method="post" action="/admin/insertQuestionIntoDatabase">
                <div class="row">
                    <div class="col s6">
                        <div class="input-field col s12">
                            <select>
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
                            <select onchange="qTypeChanged(this.value)">
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
                        <input id="questionInput" class="input-field col s12"/>
                        <label for="questionInput">Текст вопроса</label>
                    </div>
                </div>

                <div id="firstType" class="row" hidden>
                    <div class="col s12">
                        <div class="input-field col s12">
                            <label>Правильный ответ:</label>
                            <input type="text" />
                        </div>
                        <div class="input-field col s12">
                            <label>Ответ:</label>
                            <input type="text" />
                        </div>
                        <div class="input-field col s12">
                            <label>Ответ:</label>
                            <input type="text" />
                        </div>
                        <div class="input-field col s12">
                            <label>Ответ:</label>
                            <input type="text" />
                        </div>
                    </div>
                </div>

                <div id="secondType" class="row" hidden>
                    <div class="col s12">
                        <div class="col s12">
                            <div class="input-field col s12">
                                <label>Правильный ответ:</label>
                                <input type="text" />
                            </div>
                            <div class="input-field col s12">
                                <label>Ответ:</label>
                                <input type="text" />
                            </div>
                        </div>
                    </div>
                </div>

                <div id="thirdType" class="row" hidden>
                    <div class="col s12">
                        <div class="col s12 file-field input-field">
                            <div class="btn">
                                <span>Загрузить картинку</span>
                                <input type="file" name="image" accept="image/*">
                            </div>
                            <div class="file-path-wrapper">
                                <input class="file-path validate" type="text">
                            </div>
                        </div>
                    </div>
                    <div class="col s12">
                        <div class="col s12">
                            <div class="input-field col s12">
                                <label>Правильный ответ:</label>
                                <input type="text" />
                            </div>
                            <div class="input-field col s12">
                                <label>Ответ:</label>
                                <input type="text" />
                            </div>
                            <div class="input-field col s12">
                                <label>Ответ:</label>
                                <input type="text" />
                            </div>
                            <div class="input-field col s12">
                                <label>Ответ:</label>
                                <input type="text" />
                            </div>
                        </div>
                    </div>
                </div>

                <div id="fourthType" class="row" hidden>
                    <div class="col s12">
                        <div class="col s12 file-field input-field">
                            <div class="btn">
                                <span>Загрузить картинку</span>
                                <input type="file" name="image" accept="image/*">
                            </div>
                            <div class="file-path-wrapper">
                                <input class="file-path validate" type="text">
                            </div>
                        </div>
                    </div>
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

<c:import url="footer.jsp"/>

<script>

</script>