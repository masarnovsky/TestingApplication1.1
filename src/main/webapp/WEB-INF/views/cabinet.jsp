<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp"/>

<div class="container">
    <div class="row">
        <div class="col s4">
            <h5 class="col s12 center-align">${user.getName()} ${user.getSurname()}</h5>
            <div class="col s12" style="height: 300px; width: 300px; border: 1px solid black">
                // photo
            </div>
        </div>
        <div class="col s8">
            <h5 class="col s12 center-align">Статистика</h5>
            <section class="col s12">
                <ul>
                    <c:forEach var="module" items="${modules}">
                        <li>
                            <div class="col s8">Модуль ${module.getId()} ${module.getTheme()}</div>
                            <div class="col s4">${resultStatus[module.getId()]}</div>
                        </li>
                    </c:forEach>
                </ul>
            </section>
            <section class="col s12">
                <div class="col s5">
                    //chart
                </div>
                <div class="col s7">
                    //output
                </div>
            </section>
            <section id="history" hidden>
                //show more (history)
            </section>
            <div class="col s12">
                <button>Показать историю прохождения</button>
            </div>
        </div>
    </div>
</div>

<c:import url="footer.jsp"/>
