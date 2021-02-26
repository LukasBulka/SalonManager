<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%--        Sidebar--%>
        <div class="col-md-2 bg-light d-none d-md-block sidebar">
            <div class="left-sidebar">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <h4>User Account</h4>
                        <hr>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/user/myProfile"/>">My Profile</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/user/editProfile"/>">Edit Profile</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/user/confirmRemoveUserAccount"/>">Delete Account</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/myService/showServices"/>">Services List</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/order/orderService"/>">Order service</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/order/showUsersOrders"/>">My orders</a>
                    </li>
                </ul>
            </div>
        </div>