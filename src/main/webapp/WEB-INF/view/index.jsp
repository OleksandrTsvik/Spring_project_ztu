<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="../layouts/head.jsp">
    <jsp:param name="title" value="Головна" />
</jsp:include>
<body>
<%@include file="../layouts/header.jsp" %>
<main class="main container">
    <img class="banner__img" src="<c:url value="/resources/images/banner-1.png"/>" alt="banner-1" />
    <h2>Hello World!</h2>
</main>
<%@include file="../layouts/footer.jsp" %>
</body>
</html>
