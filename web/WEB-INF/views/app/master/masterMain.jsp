<%@ include file="/WEB-INF/views/includes/onlyForLoggedUsers.jsp" %>
<html>
<head>
    <title>Main Master</title>
</head>
<script content="text/javascript" src="/res/custom_script/admin/masterMain.js"></script>
<body ng-app="depo">
    <div class="container-fluid" ng-controller="masterMainController">
        <p class="logout_paragraph">Logged as <strong>${pageContext.request.userPrincipal.name}</strong> | <a id="logout_link" onclick="formSubmit()">Logout</a></p>
        <form action="/logout" method="post" id="logoutForm" style="display: none;">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <div class="jumbotron">
            <h2>Welcome !</h2>
        </div>
        <div id="divChkListOfTables" class="admin_left_menu pre-scrollable col-md-2">
            <div id="chkListOfTables" class="admin_tables_list radio">
                <h4>Tables</h4>
                <label ng-repeat="table in listOfTables">
                    <input type="radio" name="chkCollectionsRadio" ng-model="$parent.valueSelected" ng-change="onClick()" ng-value="table" class="radio-button"> {{table}}
                </label>
            </div>
        </div>
        <div id="admin_data_table" class="col-md-10">


        </div>

    </div>
</body>
</html>
