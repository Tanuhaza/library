<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="ua.kiyv.training.library.utils.constants.Attributes" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/css/home.css">
    <link rel="stylesheet" href="/css/library.css">
    <fmt:setBundle basename="${sessionScope['bundleFile']}" var="msg"/>
    <title>home page</title>
</head>
<body class="body-profile-container">
<jsp:include page="../admin/header.jsp"/>

<div class="btn btn-success btn-lg">
    <a href="/library/admin/book/load"><fmt:message key="library.admin.LoadBook" bundle="${msg}"/></a>
</div>

<div class="container">
    <div class="row">
        <c:forEach var="book" items="${books}">
            <div class="col-lg-4">
                <div class="book-box">

                    <tr>
                        <div class="book-id">${book.id}</div>
                        <div class="book-title">${book.title}</div>
                        <div class="book-year">${book.year}</div>
                        <c:forEach var="author" items="${book.authors}" >
                            <div class="book-author">
                            <div class="book-author-name">${author.firstName}</div>
                            <div class="book-author-name">${author.lastName}</div>
                            </div>
                        </c:forEach>

                        <div class="info-bottom">
                            <div class="book-image"><img src="/icons/${book.pictureId}.jpg" alt="picture"></div>

                            <div class="order">
                                <form action="/library/admin/book/edit" method="post" class="navbar-form navbar-right">
                                    <input type="hidden" name="command" value="openBook">
                                    <input type="hidden" name="bookId" value="${book.id}">
                                    <input type="hidden" name="title" value="${book.title}">
                                    <input type="hidden" name="description" value="${book.description}">
                                    <input type="hidden" name="quantity" value="${book.quantity}">
                                    <input type="hidden" name="year" value="${book.year}">
                                    <input type="hidden" name="keywords" value="${book.keywords}">
                                    <input type="hidden" name="picture" value="${book.pictureId}">
                                    <c:forEach var="author" items="${book.authors}" begin="1" end="1">
                                    <input type="hidden" name="first_author_name" value="${author.firstName}">
                                    <input type="hidden" name="first_author_surname" value="${author.lastName}">
                                    </c:forEach>
                                    <input type="submit" value="<fmt:message key="library.admin.editBook"/>"
                                           class="btn btn-success btn-lg">
                                </form>
                                <form action="/library/admin/book/delete" method="post"
                                      class="navbar-form navbar-right">
                                    <input type="hidden" name="command" value="openBook">
                                    <input type="hidden" name="bookId" value="${book.id}">
                                    <input type="submit" value="<fmt:message key="library.admin.deleteBook"/>"
                                           class="btn btn-success btn-lg">
                                </form>
                            </div>
                        </div>
                    </tr>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<jsp:include page="../fragment/footer.jsp"/>
</body>
</html>