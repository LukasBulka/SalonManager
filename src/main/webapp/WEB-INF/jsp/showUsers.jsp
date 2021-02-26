<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/administration.jsp" %>

<%--        Main--%>
<main role="main" class="col-md-10 ml-sm-auto px-4">
    <h4 style="color: goldenrod">Users list</h4>
    <div class="form-group">
        <form method="get" action="/admin/showFilteredUsers">
            Select role to filter:<br>
            <input type="checkbox" name="options" value="ADMIN"> Admin
            <input type="checkbox" name="options" value="EMPLOYEE"> Employee
            <input type="checkbox" name="options" value="USER"> User
            <input class="action" type="submit" value="Search">
        </form>
    </div>
    <a href="<c:url value="/admin/addUser"/>">
        <button class="action">Add user</button>
    </a>
    <div class="table table-striped">
        <table class="table table-sm">
            <thead>
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
                    <a href="<c:url value="/admin/updateUser/${user.id}"/>">
                        <button class="action">Update</button>
                    </a>
                    <a href="<c:url value="/admin/confirmRemoveUser/${user.id}"/>">
                        <button class="action">Delete</button>
                    </a>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</main>
</div>
</div>