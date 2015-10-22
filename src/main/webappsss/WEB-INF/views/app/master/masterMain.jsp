<%@ include file="/WEB-INF/views/app/master/head.jspf" %>
<script content="text/javascript" src="/res/custom_script/master/masterMain.js"></script>

<style>
    a, button {
        font: 14px 'Helvetica Neue', 'Helvetica', 'Arial', sans-serif;
        display: block;
        color: #333;
        margin-bottom: 10px;
    }

    /* The following 'important' styles are just here to show off trapFocus */
    button.ngdialog-button {
        border: solid transparent 1px !important;
    }

    button.ngdialog-button:focus {
        border: solid black 1px !important;
    }

    .ngdialog h2:focus { outline: none; }

    button.inline {
        display: inline
    }
</style>

<div class="row">
    <div class="col-md-1">
        <div id="divChkListOfTables" class="admin_left_menu pre-scrollable">
            <div id="chkListOfTables" class="admin_tables_list radio">
                <h4>Tables</h4>
                <label ng-repeat="table in listOfTables" class="admin_tables_list_chk_box">
                    <input type="radio" name="chkTablesRadio" ng-model="$parent.selectedTable" ng-change="onClick()"
                           ng-value="table" class="radio-button"> {{table}}
                </label>
            </div>
        </div>
        <button type="button" class="btn btn-primary" ng-click="addPopUp()">Add {{selectedTable}}</button>
    </div>


    <div id="admin_data_table" class="col-md-11 no_left_padding height_30">
        <%--
                    <div id="grid1" ui-grid="{ columnDefs:tableHeads, data: tableData }"></div>
        --%>
        <div id="grid1" ui-grid="gridOptions"></div>
    </div>
</div>

<script type="text/ng-template" id="dialogWithNestedConfirmDialogId">
    <div class="ngdialog-message">
        <h3>ngDialog template</h3>

        <p>Dialog containing work in which a user has to perform a task (e.g. editing data).</p>

        <p>'Save' would save the task's actions, while 'Cancel' would cause the task's actions to be lost.</p>

        <p>...other controls here...</p>
    </div>
    <div class="ngdialog-buttons">
        <button type="button" class="ngdialog-button ngdialog-button-secondary" ng-click="closeThisDialog('Cancel')">
            Cancel
        </button>
        <button type="button" class="ngdialog-button ngdialog-button-primary" ng-click="confirm('Save')">Save</button>
    </div>
</script>



<%@ include file="/WEB-INF/views/app/master/footer.jspf" %>