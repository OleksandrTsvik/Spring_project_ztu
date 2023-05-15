<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<c:if test="${not empty requestScope.dish}">
    <div class="card__dish">
        <a href="/dish/${requestScope.dish.id}" class="card__image">
            <c:if test="${not empty requestScope.dish.imageName}">
                <img src="<spring:url value="/resources/images/${requestScope.dish.imageName}"/>"
                     alt="Dish image" />
            </c:if>
            <c:if test="${empty requestScope.dish.imageName}">
                <img src="<c:url value="/resources/images/default-dish.jpg"/>"
                     alt="Default dish image" />
            </c:if>
        </a>
        <div class="card__content">
            <div class="card__body">
                <p>${requestScope.dish.name}</p>
                <p class="card__dish-price">${requestScope.dish.price} грн.</p>
            </div>
            <security:authorize access="hasRole('ADMIN')">
                <div class="card__footer">
                    <a href="/admin/dish/edit/${requestScope.dish.id}"
                       class="_icon-pencil btn btn__primary btn__action"></a>
                    <a href="/admin/dish/delete/${requestScope.dish.id}"
                       class="_icon-trash btn btn__danger btn__action"></a>
                </div>
            </security:authorize>
        </div>
    </div>
</c:if>