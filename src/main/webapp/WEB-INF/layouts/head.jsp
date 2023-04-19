<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <meta charset="UTF-8">
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="icon" type="image/png" sizes="32x32" href="<c:url value="/resources/images/favicon-32x32.png"/>">
    <link rel="icon" type="image/png" sizes="16x16" href="<c:url value="/resources/images/favicon-16x16.png"/>">

    <title><c:out value="${param.title}" /></title>

    <link rel="stylesheet" href="<c:url value="/resources/styles/style.css"/>" />

    <script src="<c:url value="/resources/scripts/main.js"/>" defer></script>
</head>