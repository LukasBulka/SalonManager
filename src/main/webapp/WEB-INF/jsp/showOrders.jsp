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

<%--        Main--%>
<main role="main" class="col-md-10 ml-sm-auto px-4">
    <h4 style="color: goldenrod">Orders list</h4>
    <a href="<c:url value="/order/orderService"/>">
        <button class="action">Add order</button>
    </a>
    <div class="table table-striped">
        <table class="table table-sm">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Ordered by</th>
                <th>Performed by</th>
                <th>Selected services</th>
                <th>Completion date</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${orders}" var="order">
                <tr>
                    <td>${order.id}</td>
                    <td>${order.name}</td>
                    <td>${order.orderedBy.firstName}</td>
                    <td>${order.performedBy.firstName}</td>
                    <td>
                        <c:forEach items="${order.services}" var="service">
                            <div class="row">
                                <div class="col-md-12 bs-linebreak">
                                        ${service.name} ${service.price} ${service.currency}
                                </div>
                            </div>
                        </c:forEach>
                    </td>
                    <td>${order.orderCompletionDate}</td>
                    <td>
                        <a href="<c:url value="/order/updateOrder/${order.id}"/>">
                            <button class="action">Update</button>
                        </a>
                        <a href="<c:url value="/order/confirmRemoveOrderByOthers/${order.id}"/>">
                            <button class="action">Delete</button>
                        </a>
                        <a href="<c:url value="/notification/cancelVisit/${order.orderedBy.firstName}/${order.orderedBy.email}/${order.orderCompletionDate}"/>">
                            <button class="action">Cancel visit</button>
                        </a>
                        <a href="<c:url value="/notification/rescheduleVisit/${order.orderedBy.firstName}/${order.orderedBy.email}/${order.orderCompletionDate}"/>">
                            <button class="action">Reschedule</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</main>
</div>
</div>