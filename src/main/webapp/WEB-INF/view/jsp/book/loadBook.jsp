<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <fmt:setLocale value="${sessionScope['locale']}"/>
    <fmt:requestEncoding value="UTF-8"/>
    <fmt:setBundle basename="${sessionScope['bundleFile']}" var="msg"/>
    <meta charset="utf-8">
    <title>Title</title>
    <link rel="stylesheet" href="/css/login.css">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/login.js"></script>
    <script src="/js/login-form-initializer.js"></script>
    <script src="/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="../admin/header.jsp"/>

<form id="register-form" action="/loadBook" method="post" role="form"   >
    <div class="form-group">
        <input type="text" name="title" id="title" tabindex="1" class="form-control"
               placeholder="<fmt:message key="library.addBook.placeholder.title" bundle="${msg}"/>"
               value="${requestScope.previousUserName}" required>
    </div>
    <div class="form-group">
        <input type="text" name="decription" id="description" tabindex="1" class="form-control"
               placeholder="<fmt:message key="library.addBook.placeholder.description" bundle="${msg}"/>"
               value="${requestScope.previousUserSurname}" required>
    </div>
    <div class="form-group">
        <input type="text" name="picture" id="picture" tabindex="1" class="form-control"
               placeholder="<fmt:message key="library.addBook.placeholder.picture" bundle="${msg}" />"
               value="${requestScope.previousUserEmail}" required>
    </div>


    <div class="form-group">
        <input type="text" name="avaliable" id="avaliable" tabindex="1" class="form-control"
               placeholder="<fmt:message key="library.addBook.placeholder.available" bundle="${msg}"/>"
               value="${requestScope.previousUserLogin}" required>
    </div>

    <div class="form-group">
        <input type="text" name="quantity" id="quantity" tabindex="1" class="form-control"
               placeholder="<fmt:message key="library.addBook.placeholder.quantity" bundle="${msg}"/>"
               value="${requestScope.previousUserLogin}" required>
    </div>

    <div class="form-group">
        <input type="text" name="year" id="year" tabindex="1" class="form-control"
               placeholder="<fmt:message key="library.addBook.placeholder.year" bundle="${msg}"/>"
               value="${requestScope.previousUserLogin}" required>
    </div>

    <div class="form-group">
        <input type="text" name="genre" id="genre" tabindex="1" class="form-control"
               placeholder="<fmt:message key="library.addBook.placeholder.genre" bundle="${msg}"/>"
               value="${requestScope.previousUserLogin}" required>
    </div>

    <div class="form-group">
        <input type="text" name="keywords" id="keywords" tabindex="1" class="form-control"
               placeholder="<fmt:message key="library.addBook.placeholder.keyword" bundle="${msg}"/>"
               value="${requestScope.previousUserLogin}" required>
    </div>

    <div class="form-group">
        <div class="row">
            <div class="col-sm-6 col-sm-offset-3">
                <input type="submit" name="register-submit" id="register-submit"
                       tabindex="4" class="form-control btn btn-register"
                       value="<fmt:message key="library.register" bundle="${msg}"/>">
            </div>
        </div>
    </div>
</form>
</body>
</html>
