<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<h1>Admin Panel</h1>
<a href="<c:url value="/admin/showUsers"/>">Users</a>
<a href="<c:url value="/admin/addEmployee"/>">Employees</a>
<a href="<c:url value="/admin/showServices"/>">Services</a>
<a href="<c:url value="/admin/showTimetable"/>">Timetable</a>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>