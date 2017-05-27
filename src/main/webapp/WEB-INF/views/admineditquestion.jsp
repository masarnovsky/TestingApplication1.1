<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url="header.jsp"/>
<div class="container ">
    <div class="row white z-depth-2 margin-top-15px">
        <div class="col s12">
            <div class="row">
                <div class="col s12 center-align">
                    <h4>Редактирование вопроса</h4>
                    <h5 class="flow-text">Для редактирования вопроса выберите модуль</h5>
                </div>
            </div>
            <div class="row">
                <div class="col s12">
                    <div class="col s6">
                        <div class="input-field col s12">
                            <input id="moduleInput" value="" hidden>
                            <select name="module" onchange="setModule(this.value)">
                                <option value="" disabled selected>Выберите модуль</option>
                                <c:forEach var="module" items="${modulesList}">
                                    <option value="${module.getId()}">${module.getTheme()}</option>
                                </c:forEach>
                            </select>
                            <label>Модуль для вопроса</label>
                        </div>
                    </div>
                    <input type="submit" id="butt" class="btn col s6" value="Получить список вопросов">
                </div>
            </div>
        </div>
        <div id="containerForModules"></div>
    </div>
</div>

<c:import url="footer.jsp"/>