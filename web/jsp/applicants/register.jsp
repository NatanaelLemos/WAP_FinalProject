<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../partials/head.jsp" />
    <title>Register as applicant</title>
</head>
<body>
<div id="wrapper">
    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Register as applicant</h1>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <form action="/applicants/register" method="post" autocomplete="off">
                        <div class="form-group">
                            <label for="name">Name</label>
                            <input type="text" class="form-control username" id="name" name="name" placeholder="Name" required />
                        </div>
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" class="form-control email" id="email" name="email" placeholder="Email" required  />
                        </div>
                        <div class="form-group">
                            <label for="phone">Phone number</label>
                            <input type="text" class="form-control phone" id="phone" name="phone" required />
                        </div>
                        <div class="form-group">
                            <label for="birthdate">Birthdate</label>
                            <div class='input-group date' id='datetimepickerStart'>
                                <input type='Date' class="form-control" name="birthdate" id="birthdate" required />
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                            </div>
                        </div>

                        <button type="submit" class="btn btn-primary">Register</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../partials/scripts.jsp" />
</body>
</html>