<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="../layouts/head.jsp">
    <jsp:param name="title" value="${dish.name}" />
</jsp:include>
<body>
<%@include file="../layouts/header.jsp" %>
<main class="main main__wrapper container">
    <div class="dish">
        <div class="dish__image">
            <c:if test="${not empty dish.imageName}">
                <img src="<spring:url value="/resources/images/${dish.imageName}"/>" alt="Dish image" />
            </c:if>
            <c:if test="${empty dish.imageName}">
                <img src="<c:url value="/resources/images/default-dish.jpg"/>" alt="Default dish image" />
            </c:if>
        </div>
        <div class="dish__body">
            <div class="dish__content">
                <div class="dish__title">${dish.name}</div>
                <div class="dish__components">${dish.components}</div>
                <c:if test="${not empty dish.description}">
                    <div class="dish__description">${dish.description}</div>
                </c:if>
            </div>
            <div class="dish__buy">
                <a href="/user/dish" class="btn">Додати в кошик</a>
                <span>${dish.price} грн.</span>
            </div>
        </div>
    </div>
</main>
<%@include file="../layouts/footer.jsp" %>
</body>
</html>