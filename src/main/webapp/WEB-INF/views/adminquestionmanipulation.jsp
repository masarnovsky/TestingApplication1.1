<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url="header.jsp"/>
<div class="container valign-wrapper fullHeight">
    <div class="row valign">
        <div class="col s12 l8 offset-l4 white z-depth-2">
            <h5 class="center-align col s12 light">${adminmessage}</h5>
            <div class="col s12 l12">
                <a class="btn waves-effect waves-light indigo col s12 l4 offset-l1" href="/admin/${link}">${linkmessage}</a>
                <a class="btn waves-effect waves-light indigo col s12 l4 offset-l2" href="/admin/adminhome">На главную</a>
            </div>
            <div class="row"></div>
        </div>
    </div>
</div>
<c:import url="footer.jsp"/>
