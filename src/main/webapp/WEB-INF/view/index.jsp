<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<jsp:include page="../layouts/head.jsp">
    <jsp:param name="title" value="Головна" />
</jsp:include>
<body>
<%@include file="../layouts/header.jsp" %>
<main class="main container">
    <img class="banner__img" src="<c:url value="/resources/images/banner-1.png"/>" alt="banner-1" />
    <security:authorize access="isAuthenticated()">
        <div class="user_info alert alert__info">
            <h4>Коротка інформація про користувача:</h4>
            <p>Email: <security:authentication property="principal" /></p>
            <p>Роль: <security:authentication property="authorities" /></p>
        </div>
    </security:authorize>
    <c:if test="${empty categories}">
        <div class="empty-block">Страви відсутні</div>
    </c:if>
    <c:if test="${not empty categories}">
        <c:forEach var="category" items="${categories}">
            <c:if test="${not empty category.dishes}">
                <a href="/dishes?dishCategoryId=${category.id}" class="category__title">${category.name}</a>
                <div class="menu__draggable">
                    <div class="draggable__icon-left">
                        <i class="_icon-up-arrow"></i>
                    </div>
                    <div class="cards__dishes draggable__list">
                        <c:forEach var="dish" items="${category.dishes}">
                            <div class="draggable__item">
                                <c:set var="dish" value="${dish}" scope="request" />
                                <c:import url="../layouts/cardDish.jsp" />
                            </div>
                        </c:forEach>
                    </div>
                    <div class="draggable__icon-right">
                        <i class="_icon-up-arrow"></i>
                    </div>
                </div>
            </c:if>
        </c:forEach>
    </c:if>
</main>
<%@include file="../layouts/footer.jsp" %>
</body>
</html>
