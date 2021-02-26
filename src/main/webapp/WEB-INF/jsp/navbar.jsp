<nav class="navbar navbar-expand-md">
    <a class="navbar-brand" href="#">salonManager</a>
    <button class="navbar-toggler navbar-dark" type="button" data-toggle="collapse" data-target="#main-navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="main-navigation">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/"/>">HOME</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/about"/>">About</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/price"/>">Price list</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/contact"/>">Contact</a>
            </li>
            <li class="nav-item">
                <sec:authorize access="hasRole('USER')">
                    <a class="nav-link" id="userAccount" href="<c:url value="/userAccount"/>">User Account</a>
                </sec:authorize>
            </li>
            <li class="nav-item">
                <sec:authorize access="hasRole('ADMIN')">
                    <a class="nav-link" id="administration" href="<c:url value="/administration"/>">Administration</a>
                </sec:authorize>
            </li>
            <li class="nav-item">
                <sec:authorize access="hasRole('EMPLOYEE')">
                    <a class="nav-link" id="management" href="<c:url value="/management"/>">Management</a>
                </sec:authorize>
            </li>
            <li class="nav-item">
                <sec:authorize access="hasRole('ADMIN')">
                    <a class="nav-link" id="management" href="<c:url value="/management"/>">Management</a>
                </sec:authorize>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="signin" href="<c:url value="/register"/>">Sign in</a>
            </li>
            <li class="nav-item">
                <sec:authorize access="!isAuthenticated()">
                    <a class="nav-link" id="login" href="<c:url value="/login"/>">Log in</a>
                </sec:authorize>
            </li>
            <li class="nav-item">
                <sec:authorize access="isAuthenticated()">
                    <a class="nav-link" id="logout" href="<c:url value="/logout"/>">Log out</a>
                </sec:authorize>
            </li>
        </ul>
    </div>
</nav>