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
            action="/admin/login"
            modelAttribute="login"
            method="post"
            cssClass="form form__auth"
    >
        <c:if test="${not empty loginMessage}">
            <p class="alert alert__danger">${loginMessage}</p>
        </c:if>
        <div class="form__field">
            <label for="email" class="form__label">Електронна пошта</label>
            <form:input path="email" cssClass="input" />
            <form:errors path="email" cssClass="field__errors" />
        </div>
        <div class="form__field">
            <label for="password" class="form__label">Пароль</label>
            <form:input path="password" type="password" cssClass="input" />
            <form:errors path="password" cssClass="field__errors" />
        </div>
        <button type="submit" class="btn btn__submit auth__btn">Увійти як адміністратор</button>
    </form:form>
</main>
<%@include file="../layouts/footer.jsp" %>
</body>
</html>