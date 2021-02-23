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
    <form:checkboxes items="${services}" path="services"
                     itemLabel="name" itemValue="id" delimiter="<br>"/><br>
    <br>
    <br>
    Choose order completion date:<br>
    <div class="container mt-5 mb-5" style="width: 400px">
        <div class="input-group">
            <div class="input-group-prepend">
                <button type="button" id="toggle" class="input-group-text"><i class="fa fa-calendar-alt"></i></button>
            </div>
            <form:errors path="orderCompletionDate" cssClass="error"/><br>
            <form:input path="orderCompletionDate" id="picker" class="form-control" name="orderCompletionDate"/>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment-with-locales.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js"></script>

    <script type="text/javascript">
        $(function () {
            $.datetimepicker.setDateFormatter('moment')
            const minDate = new Date();
            minDate.setDate(minDate.getDate());
            $('#picker').datetimepicker({
                timepicker: true,
                datepicker: true,
                format: 'YYYY-MM-DD HH:mm',
                step: 30,
                disabledWeekDays: [0, 6],
                todayBtn: true,
                allowTimes: ['09:00', '09:30', '10:00', '10:30', '11:00', '11:30', '12:00', '12:30',
                    '13:00', '13:30', '14:00', '14:30', '15:00', '15:30', '16:00', '16:30',],
                minDate: minDate,
                hours12: false
            });
            $('#toggle').on('click', function () {
                $('#picker').datetimepicker('toggle')
            });
        });
    </script>
    <br>
    <br>
    <input type="submit" value="Update order"/>
</form:form><br>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>