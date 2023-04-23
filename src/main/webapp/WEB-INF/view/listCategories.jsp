<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="../layouts/head.jsp">
    <jsp:param name="title" value="Категорії" />
</jsp:include>
<body>
<jsp:include page="../layouts/header.jsp">
    <jsp:param name="link" value="/admin/categories" />
</jsp:include>
<main class="main main__wrapper container">
    <h2 class="title">Категорії</h2>
    <c:if test="${not empty deleteMessage}">
        <p class="alert alert__info">${deleteMessage}</p>
    </c:if>
    <c:if test="${empty categories}">
        <div class="empty-block">Категорії відсутні</div>
    </c:if>
    <c:if test="${not empty categories}">
        <table class="table table__categories">
            <tr>
                <th>ID</th>
                <th>Категорія</th>
                <th class="count">Кількість страв</th>
                <th class="actions"></th>
            </tr>
            <c:forEach var="category" items="${categories}">
                <tr>
                    <td>${category.id}</td>
                    <td>${category.name}</td>
                    <td class="count">${category.dishes.size()}</td>
                    <td>
                        <div class="actions">
                            <a href="/admin/category/edit/${category.id}"
                               class="_icon-pencil btn btn__primary btn__action"></a>
                            <a href="/admin/category/delete/${category.id}"
                               class="_icon-trash btn btn__danger btn__action"></a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</main>
<%@include file="../layouts/footer.jsp" %>
</body>
</html>
