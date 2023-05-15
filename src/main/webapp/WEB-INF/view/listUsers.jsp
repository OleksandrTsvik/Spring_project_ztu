<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="../layouts/head.jsp">
    <jsp:param name="title" value="Користувачі" />
</jsp:include>
<body>
<jsp:include page="../layouts/header.jsp">
    <jsp:param name="link" value="/admin/users" />
</jsp:include>
<main class="main main__wrapper container">
    <h2 class="title">Користувачі</h2>
    <c:if test="${not empty infoMessage}">
        <p class="alert alert__info">${infoMessage}</p>
    </c:if>
    <c:if test="${empty users}">
        <div class="empty-block">Користувачі відсутні</div>
    </c:if>
    <c:if test="${not empty users}">
        <table class="table table__users">
            <tr>
                <th>ID</th>
                <th>ПІБ</th>
                <th>Номер телефону</th>
                <th>Електронна пошта</th>
                <th class="actions"></th>
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.fullName}</td>
                    <td>${user.phoneNumber}</td>
                    <td>${user.email}</td>
                    <td>
                        <div class="actions">
                            <c:if test="${user.enabled}">
                                <a href="/admin/user/toggle/${user.id}" title="Заблокувати"
                                   class="_icon-eye btn btn__action"></a>
                            </c:if>
                            <c:if test="${not user.enabled}">
                                <a href="/admin/user/toggle/${user.id}" title="Розблокувати"
                                   class="_icon-eye-blocked btn btn__danger btn__action"></a>
                            </c:if>
                            <a href="/admin/user/delete/${user.id}"
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
