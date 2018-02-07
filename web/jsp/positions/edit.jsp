<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../partials/head.jsp"/>
    <title>Edit Position</title>
</head>
<body>
<div id="wrapper">
    <jsp:include page="../partials/navbar.jsp">
        <jsp:param name="selected" value="positions"/>
    </jsp:include>

    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Edit position</h1>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <form action="/positions/edit" method="post">
                        <input type="hidden" name="id" id="id" value="${position.id}" />

                        <div class="form-group">
                            <label for="name">Name</label>
                            <input type="text" class="form-control" id="name" name="name" placeholder="Name" required  value="${position.name}"/>
                        </div>
                        <div class="form-group">
                            <label for="description">Description</label>
                            <textarea class="form-control" id="description" name="description" placeholder="Description" required cols="80" rows="3"><c:out value="${position.description}" /></textarea>
                        </div>
                        <div class="form-check">
                            <c:if test="${position.openPosition == 'Open'}">
                                <input class="form-check-input" type="checkbox" id="openPosition" name="openPosition" value="true" checked />
                            </c:if>
                            <c:if test="${position.openPosition != 'Open'}">
                                <input class="form-check-input" type="checkbox" id="openPosition" name="openPosition" value="true" />
                            </c:if>
                            <label class="form-check-label" for="openPosition">Is open position?</label>
                        </div>

                        <button type="submit" class="btn btn-primary">Create</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../partials/scripts.jsp"/>
</body>
</html>