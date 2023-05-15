<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<jsp:include page="../layouts/head.jsp">
    <jsp:param name="title" value="Вхід в адмін-панель" />
</jsp:include>
<body>
<%@include file="../layouts/header.jsp" %>
<main class="main main__wrapper container">
    <div class="title">Адмін-панель</div>
    <form:form
            id="form-login"
            action="/admin/login"
            method="post"
            cssClass="form form__auth"
    >
        <c:if test="${not empty sessionScope['SPRING_SECURITY_LAST_EXCEPTION']}">
            <p class="alert alert__danger">${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}</p>
        </c:if>
        <div class="form__field">
            <label for="email" class="form__label">Електронна пошта</label>
            <input class="input" name="email" id="email" />
        </div>
        <div class="form__field">
            <label for="password" class="form__label">Пароль</label>
            <input type="password" class="input" name="password" id="password" />
        </div>
        <button type="submit" class="btn btn__submit auth__btn">Увійти як адміністратор</button>
        <div class="auth__admin-link">
            <a href="/user/login">Увійти як користувач</a>
        </div>
    </form:form>
</main>
<%@include file="../layouts/footer.jsp" %>
</body>
</html>