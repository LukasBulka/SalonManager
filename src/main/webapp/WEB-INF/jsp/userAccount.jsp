<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<h1>Welcome to user profile and settings</h1>
<a href="<c:url value="/user/myProfile"/>">My Profile</a>
<a href="<c:url value="/user/editProfile"/>">Edit Profile</a>
<a href="<c:url value="/user/confirmRemoveUserAccount"/>">Delete Account</a>
<a href="<c:url value="/user/servicesList"/>">Services List</a>
<a href="<c:url value="/order/orderService"/>">Order service</a>
<a href="<c:url value="/order/showUsersOrders"/>">My orders</a>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>