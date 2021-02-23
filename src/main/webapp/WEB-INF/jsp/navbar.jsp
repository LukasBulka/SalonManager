<a id="home" href="<c:url value="/"/>">HOME</a>
<a id="about" href="<c:url value="/about"/>">O NAS</a>
<a id="price" href="<c:url value="/price"/>">CENNIK</a>
<a id="contact" href="<c:url value="/contact"/>">KONTAKT</a>
<sec:authorize access="hasRole('USER')">
<a id="userAccount" href="<c:url value="/userAccount"/>">User Account</a>
</sec:authorize>
<sec:authorize access="hasRole('ADMIN')">
    <a id="administration" href="<c:url value="/administration"/>">Administration</a>
</sec:authorize>
<sec:authorize access="hasRole('EMPLOYEE')">
    <a id="management" href="<c:url value="/management"/>">Management</a>
</sec:authorize>
<sec:authorize access="hasRole('ADMIN')">
    <a id="management" href="<c:url value="/management"/>">Management</a>
</sec:authorize>
    <a id="signin" href="<c:url value="/register"/>">SIGN IN</a>
<sec:authorize access="!isAuthenticated()">
    <a id="login" href="<c:url value="/login"/>">LOG IN</a>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <a id="logout" href="<c:url value="/logout"/>">LOG OUT</a>
</sec:authorize>