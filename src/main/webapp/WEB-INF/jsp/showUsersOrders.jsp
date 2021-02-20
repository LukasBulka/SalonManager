<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<h1>User Panel</h1>
<h3>Orders list</h3>
<a href="<c:url value="/user"/>">Go back</a>
<br>
<br>
<a href="<c:url value="/order/orderService"/>">Add new order</a><br>
<br>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Ordered by</th>
        <th>Performed by</th>
        <th>Selected services</th>
        <th>Completion date</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${usersOrders}" var="userOrder">
        <tr>
            <td>${userOrder.id}</td>
            <td>${userOrder.name}</td>
            <td>${userOrder.orderedBy.firstName}</td>
            <td>${userOrder.performedBy.firstName}</td>
            <td>
                <c:forEach items="${userOrder.services}" var="service">
                    <div class="row">
                        <div class="col-md-12 bs-linebreak">
                                ${service.name} ${service.price}
                        </div>
                    </div>
                </c:forEach>
            </td>
            <td>${userOrder.orderCompletionDate}</td>
            <td>
                <a href="/order/updateOrder/${userOrder.id}">Update</a><br>
                <a href="/order/confirmRemoveOrderByUser/${userOrder.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>