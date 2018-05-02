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
<%--<div class="user-welcome">--%>
    <%--<div  class ="welcome" align="center"><fmt:message key="library.you.are.welcom" bundle="${msg}"/></div>--%>
    <%--<div class="user-first-last-name" align="center">${user.firstName}<span style='padding-left:10px;'> </span>${user.lastName}</div>--%>
<%--</div>--%>

<div class="container">
    <div class="row">
        <c:forEach var="borrowedBook" items="${borrowedBooks}">
            <div class="col-lg-4">
                <div class="book-box">
                    <tr>
                        <div class="book-id">${borrowedBook.id}</div>
                        <div class="book-title">${borrowedBook.title}</div>
                        <div class="book-year">${borrowedBook.year}</div>
                        <div class ="book-available">${borrowedBook.avaliable}</div>
                        <div class="info-bottom">
                            <div class="book-image"><img src="/icons/${borrowedBook.pictureId}.jpg" alt="picture"></div>
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