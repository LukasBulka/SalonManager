<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<h1>My profile</h1>
<a href="<c:url value="/user"/>">Go back</a>
<form:form method="post" modelAttribute="user">
    FIRST NAME:
    <form:input path="firstName"/><form:errors path="firstName" cssClass="error"/><br>
    <br>
    LAST NAME:
    <form:input path="lastName"/><form:errors path="lastName" cssClass="error"/><br>
    <br>
    EMAIL:
    <form:input path="email"/><form:errors path="email" cssClass="error"/><br>
    <br>
    NEW PASSWORD:
    <form:password path="password"/><form:errors path="password" cssClass="error"/><br>
    <br>
    <input type="submit" value="Save"/>
</form:form>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>