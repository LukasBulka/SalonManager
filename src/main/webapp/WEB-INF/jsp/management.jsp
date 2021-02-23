<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<h1>Employee Panel</h1>
<a href="<c:url value="/user/myProfile"/>">My Profile</a>
<a href="<c:url value="/user/editProfile"/>">Edit Profile</a>
<a href="<c:url value="/myService/showServices"/>">Services</a>
<a href="<c:url value="/order/showOrders"/>">Orders</a>
<a href="<c:url value="/admin/showTimetable"/>">Timetable</a>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>