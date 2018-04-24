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
    <div class="row">
<c:forEach var="borrowedBook" items="${borrowedBooks}">
    <%--<c:forEach var="author" items="${books.getAuthors}">--%>
   <div class="col-lg-4">
       <div class="book-box">
            <tr>
                <td>${borrowedBook.title}</td>
                <td>${borrowedBook.year}</td>
                <td>${borrowedBook.pictureId}</td>
                <td>${borrowedBook.startDate}</td>
                <td>${borrowedBook.dueToReturnDate}</td>
                <td>
                    <form action="/library/admin/book/edit" method="post" class="navbar-form navbar-right">
                        <input type="hidden" name="command" value="openBook">
                        <input type="hidden" name="bookId" value="${borrowedBook.id}">
                        <input type="hidden" name="title" value="${borrowedBook.title}">
                        <input type="hidden" name="description" value="${borrowedBook.description}">
                        <input type="hidden" name="quantity" value="${borrowedBook.quantity}">
                        <input type="hidden" name="year" value="${borrowedBook.year}">
                        <input type="hidden" name="keywords" value="${borrowedBook.keywords}">
                        <input type="hidden" name="picture" value="${borrowedBook.pictureId}">
                        <%--<input type="hidden" name="first_author_name" value="${borrowedBook.getAuthors.}">--%>
                            <%--<input type="hidden" name="borrowedBookNumber" value="${book.inventoryNumber}">--%>
                        <input type="submit" value="<fmt:message key="library.admin.editBook"/>"
                               class="btn btn-success btn-lg">
                    </form>
                </td>

                <td>
                    <form action="/library/admin/book/delete" method="post" class="navbar-form navbar-right">
                        <input type="hidden" name="command" value="openBook">
                        <input type="hidden" name="bookId" value="${borrowedBook.id}">
                        <input type="submit" value="<fmt:message key="library.admin.deleteBook"/>"
                               class="btn btn-success btn-lg">
                    </form>
                </td>
            </tr>
       </div>
   </div>
    </c:forEach>
    </div>
</div>

<jsp:include page="../fragment/footer.jsp"/>
</body>
</html>