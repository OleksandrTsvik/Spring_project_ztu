<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="../layouts/head.jsp">
    <jsp:param name="title" value="Адміністратори" />
</jsp:include>
<body>
<jsp:include page="../layouts/header.jsp">
    <jsp:param name="link" value="/admin/admins" />
</jsp:include>
<main class="main main__wrapper container">
    <h2 class="title">Адміністратори</h2>
    <c:if test="${not empty deleteMessage}">
        <p class="alert alert__info">${deleteMessage}</p>
    </c:if>
    <c:if test="${empty admins}">
        <div class="empty-block">Адміністратори відсутні</div>
    </c:if>
    <c:if test="${not empty admins}">
        <table class="table table__admins">
            <tr>
                <th>ID</th>
                <th>Електронна пошта</th>
                <th class="actions"></th>
            </tr>
            <c:forEach var="admin" items="${admins}">
                <tr>
                    <td>${admin.id}</td>
                    <td>${admin.email}</td>
                    <td>
                        <div class="actions">
                            <a href="/admin/edit/${admin.id}"
                               class="_icon-pencil btn btn__primary btn__action"></a>
                            <a href="/admin/delete/${admin.id}"
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
