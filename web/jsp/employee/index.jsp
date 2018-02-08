<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../partials/head.jsp" />
    <title>Employees</title>
</head>
<body>
<div id="wrapper">
    <jsp:include page="../partials/navbar.jsp">
        <jsp:param name="selected" value="employees" />
    </jsp:include>

    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Employees</h1>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <a class="btn btn-success" href="/employees/new">
                        <i class="fa fa-plus-circle"></i>
                        New employee
                    </a>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <table class="table table-striped table-bordered table-hover" id="positionsTable" data-type="employees">
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Position</th>
                            <th>Department</th>
                            <th>Manager</th>
                            <th>Salary</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="loading hide loading-original">
    &nbsp;
    <img src="<c:url value='/images/loading.gif'/>" alt="Loading" />
</div>

<input id="employeeByDeptId" type="text" value="${requestScope.get('deptId')}">

<jsp:include page="../partials/scripts.jsp" />

<script src="<c:url value='/resources/vendor/datatables/js/jquery.dataTables.min.js'/>"></script>
<script src="<c:url value='/resources/vendor/datatables-plugins/dataTables.bootstrap.js'/>"></script>
<script src="<c:url value='/resources/vendor/datatables-responsive/dataTables.responsive.js'/>"></script>
<script src="<c:url value='/js/positions.js'/>"></script>
</body>
</html>