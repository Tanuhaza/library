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

<div class="container">
    <c:set var="user" value="${user}"/>
    <table class="table table-striped">
        <thead>
        <tr>
            <th><fmt:message key="library.admin.column.user.first.name"/></th>
            <th><fmt:message key="library.admin.column.user.last.name"/></th>
            <th><fmt:message key="library.admin.column.user.email"/></th>
            <th><fmt:message key="library.admin.column.user.phone"/></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.phone}</td>
        </tr>
        </tbody>
    </table>
    <div class="row">
        <c:forEach var="book" items="${borrowedBooks}">
            <div class="col-lg-4">
                <div class="book-box-for-added-info">
                    <div class="book-id">${book.id}</div>
                    <div class="book-title">${book.title}</div>

                    <div class="book-authors-box">
                        <c:forEach var="author" items="${book.authors}">
                            <div class="book-author">
                                <div class="book-author-name">${author.firstName}</div>
                                <div class="book-author-name">${author.lastName}</div>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="title-date">
                        <div class="date">Start date:</div>
                        <div class="date">
                            <div class="return-date">Return date:</div>
                        </div>
                    </div>
                    <div class="date">${book.startDate}</div>
                    <div class="date">
                        <div class="return-date">${book.dueToReturnDate}</div>
                    </div>

                    <div class="info-bottom-for-added-info">
                        <div class="detail-info"><a href="/library/user/book/${book.id}"><fmt:message
                                key="library.user.book.detail.info" bundle="${msg}"/></a></div>
                        <div class="book-image"><img src="/icons/${book.pictureId}.jpg" alt="picture"></div>
                        <div class="submit-delete">
                            <form action="/library/admin/borrowed/book/delete" method="post"
                                  class="navbar-form navbar-right">
                                <input type="hidden" name="command" value="openBook">
                                <input type="hidden" name="bookId" value="${book.id}">
                                <input type="hidden" name="userId" value="${user.id}">
                                <input type="submit" value="<fmt:message key="library.admin.deleteBook"/>"
                                       class="btn btn-success btn-lg">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<jsp:include page="../fragment/footer.jsp"/>
</body>
</html>