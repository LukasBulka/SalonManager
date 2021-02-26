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
    <h4 style="color: goldenrod">Timetable</h4>
    <br/>
    <div class="table table-striped">
        <table class="table table-sm">
            <thead>
            <tr>
                <th scope="col">Employee:</th>
                <th scope="col">Busy:</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${timetables}" var="timetable">
                <tr>
                    <td>${timetable.key}</td>
                    <td>${timetable.value}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</main>
</div>
</div>