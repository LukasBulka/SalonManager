<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<div class="container login">
    <div class="row justify-content-center">
        <div class="col-md-6 col-md-offset-3">

            <h3 style="color: goldenrod">Add new user</h3>

            <form:form method="post" modelAttribute="user">

                <div class="form-group">
                    <label for="firstName"> First name </label> :
                    <form:errors path="firstName" cssClass="error"/>
                    <form:input path="firstName" class="form-control" id="firstName" name="firstName"
                                placeholder="Enter your first name"/>
                </div>
                <div class="form-group">
                    <label for="lastName"> Last name </label> :
                    <form:errors path="lastName" cssClass="error"/>
                    <form:input path="lastName" class="form-control" id="lastName" name="lastName"
                                placeholder="Enter your last name"/>
                </div>
                <div class="form-group">
                    <label for="email"> Email </label> :
                    <form:errors path="email" cssClass="error"/><br>
                    <form:input path="email" class="form-control" id="email" name="email"
                                placeholder="Enter email"/>
                </div>
                <div class="form-group">
                    <label for="password"> Password </label> :
                    <form:errors path="password" cssClass="error"/><br>
                    <form:password path="password" class="form-control" id="password" name="password"
                                   placeholder="Enter password"/>
                </div>
                <div class="form-group">
                    <label for="roles"> Password </label> :
                    <form:errors path="roles" cssClass="error"/><br>
                    <form:checkboxes items="${roles}" path="roles" class="form-control" id="roles" name="roles"
                                     placeholder="Choose role"/>
                </div>
                <div class="form-group">
                    <label for="active"> Password </label> :
                    <form:errors path="active" cssClass="error"/><br>
                    <form:radiobuttons items="${active}" path="active" class="form-control" id="active" name="active"
                                       placeholder="Set active"/>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3">
                            <input type="submit" name="login-submit" id="login-submit"
                                   class="form-control btn btn-primary" value="Add user"/>
                        </div>
                    </div>
                </div>
            </form:form>
            <div class="form-group">
                <div class="row">
                    <div class="col-sm-6 col-sm-offset-3">
                        <a href="<c:url value="/admin"/>">
                            <button class="form-control btn btn-primary">Go back</button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>