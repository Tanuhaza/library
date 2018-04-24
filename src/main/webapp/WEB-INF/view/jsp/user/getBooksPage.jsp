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
<jsp:include page="../user/header.jsp"/>


<div class="container">
    <div class="row">
<c:forEach var="book" items="${books}">
   <div class="col-lg-4">
       <div class="book-box">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.year}</td>
                <td>${book.quantity}</td>
                <td>
                    <form action="/library/admin/book/edit" method="post" class="navbar-form navbar-right">
                        <input type="hidden" name="command" value="openBook">
                        <input type="hidden" name="bookId" value="${book.id}">
                        <input type="hidden" name="title" value="${book.title}">
                        <input type="hidden" name="description" value="${book.description}">
                        <input type="hidden" name="quantity" value="${book.quantity}">
                        <input type="hidden" name="year" value="${book.year}">
                        <input type="hidden" name="keywords" value="${book.keywords}">
                        <input type="hidden" name="picture" value="${book.pictureId}">
                        <%--<input type="hidden" name="first_author_name" value="${book.getAuthors.}">--%>
                            <%--<input type="hidden" name="bookNumber" value="${book.inventoryNumber}">--%>
                        <input type="submit" value="<fmt:message key="library.admin.editBook"/>"
                               class="btn btn-success btn-lg">
                    </form>
                </td>

                <td>
                    <form action="/library/admin/book/delete" method="post" class="navbar-form navbar-right">
                        <input type="hidden" name="command" value="openBook">
                        <input type="hidden" name="bookId" value="${book.id}">
                        <input type="submit" value="<fmt:message key="library.admin.deleteBook"/>"
                               class="btn btn-success btn-lg">
                    </form>
                </td>
            </tr>
       </div>
   </div>
    </c:forEach>
<%--</c:forEach>--%>
    </div>
</div>

<jsp:include page="../fragment/footer.jsp"/>
</body>
</html>