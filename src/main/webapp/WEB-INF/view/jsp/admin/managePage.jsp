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
    <a href="/library/book/load"><fmt:message key="library.admin.LoadBook" bundle="${msg}"/></a>
</div>
<%--<h2 class="sub-header"><fmt:message key="librarian.catalogue.title"/></h2>--%>
<%--<div class="table-responsive">--%>
<%--<table class="table table-striped">--%>
<thead>
<div class="container">
    <div class="row">
        <tr>
            <th><fmt:message key="library.admin.catalogue.column.bookId"/></th>
            <th><fmt:message key="library.admin.catalogue.column.bookTitle"/></th>
            <th><fmt:message key="library.admin.catalogue.column.bookAuthor"/></th>
            <th><fmt:message key="library.admin.catalogue.column.bookNumber"/></th>
            <th></th>
        </tr>
    </div>
</div>
</thead>
<%--<tbody>--%>
<div class="container">
    <div class="row">
<c:forEach var="book" items="${books}">
   <div class="col-lg-4">
       <div class="book-box">

            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.year}</td>
                    <%--<td>${book.inventoryNumber}</td>--%>
                <td>
                    <form action="/library/book/add" method="post" class="navbar-form navbar-right">
                        <input type="hidden" name="command" value="openBook">
                        <input type="hidden" name="bookId" value="${book.id}">
                        <input type="hidden" name="bookTitle" value="${book.title}">
                            <%--<input type="hidden" name="bookAuthor" value="${book.author}">--%>
                            <%--<input type="hidden" name="bookNumber" value="${book.inventoryNumber}">--%>
                        <input type="submit" value="<fmt:message key="library.admin.editBook"/>"
                               class="btn btn-success btn-lg">
                    </form>
                </td>

                <td>
                    <form action="/library/book/delete" method="post" class="navbar-form navbar-right">
                        <input type="hidden" name="command" value="openBook">
                        <input type="hidden" name="bookId" value="${book.id}">
                        <input type="hidden" name="bookTitle" value="${book.title}">
                            <%--<input type="hidden" name="bookAuthor" value="${book.author}">--%>
                            <%--<input type="hidden" name="bookNumber" value="${book.inventoryNumber}">--%>
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