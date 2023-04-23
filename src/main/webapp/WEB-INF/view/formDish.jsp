<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<jsp:include page="../layouts/head.jsp">
    <jsp:param name="title" value="Додати страву" />
</jsp:include>
<body>
<jsp:include page="../layouts/header.jsp">
    <jsp:param name="link" value="/admin/dish" />
</jsp:include>
<main class="main main__wrapper container">
    <div class="title">Форма страви</div>
    <c:if test="${not empty dishMessage}">
        <p class="alert alert__success">${dishMessage}</p>
    </c:if>
    <form:form
            action="/admin/dish"
            modelAttribute="dish"
            method="post"
            cssClass="form"
            enctype="multipart/form-data"
    >
        <form:hidden path="id" />
        <div class="form__field">
            <label for="name" class="form__label">Назва</label>
            <form:input path="name" cssClass="input" />
            <form:errors path="name" cssClass="field__errors" />
        </div>
        <div class="form__field">
            <label for="categoryDish.id" class="form__label">Категорія</label>
            <div class="select__wrapper">
                <form:select path="categoryDish.id">
                    <%-- <form:option value="" label="Оберіть категорію" />--%>
                    <form:options items="${categoriesDish}" itemValue="id" itemLabel="name" />
                </form:select>
            </div>
        </div>
        <div class="form__field">
            <label for="description" class="form__label">Опис</label>
            <form:textarea path="description" cssClass="input" />
            <form:errors path="description" cssClass="field__errors" />
        </div>
        <div class="form__field">
            <label for="components" class="form__label">Складові</label>
            <form:input path="components" cssClass="input" />
            <form:errors path="components" cssClass="field__errors" />
        </div>
        <div class="form__field">
            <label for="price" class="form__label">Ціна</label>
            <form:input path="price" cssClass="input" />
            <form:errors path="price" cssClass="field__errors" />
        </div>
        <div class="form__field">
            <label for="image" class="form__label">Фото</label>
            <form:input path="image" type="file" cssClass="input" />
        </div>
        <button type="submit" class="btn btn__submit">Зберегти</button>
    </form:form>
</main>
<%@include file="../layouts/footer.jsp" %>
</body>
</html>