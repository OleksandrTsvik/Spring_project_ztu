<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<jsp:include page="../layouts/head.jsp">
    <jsp:param name="title" value="Додати адміністратора" />
</jsp:include>
<body>
<jsp:include page="../layouts/header.jsp">
    <jsp:param name="link" value="/admin/add" />
</jsp:include>
<main class="main main__wrapper container">
    <div class="title">Форма адміністратора</div>
    <c:if test="${not empty successMessage}">
        <p class="alert alert__success">${successMessage}</p>
    </c:if>
    <c:if test="${not empty dangerMessage}">
        <p class="alert alert__danger">${dangerMessage}</p>
    </c:if>
    <form:form
            action="/admin/add"
            modelAttribute="admin"
            method="post"
            cssClass="form"
    >
        <form:hidden path="id" />
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
        <div class="form__field">
            <label for="confirmPassword" class="form__label">Повторіть пароль</label>
            <form:input path="confirmPassword" type="password" cssClass="input" />
            <form:errors path="confirmPassword" cssClass="field__errors" />
        </div>
        <button type="submit" class="btn btn__submit">Зберегти</button>
    </form:form>
</main>
<%@include file="../layouts/footer.jsp" %>
</body>
</html>