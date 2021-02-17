<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<h1>Update service</h1>
<a href="<c:url value="/admin"/>">Go back</a>
<form:form method="post" modelAttribute="service">

    Name:<br>
    <form:input path="name"/><br>
    <br>
    Price:<br>
    <form:input path="price"/><br>
    <br>
    Currency:<br>
    <form:radiobuttons items="${currency}" path="currency" /><br>
    <br>
    <input type="submit" value="Add service"/>
</form:form><br>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>