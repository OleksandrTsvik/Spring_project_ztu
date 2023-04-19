<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="../layouts/head.jsp">
    <jsp:param name="title" value="404" />
</jsp:include>
<body>
<%@include file="../layouts/header.jsp" %>
<main class="main main__wrapper container container__404">
    <div class="wrapper__404">
        <h1>Oops!</h1>
        <h2>404 Not Found</h2>
        <div>Sorry, an error has occurred, Requested page not found!</div>
        <div>
            <a href="/" class="btn btn__404">
                <i class="_icon-home"></i>Home
            </a>
        </div>
    </div>
</main>
<%@include file="../layouts/footer.jsp" %>
</body>
</html>
