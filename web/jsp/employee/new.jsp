<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../partials/head.jsp"/>
    <title>New Employee</title>
</head>
<body>
<div id="wrapper">
    <jsp:include page="../partials/navbar.jsp">
        <jsp:param name="selected" value="employees"/>
    </jsp:include>

    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Create a new employee</h1>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <form action="/employees/new" method="post">
                        <div class="col-lg-6">
                            <div class="panel panel-green">
                                <div class="panel-heading">
                                    Company Information
                                </div>
                                <div class="panel-body">
                                    <div class="form-group">
                                        <label for="position">Position</label>
                                        <select id="position" name="postionId" class="form-control">
                                            <c:forEach items="${positions}" var="position">
                                                <option value="${position.id}">${position.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="department">Department</label>
                                        <select id="department" name="departmentId" class="form-control">
                                            <c:forEach items="${departments}" var="department">
                                                <option value="${department.id}">${department.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="isActive"> Is Active :
                                            <input id="isActive" name="isActive" type="checkbox" checked="checked">
                                        </label>
                                    </div>
                                    <div class="form-group">
                                        <label for="datetimepickerStart">Hire Date</label>
                                        <div class='input-group date' id='datetimepickerStart'>
                                            <input type='Date' class="form-control" name="dateStart" />
                                            <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-calendar"></span>
                                            </span>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="datetimepickerEnd">Termination Date</label>
                                        <div class='input-group date' id='datetimepickerEnd'>
                                            <input type='Date' class="form-control" name="dateEnd" />
                                            <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-calendar"></span>
                                            </span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="manager">Manager</label>
                                        <select id="manager" name="managerId" class="form-control">
                                            <option value="0"></option>
                                            <c:forEach items="${employees}" var="employee">
                                                <option value="${employee.id}">${employee.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="salary">Salary</label>
                                        <div class="input-group">
                                            <span class="input-group-addon">$</i>
                                            </span>
                                            <input id="salary" name="salary" type="text" class="form-control currency" >
                                        </div>
                                    </div>
                                </div>
                                <div class="panel-footer">

                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="panel panel-yellow">
                                <div class="panel-heading">
                                    Personal Information
                                </div>
                                <div class="panel-body">
                                    <div class="form-group">
                                        <label for="name">Name</label>
                                        <input type="text" class="form-control username" id="name" name="name" placeholder="Name" required  />
                                    </div>
                                    <div class="form-group">
                                        <label for="email">Email</label>
                                        <input type="email" class="form-control email" id="email" name="email" placeholder="Email" required  />
                                    </div>
                                    <div class="form-group">
                                        <label for="homePhone">Home Phone</label>
                                        <input type="text" class="form-control phone" id="homePhone" name="homePhone" placeholder="Home Phone" required  />
                                    </div>
                                    <div class="form-group">
                                        <label for="cellPhone">Cell Phone</label>
                                        <input type="text" class="form-control phone" id="cellPhone" name="cellPhone" placeholder="Cell Phone" required  />
                                    </div>
                                    <div class="form-group">
                                        <label>Home Address</label>
                                        <div class="row">
                                            <div class="col-md-3" >
                                                <input type="text" class="form-control state" id="stateHome" name="stateHome" placeholder="State" required  />
                                            </div>
                                            <div class="col-md-3">
                                                <input type="text" class="form-control city" id="cityHome" name="cityHome" placeholder="City" required  />
                                            </div>
                                            <div class="col-md-2">
                                                <input type="text" class="form-control zip" id="zipHome" name="zipHome" placeholder="Zip Code" required  />
                                            </div>
                                            <div class="col-md-4">
                                                <input type="text" class="form-control" id="streetHome" name="streetHome" placeholder="Street" required  />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>Mailing Address</label>
                                        <div class="row">
                                            <div class="col-md-3" >
                                                <input type="text" class="form-control state" id="stateMail" name="stateMail" placeholder="State" required  />
                                            </div>
                                            <div class="col-md-3">
                                                <input type="text" class="form-control city" id="cityMail" name="cityMail" placeholder="City" required  />
                                            </div>
                                            <div class="col-md-2">
                                                <input type="text" class="form-control zip" id="zipMail" name="zipMail" placeholder="Zip Code" required  />
                                            </div>
                                            <div class="col-md-4">
                                                <input type="text" class="form-control" id="streetMail" name="streetMail" placeholder="Street" required  />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="datetimepickerBirth">Birthdate</label>
                                        <div class='input-group date' id='datetimepickerBirth'>
                                            <input type='Date' class="form-control"  name="dateBirth" />
                                            <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-calendar"></span>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel-footer">

                                </div>
                            </div>
                        </div>
                        <div class="col-lg-12">
                            <button type="submit" class="btn btn-primary">Create</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../partials/scripts.jsp"/>
</body>
</html>