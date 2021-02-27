<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%--        Sidebar--%>
        <div class="col-md-2 bg-light d-none d-md-block sidebar">
            <div class="left-sidebar">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <h4>Management</h4>
                        <hr>
                        <h6>
                            <sec:authorize access="isAuthenticated()">
                                <p>User: <sec:authentication property="principal.username"/></p>
                            </sec:authorize>
                        </h6>
                        <hr>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/user/myProfile"/>">My Profile</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/user/editProfile"/>">Edit Profile</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/myService/showServices"/>">Services</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/order/showOrders"/>">Orders</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/timetable/showTimetable"/>">Timetable</a>
                    </li>
                </ul>
            </div>
        </div>