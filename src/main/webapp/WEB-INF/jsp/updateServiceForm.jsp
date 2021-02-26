<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<div class="container login">
    <div class="row justify-content-center">
        <div class="col-md-6 col-md-offset-3">

            <h3 style="color: goldenrod">Update service</h3>

            <form:form method="post" modelAttribute="myService">

                <div class="form-group">
                    <label for="name"> Name </label> :
                    <form:errors path="name" cssClass="error"/>
                    <form:input path="name" class="form-control" id="name" name="name"
                                placeholder="Enter name"/>
                </div>
                <div class="form-group">
                    <label for="price"> Price </label> :
                    <form:errors path="price" cssClass="error"/><br>
                    <input type="number" min="0" value="0" name="price" path="price" id="price" class="form-control"
                           placeholder="Enter price"/>
                </div>
                <div class="form-group">
                    <label for="currency"> Currency </label> :
                    <form:errors path="currency" cssClass="error"/><br>
                    <form:radiobuttons items="${currency}" path="currency" class="form-control" id="currency" name="currency"
                                       placeholder="Choose curency"/>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3">
                            <input type="submit" name="login-submit" id="login-submit"
                                   class="form-control btn btn-primary" value="Update service"/>
                        </div>
                    </div>
                </div>
            </form:form><br>
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