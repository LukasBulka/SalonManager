<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<h3>Edit User by Admin</h3>
<a href="<c:url value="/admin"/>">Go back</a>
<form:form method="post" modelAttribute="user">
    First name:
    <form:errors path="firstName" cssClass="error"/><br>
    <form:input path="firstName"/>
    <br>
    Last name:
    <form:errors path="lastName" cssClass="error"/><br>
    <form:input path="lastName"/>
    <br>
    Email:
    <form:errors path="email" cssClass="error"/><br>
    <form:input path="email"/>
    <br>
    New password:
    <form:errors path="password" cssClass="error"/><br>
    <form:password path="password"/>
    <br>
    Role:
    <form:errors path="roles" cssClass="error"/><br>
    <form:checkboxes items="${roles}" path="roles" /><br>
    <br>
    Active:
    <form:errors path="active" cssClass="error"/><br>
    <form:radiobuttons items="${active}" path="active" /><br>
    <br>
    <input type="submit" value="Update user"/>
</form:form>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>