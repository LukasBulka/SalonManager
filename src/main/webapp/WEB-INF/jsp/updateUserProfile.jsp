<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<div class="container login">
    <div class="row justify-content-center">
        <div class="col-md-6 col-md-offset-3">

            <h3 style="color: goldenrod">My profile - update</h3>

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
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3">
                            <input type="submit" name="login-submit" id="login-submit"
                                   class="form-control btn btn-primary" value="Update profile"/>
                        </div>
                    </div>
                </div>
            </form:form>
            <div class="form-group">
                <div class="row">
                    <div class="col-sm-6 col-sm-offset-3">
                        <sec:authorize access="hasRole('USER')">
                            <a href="<c:url value="/user"/>">
                                <button class="form-control btn btn-primary">Go back</button>
                            </a>
                        </sec:authorize>
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
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


