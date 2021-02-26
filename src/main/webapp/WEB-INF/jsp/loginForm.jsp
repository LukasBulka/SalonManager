<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<div class="container login">
    <div class="row justify-content-center">
        <div class="col-md-6 col-md-offset-3">

            <h3 style="color: goldenrod">Login Page </h3>
            <form method="post" action="${pageContext.request.contextPath}/authentication/login">

                <div>
                    <c:if test="${not empty param.loginSuccess}">
                        <div class="alert alert-info">Successfully logged in</div>
                    </c:if>
                </div>

                <div>
                    <c:if test="${not empty param.error}">
                        <div class="error alert alert-danger">Invalid email or password</div>
                    </c:if>
                </div>

                <div class="form-group">
                    <label for="email"> Email </label> :
                    <input type="text" class="form-control" id="email" name="email" placeholder="Enter email address"/>
                </div>

                <div class="form-group">
                    <label for="password">Password</label>:
                    <input type="password" id="password" name="password" class="form-control" placeholder="Enter Password"/>
                </div>

                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3">
                            <input type="submit" name="login-submit" id="login-submit"
                                   class="form-control btn btn-primary" value="Log In"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <span>New user? <a href="<c:url value="/authentication/registration"/>">Sign in here</a></span>
                </div>

                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </div>
    </div>
</div>

<%--<%@ include file="/WEB-INF/jsp/footer.jsp" %>--%>
