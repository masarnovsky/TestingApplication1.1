<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp"/>

<div class="container">
    <div class="row">
        <div class="col s3">
            <h5 class="col s12 center-align">${user.getLogin()}</h5>
            <div class="col s12" style="height: 250px; width: 250px; border: 1px solid black">
                <ul class="col s12">
                    <li>
                        <div class="col s6">Имя:</div>
                        <div class="col s6">${user.getName()}</div>
                    </li>
                    <li>
                        <div class="col s6">Фамилия:</div>
                        <div class="col s6">${user.getSurname()}</div>
                    </li>
                    <li>
                        <div class="col s6">email:</div>
                        <div class="col s6">${user.getEmail()}</div>
                    </li>
                    <li>
                        <div class="col s6">Дата регистрации:</div>
                        <div class="col s6">${user.getRegDate()}</div>
                    </li>
                </ul>
            </div>
        </div>
        <div class="col s9">
            <h5 class="col s12 center-align">Статистика</h5>
            <section class="col s12">
                <div class="col s12 collection">
                    <c:forEach var="module" items="${modules}">
                        <c:set var="mStatus" value="${resultStatus[module.getId()]}"/>

                        <c:if test="${mStatus eq 'not_started'}">
                            <c:set var="mStatusRus" value="Не начат"/>
                            <c:set var="cl" value=""/>
                        </c:if>
                        <c:if test="${mStatus eq 'passed'}">
                            <c:set var="mStatusRus" value="Сдан"/>
                            <c:set var="cl" value="blue"/>
                        </c:if>
                        <c:if test="${mStatus eq 'failed'}">
                            <c:set var="mStatusRus" value="Провален"/>
                            <c:set var="cl" value="red"/>
                        </c:if>

                        <div class="collection-item">
                            Модуль ${module.getId()} ${module.getTheme()}
                            <span class="new badge ${cl}" data-badge-caption="${mStatusRus}"></span>
                            <%--<div class="col s2">st : ${status[module.getId()]}</div>--%>
                        </div>
                    </c:forEach>
                </div>
            </section>
            <section class="col s12">
                <div class="col s5">
                    //chart
                </div>
                <div class="col s7">
                    //output
                </div>
            </section>
            <section id="history" hidden class="row">
                <h5 class="col s12 center-align">История прохождения тестов</h5>
                    <table class="col s12 striped centered padding-bottom-30px">
                        <thead><tr>
                            <th>Модуль</th>
                            <th>Результат</th>
                            <th>Дата</th>
                            <th>Время</th>
                        </tr></thead>
                        <tbody>
                        <c:forEach var="result" items="${resultHistory}">
                            <tr>
                                <td>${result.getModule()}</td>

                                <c:set var="res" value="${result.getResult()}"/>

                                <c:if test="${res eq 'not_started'}">
                                    <c:set var="res" value="Не начат"/>
                                </c:if>
                                <c:if test="${res eq 'passed'}">
                                    <c:set var="res" value="Сдан"/>
                                </c:if>
                                <c:if test="${res eq 'failed'}">
                                    <c:set var="res" value="Провален"/>
                                </c:if>

                                <td>${res}</td>
                                <td>${result.getDate()}</td>
                                <td>${result.getTime()}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
            </section>
            <div class="row">
                <div class="col s12">
                    <button class="btn waves-effect waves-light indigo col s4 offset-s4" onclick="getHistory()">История прохождения</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    function getHistory() {
        document.getElementById("history").removeAttribute("hidden");
    }
</script>
<c:import url="footer.jsp"/>
