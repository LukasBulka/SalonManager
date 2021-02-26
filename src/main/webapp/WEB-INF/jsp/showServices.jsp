<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<sec:authorize access="hasRole('EMPLOYEE')">
    <%@ include file="/WEB-INF/jsp/management.jsp" %>
</sec:authorize>
<sec:authorize access="hasRole('ADMIN')">
    <%@ include file="/WEB-INF/jsp/administration.jsp" %>
</sec:authorize>
<sec:authorize access="hasRole('USER')">
    <%@ include file="/WEB-INF/jsp/userAccount.jsp" %>
</sec:authorize>
<%--        Main--%>
<main role="main" class="col-md-10 ml-sm-auto px-4">
    <h4 style="color: goldenrod">Services list</h4>
    <sec:authorize access="!hasRole('USER')">
        <a href="<c:url value="/myService/addService"/>">
            <button class="action">Add service</button>
        </a>
    </sec:authorize>
    <div class="table table-striped">
        <table class="table table-sm">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Price</th>
                <th>Currency</th>
                <sec:authorize access="!hasRole('USER')">
                    <th>Action</th>
                </sec:authorize>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${services}" var="service">
                <tr>
                    <td>${service.id}</td>
                    <td>${service.name}</td>
                    <td>${service.price}</td>
                    <td>${service.currency}</td>
                    <sec:authorize access="!hasRole('USER')">
                        <td>
                            <a href="<c:url value="/myService/updateService/${service.id}"/>">
                                <button class="action">Update</button>
                            </a>
                            <a href="<c:url value="/myService/confirmRemoveService/${service.id}"/>">
                                <button class="action">Delete</button>
                            </a>
                        </td>
                    </sec:authorize>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</main>
</div>
</div>
