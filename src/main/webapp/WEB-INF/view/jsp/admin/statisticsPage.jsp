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
    <title>statistics page</title>
</head>
<body>
<jsp:include page="../admin/header.jsp"/>

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
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.phone}</td>
            <td>
                <form action="/library/admin/borrowed/books/user" method="post" class="navbar-form navbar-right">
                    <input type="hidden" name="command" value="openBook">
                    <input type="hidden" name="userId" value="${user.id}">
                    <input type="submit" value="<fmt:message key="library.admin.checkBook"/>"
                           class="btn btn-success btn-lg">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
    <jsp:include page="../fragment/paginator.jsp"/>
</table>
</body>
</html>

