<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:import url="header.jsp"/>

<div class="container">
    <div class="row white z-depth-2 margin-top-15px">
        <div class="col l12">
            <div class="row"></div>
            <div class="row">
                <div class="col s12 center-align">
                    <a class="btn indigo col l6 offset-l3" href="/admin/statistics">Статистика</a>
                </div>
            </div>
            <div class="row">
                <div class="col l12 center-align">
                    <a class="btn indigo col l6 offset-l3" href="/admin/createQuestion">Создать вопрос</a>
                </div>
            </div>
            <div class="row">
                <div class="col l12 center-align">
                    <a class="btn indigo col l6 offset-l3" href="/admin/editQuestion">Редактировать вопрос</a>
                </div>
            </div>
        </div>
    </div>
</div>

<c:import url="footer.jsp"/>