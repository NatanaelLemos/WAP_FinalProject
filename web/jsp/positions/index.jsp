<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Positions</title>

    <link href="<c:url value='/resources/vendor/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet" />
    <link href="<c:url value='/resources/vendor/metisMenu/metisMenu.min.css'/>" rel="stylesheet" />
    <link href="<c:url value='/resources/dist/css/sb-admin-2.css'/>" rel="stylesheet" />
    <link href="<c:url value='/resources/vendor/font-awesome/css/font-awesome.min.css'/>" rel="stylesheet" />
    <link href="<c:url value='/resources/vendor/datatables-plugins/dataTables.bootstrap.css'/>" rel="stylesheet" />
    <link href="<c:url value='/resources/vendor/datatables-responsive/dataTables.responsive.css'/>" rel="stylesheet" />
</head>
<body>
<div id="wrapper">
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <a class="navbar-brand" href="home.html">HR Management System</a>
            <img src="../images/logo-Hr.png" alt="logo" style="padding: 10px 10px; height:50px " />
        </div>
        <ul class="nav navbar-top-links navbar-right">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                    </li>
                    <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                    </li>
                </ul>
            </li>
        </ul>
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
                    <li >
                        <a href="home.html"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                    </li>
                    <li>
                        <a href="department.html"><i class="fa fa-institution fa-fw"></i> Departments</a>
                    </li>
                    <li>
                        <a href="employee.html"><i class="fa fa-users fa-fw"></i> Employees</a>
                    </li>
                    <li>
                        <a class="active" href="/positions"><i class="fa fa-briefcase fa-fw"></i> Positions</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Positions</h1>
                </div>
            </div>

            <div class="row">

            </div>
        </div>
    </div>
</div>

<script src="<c:url value='/resources/vendor/jquery/jquery.min.js'/>"></script>
<script src="<c:url value='/resources/vendor/bootstrap/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/resources/vendor/metisMenu/metisMenu.min.js'/>"></script>
<script src="<c:url value='/resources/dist/js/sb-admin-2.js'/>"></script>

<script src="<c:url value='/resources/vendor/datatables/js/jquery.dataTables.min.js'/>"></script>
<script src="<c:url value='/resources/vendor/datatables-plugins/dataTables.bootstrap.js'/>"></script>
<script src="<c:url value='/resources/vendor/datatables-responsive/dataTables.responsive.js'/>"></script>
</body>
</html>