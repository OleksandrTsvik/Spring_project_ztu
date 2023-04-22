<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="../layouts/head.jsp">
    <jsp:param name="title" value="Страви" />
</jsp:include>
<body>
<jsp:include page="../layouts/header.jsp">
    <jsp:param name="link" value="/dishes" />
</jsp:include>
<main class="main main__wrapper container">
    <h2 class="title">Страви</h2>
    <c:if test="${not empty deleteMessage}">
        <p class="alert alert__info">${deleteMessage}</p>
    </c:if>
    <c:if test="${empty dishes}">
        <div class="empty-block">Страви відсутні</div>
    </c:if>
    <c:if test="${not empty dishes}">
        <div class="cards__dishes">
            <c:forEach var="dish" items="${dishes}">
                <c:set var="dish" value="${dish}" scope="request" />
                <c:import url="../layouts/cardDish.jsp" />
            </c:forEach>
        </div>
    </c:if>
</main>
<%@include file="../layouts/footer.jsp" %>
</body>
</html>
