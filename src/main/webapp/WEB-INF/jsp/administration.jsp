<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%--        Sidebar--%>
        <div class="col-md-2 bg-light d-none d-md-block sidebar">
            <div class="left-sidebar">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <h4>Administration</h4>
                        <hr>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/admin/showUsers"/>">Users</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/admin/addEmployee"/>">Employees</a>
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