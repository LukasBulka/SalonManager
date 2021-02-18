<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<h1>Login form</h1>
<form method="post" action="/authentication/login">

    <c:if test="${not empty param.success}">
        <p>Logged in</p>
    </c:if>

    <c:if test="${not empty param.error}">
        <p class="error">Invalid email or password</p><br>
    </c:if>

    Email :<br>
    <input type="text" name="email"/><br>

    Password:<br>
    <input type="password" name="password"/> <br>

    <br>
    <input type="submit" value="Log In"/>

    <span>New user? <a href="<c:url value="/authentication/registration"/>">Sign in here</a></span>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>