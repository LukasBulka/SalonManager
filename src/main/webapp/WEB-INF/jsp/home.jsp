<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<h1>Home page</h1>
<c:if test="${not empty param.success}">
    <p>Account has been successfully deleted</p>
</c:if>
<c:if test="${not empty param.loginSuccess}">
    <p>Successfully logged in</p>
</c:if>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>