<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="partials/head.jsp" />
    <title>Home Page</title>
</head>
<body>
<div id="wrapper">
    <jsp:include page="partials/navbar.jsp">
        <jsp:param name="selected" value="home" />
    </jsp:include>

    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Welcome</h1>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="partials/scripts.jsp" />
</body>
</html>