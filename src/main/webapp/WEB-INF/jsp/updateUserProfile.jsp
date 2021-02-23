<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<h1>My profile - update</h1>
<sec:authorize access="hasRole('USER')">
    <a href="<c:url value="/user"/>">Go back</a>
</sec:authorize>
<sec:authorize access="hasRole('EMPLOYEE')">
    <a href="<c:url value="/employee"/>">Go back</a>
</sec:authorize>
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
    <input type="submit" value="Update"/>
</form:form>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>