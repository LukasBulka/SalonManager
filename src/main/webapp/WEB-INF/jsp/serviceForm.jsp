<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<h1>Add service</h1>
<a href="<c:url value="/admin"/>">Go back</a>
<form:form method="post" modelAttribute="myService">

    Name:
    <form:errors path="name" cssClass="error"/><br>
    <form:input path="name"/><br>
    <br>
    Price:
    <form:errors path="price" cssClass="error"/><br>
    <label>
        <input type="number" min="0" value="0" name="price" path="price"/>
    </label><br>
    <br>
    <br>
    Currency:
    <form:errors path="currency" cssClass="error"/><br>
    <form:radiobuttons items="${currency}" path="currency" /><br>
    <br>
    <input type="submit" value="Add service"/>
</form:form><br>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>