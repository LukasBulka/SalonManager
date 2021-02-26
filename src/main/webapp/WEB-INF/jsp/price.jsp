<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<div class="container features">
    <div class="row">
        <h4 style="color: goldenrod">Price list</h4>
        <div class="table table-striped">
            <table class="table table-sm">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Currency</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${services}" var="service">
                    <tr>
                        <td>${service.name}</td>
                        <td>${service.price}</td>
                        <td>${service.currency}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>
