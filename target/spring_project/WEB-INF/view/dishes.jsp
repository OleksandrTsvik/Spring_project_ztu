<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
                <div class="card__dish">
                    <a href="/dish/${dish.id}" class="card__image">
                        <c:if test="${not empty dish.imageName}">
                            <img src="<spring:url value="/resources/images/${dish.imageName}"/>"
                                 alt="${dish.imageName}" />
                        </c:if>
                        <c:if test="${empty dish.imageName}">
                            <img src="<c:url value="/resources/images/default-dish.jpg"/>"
                                 alt="${dish.imageName}" />
                        </c:if>
                    </a>
                    <div class="card__content">
                        <div class="card__body">
                            <p>${dish.name}</p>
                            <p class="card__dish-price">${dish.price}</p>
                        </div>
                        <div class="card__footer">
                            <a href="/admin/dish/edit/${dish.id}" class="_icon-pencil btn btn__primary btn__action"></a>
                            <a href="/admin/dish/delete/${dish.id}" class="_icon-trash btn btn__danger btn__action"></a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:if>
</main>
<%@include file="../layouts/footer.jsp" %>
</body>
</html>
