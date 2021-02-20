<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>

<h3>Services list</h3>
<sec:authorize access="hasRole('USER')">
    <a href="<c:url value="/user"/>">Go back</a>
</sec:authorize>
<sec:authorize access="hasRole('ADMIN')">
    <a href="<c:url value="/admin"/>">Go back</a>
</sec:authorize>
<br>
<br>
<sec:authorize access="hasRole('ADMIN')">
    <a href="/myService/addService">Add new service</a>
</sec:authorize>
<br>
<br>

<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Currency</th>
        <sec:authorize access="hasRole('ADMIN')">
            <th>Action</th>
        </sec:authorize>
    </tr>
    <c:forEach items="${services}" var="service">
        <tr>
            <td>${service.id}</td>
            <td>${service.name}</td>
            <td>${service.price}</td>
            <td>${service.currency}</td>
            <sec:authorize access="hasRole('ADMIN')">
                <td>
                    <a href="/myService/updateService/${service.id}">Update</a><br>
                    <a href="/myService/confirmRemoveService/${service.id}">Delete</a>
                </td>
            </sec:authorize>
        </tr>
    </c:forEach>
</table>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>
