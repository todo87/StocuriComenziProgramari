<%@ include file="/WEB-INF/views/includes/onlyForLoggedUsers.jsp" %>
<html>
<head>
    <title>Main Master</title>
</head>
<script content="text/javascript">
    depo.controller('mainController', ['$scope', '$http', function ($scope, $http) {
    $scope.student = "asda";
    }]);
</script>
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
