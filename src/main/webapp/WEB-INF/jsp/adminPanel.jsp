<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<sec:authorize access="hasRole('ADMIN')">
    <h1>Admin Panel</h1>
    <h3>MAM ROLE ADMIN</h3>
</sec:authorize>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>