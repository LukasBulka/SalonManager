<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ include file="/WEB-INF/jsp/navbar.jsp" %>
<div class="container login confirm">
    <div class="row justify-content-center">
        <h3 id="choose">Choose option:</h3>
        <div class="col-md-6 col-md-offset-3">
            <div class="form-group">
                <button><a id="confirm" href="/admin/removeUser/${id}">CONFIRM</a></button>
                <button><a id="cancel" href="/admin/showUsers">CANCEL</a></button>
            </div>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>