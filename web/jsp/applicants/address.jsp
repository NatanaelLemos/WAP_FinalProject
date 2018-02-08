<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../partials/head.jsp" />
    <title>Register your address</title>
</head>
<body>
<div id="wrapper">
    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Register your address</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <form action="/applicants/address" method="post" autocomplete="off">
                        <input type="hidden" id="id" name="id" value="${id}" />

                        <div class="form-group">
                            <label for="streetAddress1">Street address 1</label>
                            <input type="text" class="form-control" id="streetAddress1" name="streetAddress1" placeholder="Street address 1" required  />
                        </div>
                        <div class="form-group">
                            <label for="streetAddress2">Street address 2</label>
                            <input type="text" class="form-control" id="streetAddress2" name="streetAddress2" placeholder="Street address 2"  />
                        </div>
                        <div class="form-group">
                            <label for="city">City</label>
                            <input type="text" class="form-control city" id="city" name="city" placeholder="City" required />
                        </div>
                        <div class="form-group">
                            <label for="state">State</label>
                            <input type="text" class="form-control state" id="state" name="state" placeholder="State" required />
                        </div>
                        <div class="form-group">
                                <label for="zip">Zip code</label>
                                <input type="text" class="form-control zip" id="zip" name="zip" placeholder="Zip" required />
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