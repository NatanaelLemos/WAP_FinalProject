<%@ page import="web.viewmodels.UserRole" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
        <a class="navbar-brand" href="/home">HR Management System</a>
        <img src="../../images/logo-Hr.png" alt="logo" style="padding: 10px 10px; height:50px "/>
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
                <li><a href="/logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                </li>
            </ul>
        </li>
    </ul>
    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">
                <c:if test="${sessionScope.get('role') != UserRole.JOB_APPLICANT}">
                    <li>
                        <a class="${selected == 'home' ? 'active' : '' }" href="/home"><i
                                class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                    </li>
                    <li>
                        <a class="${selected == 'departments' ? 'active' : '' }" href="/departments"><i
                                class="fa fa-institution fa-fw"></i> Departments</a>
                    </li>
                    <li>
                        <a class="${selected == 'employees' ? 'active' : '' }" href="/employees"><i
                                class="fa fa-users fa-fw"></i> Employees</a>
                    </li>
                    <li>
                        <a class="${selected == 'positions' ? 'active' : '' }" href="/positions"><i
                                class="fa fa-briefcase fa-fw"></i> Positions</a>
                    </li>
                </c:if>
                <li>
                    <a class="${selected == 'application' ? 'active' : '' }" href="/application"><i
                            class="fa fa-align-justify fa-fw"></i> Job Vacancies</a>
                </li>
                <li>
                    <a class="${selected == 'applications' ? 'active' : '' }" href="/applications"><i
                            class="fa fa-edit fa-fw"></i> Applications</a>
                </li>
            </ul>
        </div>
    </div>
</nav>