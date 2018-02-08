<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../partials/head.jsp"/>
    <title>Edit Employee</title>
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
                    <h1 class="page-header">Edit employee</h1>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <input type="hidden" id="selectedPosition" value="${employeeInstance.position.id}"/>
                    <input type="hidden" id="selectedManager" value="${employeeInstance.manager!=null ? employeeInstance.manager.id:0}"/>
                    <input type="hidden" id="selectedDepartment" value="${employeeInstance.department.id}"/>
                    <input type="hidden" id="isSetActive" value="${employeeInstance.active}">
                    <form action="/employees/edit" method="post">
                        <input type="hidden" name="employeeId" value="${employeeInstance.id}">
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
                                            <input  name="dateStart" type='Date' class="form-control" value="${employeeInstance.hireDate != null ? formatter.format(employeeInstance.hireDate):'' }" />
                                            <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-calendar"></span>
                                            </span>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="datetimepickerEnd">Termination Date</label>
                                        <div class='input-group date' id='datetimepickerEnd'>
                                            <input type='Date' class="form-control" name="dateEnd" value="${employeeInstance.fireDate != null ? formatter.format(employeeInstance.fireDate):'' }" />
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
                                            <input id="salary" name="salary" type="text" class="form-control currency" value="${employeeInstance.currentSalary}" >
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
                                        <input type="text" class="form-control name" id="name" name="name" placeholder="Name" required  value="${employeeInstance.name}" />
                                    </div>
                                    <div class="form-group">
                                        <label for="email">Email</label>
                                        <input type="email" class="form-control email" id="email" name="email" placeholder="Email" required value="${employeeInstance.email}"  />
                                    </div>
                                    <div class="form-group">
                                        <label for="homePhone">Home Phone</label>
                                        <input type="text" class="form-control phone" id="homePhone" name="homePhone" placeholder="Home Phone" required value="${employeeInstance.phone}" />
                                    </div>
                                    <div class="form-group">
                                      <label for="cellPhone">Cell Phone</label>
                                        <input type="text" class="form-control phone" id="cellPhone" name="cellPhone" placeholder="Cell Phone" required value="${employeeInstance.cellPhone}" />
                                    </div>
                                    <div class="form-group">
                                         <label>Home Address</label>
                                         <div class="row">
                                             <div class="col-md-3" >
                                                 <input type="text" class="form-control state" id="stateHome" name="stateHome" placeholder="State" required value="${employeeInstance.address.state}"  />
                                             </div>
                                             <div class="col-md-3">
                                                 <input type="text" class="form-control city" id="cityHome" name="cityHome" placeholder="City" required value="${employeeInstance.address.city}" />
                                             </div>
                                             <div class="col-md-2">
                                                 <input type="text" class="form-control zip" id="zipHome" name="zipHome" placeholder="Zip Code" required value="${employeeInstance.address.zipCode}"  />
                                             </div>
                                             <div class="col-md-4">
                                                 <input type="text" class="form-control" id="streetHome" name="streetHome" placeholder="Street" required value="${employeeInstance.address.streetAddress1}" />
                                             </div>
                                         </div>
                                    </div>
                                    <div class="form-group">
                                             <label>Mailing Address</label>
                                             <div class="row">
                                                 <div class="col-md-3" >
                                                     <input type="text" class="form-control state" id="stateMail" name="stateMail" placeholder="State" required value="${employeeInstance.mailAddress.state}" />
                                                 </div>
                                                 <div class="col-md-3">
                                                     <input type="text" class="form-control city" id="cityMail" name="cityMail" placeholder="City" required value="${employeeInstance.mailAddress.city}" />
                                                 </div>
                                                 <div class="col-md-2">
                                                     <input type="text" class="form-control zip" id="zipMail" name="zipMail" placeholder="Zip Code" required value="${employeeInstance.mailAddress.zipCode}" />
                                                 </div>
                                                 <div class="col-md-4">
                                                     <input type="text" class="form-control" id="streetMail" name="streetMail" placeholder="Street" required value="${employeeInstance.mailAddress.streetAddress1}" />
                                                 </div>
                                             </div>
                                    </div>
                                         <div class="form-group">
                                             <label for="datetimepickerBirth">Birthdate</label>
                                             <div class='input-group date' id='datetimepickerBirth'>
                                                 <input type='Date' class="form-control"  name="dateBirth" value="${employeeInstance.birthdate != null ? formatter.format(employeeInstance.birthdate):'' }" />
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
                            <button type="submit" class="btn btn-primary">Update</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../partials/scripts.jsp"/>
<script>
    $(function(){
        $("#position").val($("#selectedPosition").val());
        $("#manager").val($("#selectedManager").val());
        $("#department").val($("#selectedDepartment").val());
        if($("#isSetActive").val()=="false"){
            $("#isActive").removeAttr("checked");
        }

    })
</script>
</body>
</html>