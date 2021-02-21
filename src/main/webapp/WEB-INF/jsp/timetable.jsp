<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<h1>Admin Panel</h1>
<a href="<c:url value="/admin"/>">Go back</a><br>

<table>
    <tr>
        <th>Employee:</th>
        <th>Busy:</th>
    </tr>
    <c:forEach items="${timetables}" var="timetable">
        <tr>
            <td>${timetable.key}</td>
            <td>${timetable.value}</td>
        </tr>
    </c:forEach>
</table>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>