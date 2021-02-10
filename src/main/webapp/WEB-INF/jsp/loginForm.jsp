<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<h1>Login form</h1>
<form method="post">
    Email :<br>
    <input type="text" name="username"/><br>
    Password:<br>
    <input type="password" name="password"/> <br>
    <br>
    <input type="submit" value="Log In"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>