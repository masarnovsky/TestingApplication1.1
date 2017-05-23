<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp"/>
<div class="row">
<div class="col l10 offset-l1">
    <div class="row margin-top-15px">
        <div class="col l4">
            <div class="row white z-depth-2 margin-left-right-5px">
                <div class="col l12">
                    <ul class="collection">
                        <li class="collection-item">Логин: <span class="secondary-content black-text">${user.getLogin()}</span></li>
                        <li class="collection-item">Имя: <span class="secondary-content black-text">${user.getName()}</span></li>
                        <li class="collection-item">Фамилия: <span class="secondary-content black-text">${user.getSurname()}</span></li>
                        <li class="collection-item">mail: <span class="secondary-content black-text">${user.getEmail()}</span></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col l8">
            <div class="row">
                <section id="modules" class="col s12 white z-depth-2">
                    <h5 class="col s12 center-align">Статистика</h5>
                    <div class="col s12 collection">
                        <c:forEach var="module" items="${modules}">
                            <c:set var="mStatus" value="${resultStatus[module.getId()]}"/>

                            <c:if test="${mStatus eq 'not_started'}">
                                <c:set var="mStatusRus" value="Не начат"/>
                                <c:set var="cl" value="blue"/>
                            </c:if>
                            <c:if test="${mStatus eq 'passed'}">
                                <c:set var="mStatusRus" value="Сдан"/>
                                <c:set var="cl" value="green"/>
                            </c:if>
                            <c:if test="${mStatus eq 'failed'}">
                                <c:set var="mStatusRus" value="Провален"/>
                                <c:set var="cl" value="red"/>
                            </c:if>

                            <div class="collection-item">
                                Модуль ${module.getId()} ${module.getTheme()}
                                <span class="new badge ${cl}" data-badge-caption="${mStatusRus}"></span>
                            </div>
                        </c:forEach>
                    </div>
                </section>
                <section id="chart" class="col s12 z-depth-2 white margin-top-15px without-margin-bottom">
                    <div class="row"></div>
                    <div class="col s8 offset-s2">
                        <canvas id="myChart"></canvas>
                    </div>
                    <div class="row"></div>
                </section>
                <section id="history" hidden class="col s12 white z-depth-2 margin-top-15px without-margin-bottom">
                    <c:if test="${resultHistory.size() eq 0}">
                        <div class="row">
                            <div class="col l12">
                                <h4 class="center-align light">История пуста</h4>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${resultHistory.size() ne 0}">
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
                    </c:if>
                    <div class="row"></div>
                </section>
            </div>
            <div class="row">
                <div class="col s12">
                    <button id="historyButton" class="btn indigo col s4 offset-s4" onclick="historyAction()">История прохождения</button>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<script type="text/javascript" src="/resources/js/Chart.min.js"></script>
<script>
    var ctx = document.getElementById("myChart");
    var myChart = new Chart(ctx, {
        type: 'doughnut',
        data: {
            labels: ["Сдано", "Провалено"],
            datasets: [{
                label: 'Соотношение результатов',
                data: [${passedAttempts}, ${failedAttempts}],
                backgroundColor: [
                    'green',
                    'red'
                ],
                borderColor: [
                    'green',
                    'red',
                ],
                borderWidth: 1
            }]
        },
        options: {
            legend: {
                position: 'right',
                display: true,
            },
            title: {
                display: true,
                text: 'Соотношение попыток'
            }
        }
    });

</script>
<c:import url="footer.jsp"/>
