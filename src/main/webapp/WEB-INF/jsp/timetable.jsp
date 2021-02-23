<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<h1>Timetable</h1>
<sec:authorize access="hasRole('EMPLOYEE')">
    <a href="<c:url value="/employee"/>">Go back</a>
</sec:authorize>
<sec:authorize access="hasRole('ADMIN')">
    <a href="<c:url value="/admin"/>">Go back</a>
</sec:authorize>
<br/>
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