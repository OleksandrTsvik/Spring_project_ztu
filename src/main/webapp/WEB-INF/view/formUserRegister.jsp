<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<jsp:include page="../layouts/head.jsp">
    <jsp:param name="title" value="Реєстрація" />
</jsp:include>
<body>
<%@include file="../layouts/header.jsp" %>
<main class="main main__wrapper container">
    <div class="title">Реєстрація</div>
    <form:form
            action="/user/register"
            modelAttribute="register"
            method="post"
            cssClass="form form__auth"
    >
        <c:if test="${not empty registerMessage}">
            <p class="alert alert__danger">${registerMessage}</p>
        </c:if>
        <div class="form__field">
            <label for="fullName" class="form__label">ПІБ</label>
            <form:input path="fullName" cssClass="input" />
            <form:errors path="fullName" cssClass="field__errors" />
        </div>
        <div class="form__field">
            <label for="phoneNumber" class="form__label">Номер телефону</label>
            <form:input path="phoneNumber" cssClass="input" />
            <form:errors path="phoneNumber" cssClass="field__errors" />
        </div>
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
        <button type="submit" class="btn btn__submit auth__btn">Зареєструватися</button>
        <div class="auth__link">
            <div>Вже є акаунт?</div>
            <a href="/user/login">Увійти</a>
        </div>
    </form:form>
</main>
<%@include file="../layouts/footer.jsp" %>
</body>
</html>