<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>

<header class="page-header header container-fluid">
    <div class="overlay">
        <div class="row justify-content-center">
            <c:if test="${not empty param.success}">
                <div class="alert alert-info">Account has been successfully deleted</div>
            </c:if>
        </div>
        <div class="row justify-content-center">
            <c:if test="${not empty param.registrationSuccess}">
                <div class="alert alert-info">Successfully registered</div>
            </c:if>
        </div>
    </div>
    <div class="description">
        <h1>Welcome to salonManager!</h1>
        <p>Hi, Lukas here, thank you for visiting this webapp. It's an IT school final project. A simple application for hairdressing salon management. Feel free to register and discover full functionality. Enjoy your stay.</p>
        <a href="<c:url value="/about"/>"><button class="btn btn-outline-secondary btn-lg">Tell Me More!</button></a>
    </div>
</header>
<div class="container features">
    <div class="row">
        <div class="col-lg-4 col-md-4 col-sm-12">
            <h3 class="feature-title">Lorem ipsum</h3>
<%--            Photo by Engin Akyurt from Pexels--%>
            <img src="1.jpg" class="img-fluid">
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque interdum quam odio, quis placerat ante
                luctus eu. Sed aliquet dolor id sapien rutrum, id vulputate quam iaculis.</p>
        </div>

        <div class="col-lg-4 col-md-4 col-sm-12">
            <h3 class="feature-title">Lorem ipsum</h3>
            <%--            Photo by Nick Demou from Pexels--%>
            <img src="2.jpg" class="img-fluid">
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque interdum quam odio, quis placerat ante
                luctus eu. Sed aliquet dolor id sapien rutrum, id vulputate quam iaculis.</p>
        </div>
        <div class="col-lg-4 col-md-4 col-sm-12">
            <h3 class="feature-title">Lorem ipsum</h3>
            <%--            Photo by Engin Akyurt from Pexels--%>
            <img src="3.jpg" class="img-fluid">
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque interdum quam odio, quis placerat ante
                luctus eu. Sed aliquet dolor id sapien rutrum, id vulputate quam iaculis.</p>
        </div>

        <%--        <div class="col-lg-4 col-md-4 col-sm-12">--%>
        <%--            <h3 class="feature-title">Get in Touch!</h3>--%>
        <%--            <form method="post" action="/notification/contactUs">--%>
        <%--                <div class="form-group">--%>
        <%--                    <input type="text" class="form-control" placeholder="Name" name="name">--%>
        <%--                </div>--%>
        <%--                <div class="form-group">--%>
        <%--                    <input type="text" class="form-control" placeholder="Email Address" name="email">--%>
        <%--                </div>--%>
        <%--                <div class="form-group">--%>
        <%--                    <textarea class="form-control" rows="4" name="message"></textarea>--%>
        <%--                </div>--%>
        <%--                <input type="submit" class="btn btn-secondary btn-block" value="Contact us">--%>
        <%--            </form>--%>
        <%--        </div>--%>
    </div>
</div>
<div class="background">
    <div class="container team">
        <h3 style="color: goldenrod">Contact</h3>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque interdum quam odio, quis placerat ante
            luctus eu. Sed aliquet dolor id sapien rutrum, id vulputate quam iaculis. Suspendisse consectetur mi id
            libero fringilla, in pharetra sem ullamcorper.</p>
        <div class="row">
            <div class="col text-center">
                <div class="card-body">
                    <h4 class="card-title">Ewa Szajska </h4>
                    <p class="card-text">Salon Manager</p>
                    <p class="card-text">ewaszajska@salonManager.com</p>
                    <p class="card-text">+48 123 456 789</p>
                </div>
            </div>
            <div class="col text-center">
                <div class="card-body">
                    <h4 class="card-title">Jerzy Killer</h4>
                    <p class="card-text">Administrator</p>
                    <p class="card-text">jurekKiller@salonManager.com</p>
                    <p class="card-text">+48 987 654 321</p>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>