<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="../layouts/head.jsp">
    <jsp:param name="title" value="Forbidden" />
</jsp:include>
<body>
<%@include file="../layouts/header.jsp" %>
<main class="main main__wrapper container container__status-error">
    <div class="status-error__wrapper">
        <h1>Oops!</h1>
        <h2>403 Access denied</h2>
        <div>You don't have permission to access this page!</div>
        <div>
            <a href="/" class="btn btn__status-error btn__403">
                <i class="_icon-home"></i>Home
            </a>
        </div>
    </div>
</main>
<%@include file="../layouts/footer.jsp" %>
</body>
</html>
