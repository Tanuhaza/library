<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="ua.kiyv.training.library.utils.constants.Attributes" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css">
    <link rel="stylesheet" href="/css/dropdown.css">
    <link rel="stylesheet" href="/css/header.css">
    <link rel="stylesheet" href="/css/home.css">
    <link rel="stylesheet" href="/css/library.css">
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <fmt:setLocale value="${sessionScope['locale']}"/>
    <fmt:requestEncoding value="UTF-8"/>
    <fmt:setBundle basename="${sessionScope['bundleFile']}" var="msg"/>
    <title>home page</title>
</head>
<body class="body-profile-container">
<jsp:include page="WEB-INF/view/jsp/user/header.jsp"/>
<%--<fmt:setLocale value="en"/>--%>
<%--<fmt:setBundle basename="webProject.i18n.messages" var="msg"/>--%>
<%--<div class="mainmenu-wrapper">--%>
    <%--<div class="container">--%>
        <%--<div class="menuextras">--%>
            <%--<div class="extras">--%>
            <%--<ul>--%>
                    <%--<c:if test="${sessionScope.userId==null}">--%>
                        <%--<li><a href="/library/login"><fmt:message key="library.login" bundle="${msg}"/></a></li>--%>
                    <%--</c:if>--%>
                    <%--<c:if test="${sessionScope.userId!=null}">--%>
                        <%--<li><a href="/library/logout"><fmt:message key="library.logout" bundle="${msg}"/></a></li>--%>
                    <%--</c:if>--%>
                <%--</ul>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<nav id="mainmenu" class="mainmenu">--%>
            <%--<ul class="mainmenu-list">--%>
                <%--<li>--%>
                    <%--<a href="/library/user"><fmt:message key="library.user.menu.home" bundle="${msg}"/></a>--%>
                <%--</li>--%>
                <%--<li>--%>
                    <%--<a href="/library/user/books"><fmt:message key="library.user.menu.books" bundle="${msg}"/></a>--%>
                <%--</li>--%>
                <%--<li>--%>
                    <%--<a href="/library/user/books/genre"><fmt:message key="library.user.menu.books.by.genre"--%>
                                                                     <%--bundle="${msg}"/></a>--%>

                <%--</li>--%>
                <%--<li>--%>

                    <%--<form id="register-form" action="/library/search" method="post" role="form">--%>
                        <%--<input type="search" id="searchValue" name="searchValue"--%>
                               <%--placeholder="Search the site..." size="50">--%>
                        <%--<button>Search</button>--%>
                        <%--<br>--%>
                        <%--<input type="radio" name="filter" value="author" checked> author--%>
                        <%--<input type="radio" name="filter" value="title"> title--%>
                        <%--<input type="radio" name="filter" value="keywords"> keywords--%>
                    <%--</form>--%>

                <%--</li>--%>

            <%--</ul>--%>
        <%--</nav>--%>
    <%--</div>--%>
<%--</div>--%>


<div class="welcome-index"><fmt:message key="library.welcome" bundle="${msg}"/></div>
<div class="welcome-text"><fmt:message key="library.welcome.text" bundle="${msg}"/></div>
<div class="welcome-sign-in-out"><fmt:message key="library.sign.in.or.sign.out" bundle="${msg}"/></div>

<jsp:include page="WEB-INF/view/jsp/fragment/footer.jsp"/>
</body>
</html>
