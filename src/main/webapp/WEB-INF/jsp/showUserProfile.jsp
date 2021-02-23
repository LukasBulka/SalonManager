<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<h1>My profile</h1>
<sec:authorize access="hasRole('USER')">
    <a href="<c:url value="/user"/>">Go back</a>
</sec:authorize>
<sec:authorize access="hasRole('EMPLOYEE')">
    <a href="<c:url value="/employee"/>">Go back</a>
</sec:authorize>


<table>
    <tr>
        <th>First name:</th>
        <td>${user.firstName}</td>
    </tr>
    <tr>
        <th>Last name:</th>
        <td>${user.lastName}</td>
    </tr>
    <tr>
        <th>Email:</th>
        <td>${user.email}</td>
    </tr>
    <tr>
        <th>Roles</th>
        <td>${user.roles}</td>
    </tr>
    <tr>
        <th>Permissions</th>
        <td>${user.permissions}</td>
    </tr>
    <tr>
        <th>Active</th>
        <td>${user.active}</td>
    </tr>
</table>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>