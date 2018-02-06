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
    <title>Login Page</title>

    <link href="<c:url value='/resources/vendor/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet" />
    <link href="<c:url value='/resources/vendor/metisMenu/metisMenu.min.css'/>" rel="stylesheet" />
    <link href="<c:url value='/resources/dist/css/sb-admin-2.css'/>" rel="stylesheet" />
    <link href="<c:url value='/resources/vendor/font-awesome/css/font-awesome.min.css'/>" rel="stylesheet" />
</head>
<body>

<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0; background-color:#5cb85c">
    <div class="navbar-header">

        <span class="navbar-brand" style="color:#0b175a">HR Management System</span>
        <img src="../images/logo-Hr.png" alt="logo" style="padding: 10px 10px; height:50px " />
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading" style="background-color:#5cb85c">
                    <h3 class="panel-title">Please Sign In</h3>
                </div>
                <div class="panel-body">
                    <form role="form">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="E-mail" name="email" type="email" autofocus>
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Password" name="password" type="password" value="">
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                </label>
                            </div>
                            <a href="index.html" class="btn btn-lg btn-success btn-block">Login</a>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="<c:url value='/resources/vendor/jquery/jquery.min.js'/>"></script>
<script src="<c:url value='/resources/vendor/bootstrap/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/resources/vendor/metisMenu/metisMenu.min.js'/>"></script>
<script src="<c:url value='/resources/dist/js/sb-admin-2.js'/>"></script>
</body>
</html>