<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<h3>Edit User by Admin</h3>
<a href="<c:url value="/admin"/>">Go back</a>
<form:form method="post" modelAttribute="user">
    First name:<br>
    <form:input path="firstName"/><form:errors path="firstName" cssClass="error"/><br>
    <br>
    Last name:<br>
    <form:input path="lastName"/><form:errors path="lastName" cssClass="error"/><br>
    <br>
    Email:<br>
    <form:input path="email"/><form:errors path="email" cssClass="error"/><br>
    <br>
    New password:<br>
    <form:password path="password"/><form:errors path="password" cssClass="error"/><br>
    <br>
    Role:<br>
    <form:checkboxes items="${roles}" path="roles" /><br>
    <br>
    Active:<br>
    <form:radiobuttons items="${active}" path="active" /><br>
    <br>
    <input type="submit" value="Update"/>
</form:form>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>