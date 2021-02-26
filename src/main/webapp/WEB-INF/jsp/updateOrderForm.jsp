<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<div class="container login">
    <div class="row justify-content-center">
        <div class="col-md-6 col-md-offset-3">

            <h3 style="color: goldenrod">Update service</h3>

            <form:form method="post" modelAttribute="order">

                <div class="form-group">
                    <label for="name"> Name </label> :
                    <form:errors path="name" cssClass="error"/>
                    <form:input path="name" class="form-control" id="name" name="name"
                                placeholder="Enter name"/>
                </div>
                <div class="form-group">
                    <label for="performedBy"> Performed by </label> :
                    <form:errors path="performedBy" cssClass="error"/><br>
                    <form:select items="${performedBy}" path="performedBy"
                                 itemLabel="firstName" itemValue="id" class="form-control" id="performedBy"
                                 name="performedBy" placeholder="Choose hairdresser"/>
                </div>
                <div class="form-group">
                    <label for="services"> Services </label> :
                    <form:errors path="services" cssClass="error"/><br>
                    <form:checkboxes items="${services}" path="services"
                                     itemLabel="name" itemValue="id" delimiter="<br/>" id="services"
                                     name="services" placeholder="Chosse services"/>
                </div>
                <div class="form-group">
                    <label for="picker"> Execution date </label> :
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <button type="button" id="toggle" class="input-group-text"><i
                                    class="fa fa-calendar-alt"></i></button>
                        </div>
                        <form:errors path="orderCompletionDate" cssClass="error"/><br>
                        <form:input path="orderCompletionDate" id="picker" class="form-control"
                                    name="orderCompletionDate" placeholder="Chosse services"/>
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
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3">
                            <input type="submit" name="login-submit" id="login-submit"
                                   class="form-control btn btn-primary" value="Update order"/>
                        </div>
                    </div>
                </div>
            </form:form>
            <div class="form-group">
                <div class="row">
                    <div class="col-sm-6 col-sm-offset-3">
                        <sec:authorize access="hasRole('EMPLOYEE')">
                            <a href="<c:url value="/employee"/>">
                                <button class="form-control btn btn-primary">Go back</button>
                            </a>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ADMIN')">
                            <a href="<c:url value="/admin"/>">
                                <button class="form-control btn btn-primary">Go back</button>
                            </a>
                        </sec:authorize>
                        <sec:authorize access="hasRole('USER')">
                            <a href="<c:url value="/user"/>">
                                <button class="form-control btn btn-primary">Go back</button>
                            </a>
                        </sec:authorize>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>