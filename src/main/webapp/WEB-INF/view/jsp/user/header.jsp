<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="ua.kiyv.training.library.utils.constants.Attributes" %>

<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<link rel="stylesheet" href="/css/dropdown.css">
<link rel="stylesheet" href="/css/header.css">
<link rel="stylesheet" href="/css/home.css">
<link rel="stylesheet" href="/css/library.css">
<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>

<fmt:setLocale value="${sessionScope['locale']}"/>
<fmt:setBundle basename="${bundleFile}" var="msg"/>
<fmt:requestEncoding value="UTF-8"/>

<div class="mainmenu-wrapper">
    <div class="container">
        <div class="menuextras">
            <div class="extras">
                <ul>
                    <li>
                        <jsp:include page="../fragment/languageSelector.jsp"/>
                    </li>
                    <c:if test="${sessionScope.userId==null}">
                        <li><a href="/library/login"><fmt:message key="library.login" bundle="${msg}"/></a></li>
                    </c:if>
                    <c:if test="${sessionScope.userId!=null}">
                        <li><a href="/library/logout"><fmt:message key="library.logout" bundle="${msg}"/></a></li>
                    </c:if>
                </ul>
            </div>
        </div>
        <nav id="mainmenu" class="mainmenu">
            <ul class="mainmenu-list">
                <li>
                    <a href="/library/user"><fmt:message key="library.user.menu.home" bundle="${msg}"/></a>
                </li>
                <li>
                    <a href="/library/user/books"><fmt:message key="library.user.menu.books" bundle="${msg}"/></a>
                </li>
                <li>
                    <div class="dropdown show">
                        <a class=" dropdown-toggle" href="/library/user/books/genre" role="button" id="dropdownMenuLink"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <fmt:message key="library.user.menu.books.by.genre" bundle="${msg}"/>
                        </a>

                        <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                            <c:forEach var="genre" items="${genres}">
                                <a class="dropdown-item"
                                   href="/library/user/books/genre/${genre.id}"> ${genre.name}</a>
                            </c:forEach>
                        </div>
                    </div>

                </li>
                <li>

                    <form id="register-form" action="/library/search" method="post" role="form">
                        <input type="search" id="searchValue" name="searchValue"
                               placeholder=
                               <fmt:message key="library.search.placeholder" bundle="${msg}"/> size="50">
                        <button><fmt:message key="library.button.search" bundle="${msg}"/></button>
                        <br>
                        <input type="radio" name="filter" value="author" checked> <fmt:message
                            key="library.search.attribute.author" bundle="${msg}"/>
                        <input type="radio" name="filter" value="title"> <fmt:message
                            key="library.search.attribute.title" bundle="${msg}"/>
                        <input type="radio" name="filter" value="keywords"> <fmt:message
                            key="library.search.attribute.keywords" bundle="${msg}"/>
                    </form>

                </li>

            </ul>
        </nav>
    </div>
</div>

