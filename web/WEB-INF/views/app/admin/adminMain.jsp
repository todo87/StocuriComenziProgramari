<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/views/includes/script/header.jsp"/>
<script type="text/javascript" src="/res/angular/angular-route.min.js"></script>
<script type="text/javascript" src="/res/custom_script/admin/routes.js"></script>
<script type="text/javascript" src="/res/custom_script/admin/commonAdmin.js"></script>
<html>
<head>
    <title>Main Admin</title>
</head>
<body ng-app="depo">
    <div class="container-fluid">
        <p class="logout_paragraph">Logged as <strong>${pageContext.request.userPrincipal.name}</strong> | <a id="logout_link" onclick="formSubmit()">Logout</a></p>
        <form action="/logout" method="post" id="logoutForm" style="display: none;">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <div class="jumbotron">
            <h2>Welcome !</h2>
        </div>
        <div id="divchkCollections" class="admin_left_menu pre-scrollable col-md-2">

        </div>
        <div id="admin_data_table" class="col-md-10" ng-controller="mainController">
            {{student}}

        </div>

    </div>
</body>
</html>
