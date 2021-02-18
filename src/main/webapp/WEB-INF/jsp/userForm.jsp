<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<h1>Add user</h1>
<a href="<c:url value="/admin"/>">Go back</a>
<form:form method="post" modelAttribute="user">

    First name:<br>
    <form:input path="firstName"/><br>
    <br>
    Last name:<br>
    <form:input path="lastName"/><br>
    <br>
    Email:<br>
    <form:input path="email"/><br>
    <br>
    Password:<br>
    <form:password path="password"/><br>
    <br>
    Role:<br>
    <form:checkboxes items="${roles}" path="roles" /><br>
    <br>
    Active:<br>
    <form:radiobuttons items="${active}" path="active" /><br>
    <input type="submit" value="Add user"/>
</form:form><br>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>