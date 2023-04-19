<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<jsp:include page="../layouts/head.jsp">
    <jsp:param name="title" value="Додати категорію" />
</jsp:include>
<body>
<jsp:include page="../layouts/header.jsp">
    <jsp:param name="link" value="/admin/category" />
</jsp:include>
<main class="main main__wrapper container">
    <div class="title">Форма категорії</div>
    <c:if test="${not empty categoryMessage}">
        <p class="alert alert__success">${categoryMessage}</p>
    </c:if>
    <form:form
            action="/admin/category"
            modelAttribute="category"
            method="post"
            cssClass="form"
    >
        <form:hidden path="id" />
        <div class="form__field">
            <label for="name" class="form__label">Назва</label>
            <form:input path="name" cssClass="input" />
            <form:errors path="name" cssClass="field__errors" />
        </div>
        <button type="submit" class="btn form__submit">Зберегти</button>
    </form:form>
</main>
<%@include file="../layouts/footer.jsp" %>
</body>
</html>