<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<h1>Admin Panel</h1>
<h3>Employees list</h3>
<a href="<c:url value="/admin"/>">Go back</a>

<table>
    <tr>
        <th>Id</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Email</th>
        <th>Password</th>
        <th>Active</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.password}</td>
            <td>${user.active}</td>
            <td>
                <ul>
                    <li><a href="/admin/add">Add</a></li>
                    <li><a href="/admin/update/${user.id}">Update</a></li>
                    <li><a href="/admin/remove/${user.id}">Delete</a></li>
                </ul>
            </td>
        </tr>
    </c:forEach>
</table>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>