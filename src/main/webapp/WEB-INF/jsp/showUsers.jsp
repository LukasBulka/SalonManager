<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<h1>Admin Panel</h1>
<h3>User list</h3>
<a href="<c:url value="/admin"/>">Go back</a>
<br>
<br>
<form method="get" action="/admin/showFilteredUsers">
    Select role to filter:<br>
    <input type="checkbox" name="options" value="ADMIN">by Admin
    <input type="checkbox" name="options" value="EMPLOYEE">by Employee
    <input type="checkbox" name="options" value="USER">by User
    <input type="submit" value="Search">
</form>

<br>
<a href="<c:url value="/admin/addUser"/>">Add new user</a><br>
<br>
<table>
    <tr>
        <th>Id</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Email</th>
        <th>Roles</th>
        <th>Active</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.roles}</td>
            <td>${user.active}</td>
            <td>
                <a href="/admin/updateUser/${user.id}">Update</a><br>
                <a href="/admin/confirmRemoveUser/${user.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>