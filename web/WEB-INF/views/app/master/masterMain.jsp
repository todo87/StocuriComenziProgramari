<%@ include file="/WEB-INF/views/app/master/head.jspf" %>
<script content="text/javascript" src="/res/custom_script/master/masterMain.js"></script>
    <div>
        <div id="divChkListOfTables" class="admin_left_menu pre-scrollable col-md-2">
            <div id="chkListOfTables" class="admin_tables_list radio">
                <h4>Tables</h4>
                <label ng-repeat="table in listOfTables.tables" class="admin_tables_list_chk_box">
                    <input type="radio" name="chkTablesRadio" ng-model="$parent.valueSelected" ng-change="onClick()"
                           ng-value="table" class="radio-button"> {{table}}
                </label>
            </div>
        </div>
        <div id="admin_data_table" class="col-md-10">

            <%--<table datatable="" dt-options="masterMainController.dtOptions" dt-columns="masterMainController.dtColumns" class="row-border hover"></table>--%>

                <div ui-grid="{ data: tableData }" class="ui-grid"></div>

        </div>
    </div>
<%@ include file="/WEB-INF/views/app/master/footer.jspf" %>