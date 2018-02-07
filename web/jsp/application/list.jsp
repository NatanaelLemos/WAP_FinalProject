<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../partials/head.jsp" />
    <title>Applications</title>
</head>
<body>
<div id="wrapper">
    <jsp:include page="../partials/navbar.jsp">
        <jsp:param name="selected" value="applications" />
    </jsp:include>

    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Applications</h1>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <table width="100%" class="table table-striped table-bordered table-hover" id="applicationsTable">
                        <thead>
                        <tr>
                            <th>Position</th>
                            <th>Applicant</th>
                            <th>Status</th>
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

<jsp:include page="../partials/scripts.jsp" />

<script>
    const userRole = '${sessionScope.get("role").toString()}';
</script>
<script src="<c:url value='/resources/vendor/datatables/js/jquery.dataTables.min.js'/>"></script>
<script src="<c:url value='/resources/vendor/datatables-plugins/dataTables.bootstrap.js'/>"></script>
<script src="<c:url value='/resources/vendor/datatables-responsive/dataTables.responsive.js'/>"></script>
<script src="<c:url value='/js/applications.js'/>"></script>
</body>
</html>