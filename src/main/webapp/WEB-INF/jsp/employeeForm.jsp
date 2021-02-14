<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<h1>Add employee</h1>

<form:form method="post" modelAttribute="employee">

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
    <form:select path="roles" items="${roles}"/>
<%--        <form:option value="-" label="--Select Role--"/>--%>
<%--        <form:options items="${roles}"/>--%>
<%--    </form:select><br>--%>
    <br>
    <input type="submit" value="Add employee"/>
</form:form>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>