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
    <fmt:setLocale value="${sessionScope['locale']}"/>
    <fmt:requestEncoding value="UTF-8"/>
    <fmt:setBundle basename="${sessionScope['bundleFile']}" var="msg"/>
    <title>Description</title>
</head>
<body class="body-profile-container">
<jsp:include page="../admin/header.jsp"/>
<div class="book-description-box">
    <div>${book.id}</div>
    <div>${book.title}</div>
    <div>${book.year}</div>

    <div class="book-authors-box">
        <c:forEach var="author" items="${book.authors}">
            <div class="book-author">
                <div class="book-author-name">${author.firstName}</div>
                <div class="book-author-name">${author.lastName}</div>
            </div>
        </c:forEach>

        <div>${book.description}</div>
    </div>
    <div class="book-image"><img src="/icons/${book.pictureId}.jpg" alt="picture"></div>
</div>
</body>