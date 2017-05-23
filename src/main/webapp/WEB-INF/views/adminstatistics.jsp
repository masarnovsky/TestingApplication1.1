<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url="header.jsp"/>
<div class="container">
    <div class="row white z-depth-2 margin-top-15px">
        <div class="col s12">
            <div class="row">
                <h4 class="col s12 center-align">Общая статистика</h4>
            </div>
            <div class="row center-align">
                <div class="padding-right-left-15px col s4"><span class="z-depth-2 padding-15px-10px blue">Пользователей: ${usersCount}</span></div>
                <div class="padding-right-left-15px col s4"><span class="z-depth-2 padding-15px-10px green">Успешно сдано: ${passedCount}</span> </div>
                <div class="padding-right-left-15px col s4"><span class="z-depth-2 padding-15px-10px red">Провалено: ${failedCount}</span> </div>
            </div>
            <div class="row">
                <div class="col s8 offset-s2">
                    <canvas id="myChart"></canvas>
                </div>
            </div>
            <div class="row">
                <div class="col s12">
                    <button id="detailStat" class="btn indigo col s4 offset-s4" onclick="detailStat()">Детальная статистика</button>
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
            data: [${passedCount}, ${failedCount}],
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
        }
    }
});

</script>

<c:import url="footer.jsp"/>
