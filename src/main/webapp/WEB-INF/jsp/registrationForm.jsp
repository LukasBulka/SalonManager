<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<h1>Registration</h1>
<c:if test="${not empty param.success}">
    <p>Successfully registered</p>
</c:if>
<form:form method="post" modelAttribute="user">

    First name:
    <form:errors path="firstName" cssClass="error"/><br>
    <form:input path="firstName"/><br>
    <br>
    Last name:
    <form:errors path="lastName" cssClass="error"/><br>
    <form:input path="lastName"/><br>
    <br>
    Email:
    <form:errors path="email" cssClass="error"/><br>
    <form:input path="email"/><br>
    <br>
    Password:
    <form:errors path="password" cssClass="error"/><br>
    <form:password path="password"/><br>
    <br>
    <input type="submit" value="Sign in"/>
    <span>Already registered? <a href="<c:url value="/authentication/login"/>">Log in here</a></span>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form:form>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>