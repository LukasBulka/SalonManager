<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<h1>Order service</h1>
<a href="<c:url value="/user"/>">Go back</a><br>
<form:form method="post" modelAttribute="order">

    Name:
    <form:errors path="name" cssClass="error"/><br>
    <form:input path="name"/><br>
    <br>
    <br>
    Perform by:
    <form:errors path="performedBy" cssClass="error"/><br>
    <form:select items="${performedBy}" path="performedBy"
                 itemLabel="firstName" itemValue="id"/><br>
    <br>
    Choose services:
    <form:errors path="services" cssClass="error"/><br>
    <div class="row">
        <div class="col-md-12 bs-linebreak">
            <form:checkboxes items="${services}" path="services"
                             itemLabel="name" itemValue="id" delimiter="<br>"/><br/>
        </div>
    </div>

    <br>
    <br>
    Choose order completion date:<br>
    <div class="container mt-5 mb-5" style="width: 400px">
        <form:errors path="orderCompletionDate" cssClass="error"/><br>
        <form:input path="orderCompletionDate" id="picker" class="form-control" name="orderCompletionDate"/>
    </div>
    <script type="text/javascript">
        $('#picker').datetimepicker({
            timepicker: true,
            datepicker: true,
            format: 'Y-m-d H:i',
            hours12: false,
            step: 30,
            startDate: Date.now(),
            daysOfWeekDisabled: [0, 6],
            todayBtn: true,
            enabledHours: [8, 9, 10, 11, 12, 13, 14, 15, 16, 17],
        });
    </script>
    <br>
    <br>
    <input type="submit" value="Add order"/>
</form:form><br>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>