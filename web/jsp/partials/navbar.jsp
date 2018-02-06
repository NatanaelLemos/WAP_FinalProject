<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
        <a class="navbar-brand" href="home.html">HR Management System</a>
        <img src="../../images/logo-Hr.png" alt="logo" style="padding: 10px 10px; height:50px " />
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
                <li >
                    <a class="${selected == 'home' ? 'active' : '' }" href="/home"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                </li>
                <li>
                    <a class="${selected == 'departments' ? 'active' : '' }" href="department.html"><i class="fa fa-institution fa-fw"></i> Departments</a>
                </li>
                <li>
                    <a class="${selected == 'employees' ? 'active' : '' }" href="employee.html"><i class="fa fa-users fa-fw"></i> Employees</a>
                </li>
                <li>
                    <a class="${selected == 'positions' ? 'active' : '' }" href="/positions"><i class="fa fa-briefcase fa-fw"></i> Positions</a>
                </li>
            </ul>
        </div>
    </div>
</nav>