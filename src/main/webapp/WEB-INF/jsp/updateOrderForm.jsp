<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<h1>Order service</h1>
<a href="<c:url value="/user"/>">Go back</a><br>
<form:form method="post" modelAttribute="order">

    Name:
    <form:errors path="name" cssClass="error"/><br>
    <form:input path="name"/><br>
    <br>
    Perform by:
    <form:errors path="performedBy" cssClass="error"/><br>
    <form:select items="${performedBy}" path="performedBy"
                 itemLabel="firstName" itemValue="id"/><br>
    <br>
    Choose services:
    <form:errors path="services" cssClass="error"/><br>
    <form:checkboxes items="${services}" path="services"
                     itemLabel="name" itemValue="id" delimiter="<br>"/><br>
    <br>
    Choose order completion date:<br>
    <div class="container mt-5 mb-5" style="width: 400px">
        <input type="text" id="picker" class="form-control" name="orderCompletionDate">

    </div>
    <script>
        $('#picker').datetimepicker({
            timepicker: true,
            datepicker: true,
            format: 'Y-m-d H:i',
            hours12: false,
            step: 30,
            disabledWeekDays:[0,6],
            stepping: 30,
            enabledHours: [8, 9, 10, 11, 12, 13, 14, 15, 16, 17]
        })
    </script>
    <br>
    <br>
    <input type="submit" value="Add order"/>
</form:form><br>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>