<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/userAccount.jsp" %>
<%--        Main--%>
<main role="main" class="col-md-10 ml-sm-auto px-4">
    <h4 style="color: goldenrod">My orders</h4>
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
                                        ${service.name} ${service.price} ${service.currency}
                                </div>
                            </div>
                        </c:forEach>
                    </td>
                    <td>${userOrder.orderCompletionDate}</td>
                    <td>
                        <a href="<c:url value="/order/updateOrder/${userOrder.id}"/>">
                            <button class="action">Update</button>
                        </a>
                        <a href="<c:url value="/order/confirmRemoveOrderByUser/${userOrder.id}"/>">
                            <button class="action">Delete</button>
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