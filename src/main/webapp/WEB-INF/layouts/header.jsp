<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="ztu.education.spring_web_project.utils.NavBar" %>

<header class="header">
    <div class="header__content container">
        <div class="header__menu menu">
            <div class="menu__icon icon-menu">
                <span></span>
                <span></span>
                <span></span>
            </div>
            <nav class="menu__body">
                <a href="/" class="logo">LOGOS</a>
                <div class="menu__center">
                    <form class="menu__search" action="/dishes" method="get">
                        <input class="search__input input" name="dishName" placeholder="Введіть назву страви" />
                        <button type="submit" class="search__btn _icon-search"></button>
                    </form>
                    <a href="tel:+380987654321" class="menu__contacts">
                        <div class="menu__calling _icon-calling"></div>
                        <div>
                            <div class="contacts__title">Контакти:</div>
                            <div class="contacts__phone">+38 (098) 765-43-21</div>
                        </div>
                    </a>
                </div>
                <div class="menu__left">
                    <a href="#" class="menu__user _icon-user">Увійти</a>
                    <a href="#" class="menu__basket">
                        <span class="basket__text">Корзина</span>
                        <span class="basket__pill">4</span>
                    </a>
                </div>
            </nav>
        </div>
        <div class="header__admin menu__draggable">
            <div class="draggable__icon-left">
                <i class="_icon-up-arrow"></i>
            </div>
            <nav class="admin__list draggable__list">
                <c:forEach var="item" items="${NavBar.getAdminNavBar()}">
                    <c:if test="${not empty param.link && item.link.equals(param.link)}">
                        <a href="${item.link}" class="admin__item draggable__item active">${item.label}</a>
                    </c:if>
                    <c:if test="${empty param.link || !item.link.equals(param.link)}">
                        <a href="${item.link}" class="admin__item draggable__item">${item.label}</a>
                    </c:if>
                </c:forEach>
            </nav>
            <div class="draggable__icon-right">
                <i class="_icon-up-arrow"></i>
            </div>
        </div>
    </div>
</header>