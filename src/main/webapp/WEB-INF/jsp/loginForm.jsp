<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<h1>Login form</h1>
<c:if test="${not empty param.success}">
    <p>Logged in</p>
</c:if>
<form method="post">
    Email :<br>
    <input type="text" name="email"/><br>
    Password:<br>
    <input type="password" name="password"/> <br>
    <br>
    <input type="submit" value="Log In"/>
    <span>New user? <a href="<c:url value="/users/registration"/>">Sign in here</a></span>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>