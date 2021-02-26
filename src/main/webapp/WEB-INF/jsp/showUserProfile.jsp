<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<sec:authorize access="hasRole('EMPLOYEE')">
    <%@ include file="/WEB-INF/jsp/management.jsp" %>
</sec:authorize>
<sec:authorize access="hasRole('USER')">
    <%@ include file="/WEB-INF/jsp/userAccount.jsp" %>
</sec:authorize>

<%--        Main--%>
<main role="main" class="col-md-10 ml-sm-auto px-4">
    <h4 style="color: goldenrod">User profile</h4>
    <div class="table table-striped">
        <table class="table table-sm">
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
    </div>
</main>
</div>
</div>