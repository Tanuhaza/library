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
    <%--<link rel="stylesheet" href="/css/login.css">--%>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/login.js"></script>
    <script src="/js/login-form-initializer.js"></script>
    <script src="/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="../admin/header.jsp"/>

<div class="container">
    <div class="form-group">
        <div class="text-center">
            Update Book
        </div>
    </div>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-login">
                <div>
                    <c:if test="${requestScope.errors!=null and requestScope.errors.hasErrors()}">
                        <c:forEach items="${requestScope.errors.getErrorsAttributes()}" var="value">
                            <p1 class="has-error"><fmt:message key="${errors.errors.get(value)}" bundle="${msg}"/></p1>
                            <br>
                        </c:forEach>
                    </c:if>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <form id="register-form" action="/library/admin/book/update" method="post" role="form">
                                <div class="form-group">
                                    <input type="text" name="title" id="title" tabindex="1" class="form-control"
                                           placeholder="<fmt:message key="library.addBook.placeholder.title" bundle="${msg}"/>"
                                           value="${requestScope.previousBookTitle}" required>
                                </div>
                                <div class="form-group">
                                    <input type="text" name="description" id="description" tabindex="1"
                                           class="form-control"
                                           placeholder="<fmt:message key="library.addBook.placeholder.description" bundle="${msg}"/>"
                                           value="${requestScope.previousBookDescription}" required>
                                </div>
                                <div class="form-group">
                                    <input type="text" name="picture" id="picture" tabindex="1" class="form-control"
                                           placeholder="<fmt:message key="library.addBook.placeholder.picture" bundle="${msg}" />"
                                           value="${requestScope.previousBookPictureId}" required>
                                </div>

                                <div class="form-group">
                                    <select id="isAvaliable" name="isAvaliable" class="form-control">
                                        <option selected disabled><fmt:message
                                                key="library.addBook.placeholder.available" bundle="${msg}"/></option>
                                        <%--<option selected value="t4"></option>--%>
                                        <option value="true">True</option>
                                        <option value="false">False</option>
                                    </select>

                                </div>

                                <div class="form-group">
                                    <input type="text" name="quantity" id="quantity" tabindex="1" class="form-control"
                                           placeholder="<fmt:message key="library.addBook.placeholder.quantity" bundle="${msg}"/>"
                                           value="${requestScope.previousBookQuantity}" required>
                                </div>

                                <div class="form-group">
                                    <input type="text" name="year" id="year" tabindex="1" class="form-control"
                                           placeholder="<fmt:message key="library.addBook.placeholder.year" bundle="${msg}"/>"
                                           value="${requestScope.previousBookYear}" required>
                                </div>

                                <div class="form-group">
                                    <select id="genre" name="genre" class="form-control">
                                        <option selected disabled><fmt:message key="library.addBook.placeholder.genre"
                                                                               bundle="${msg}"/></option>
                                        <c:forEach var="genre" items="${genres}">
                                            <option class="form-control" value="${genre.id}">${genre.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <input type="text" name="keywords" id="keywords" tabindex="1" class="form-control"
                                           placeholder="<fmt:message key="library.addBook.placeholder.keyword" bundle="${msg}"/>"
                                           value="${requestScope.previousBookKeywords}" required>
                                </div>

                                <div class="form-group">
                                    <input type="text" name="first_author_name" id="first_author_name" tabindex="1"
                                           class="form-control"
                                           placeholder="<fmt:message key="library.addBook.placeholder.first.author.name" bundle="${msg}"/>"
                                           value="${requestScope.previousAuthorName}" required>
                                </div>
                                <div class="form-group">
                                    <input type="text" name="first_author_surname" id="first_author_surname"
                                           tabindex="1" class="form-control"
                                           placeholder="<fmt:message key="library.addBook.placeholder.first.author.surname" bundle="${msg}"/>"
                                           value="${requestScope.previousAuthorSurname}" required>
                                </div>
                                <%--<div class="form-group">--%>
                                <%--<input type="text" name="second_author_name" id="second_author_name" tabindex="1"--%>
                                <%--class="form-control"--%>
                                <%--placeholder="<fmt:message key="library.addBook.placeholder.second.author.name" bundle="${msg}"/>"--%>
                                <%-->--%>
                                <%--</div>--%>
                                <%--<div class="form-group">--%>
                                <%--<input type="text" name="second_author_surname" id="second_author_surname"--%>
                                <%--tabindex="1" class="form-control"--%>
                                <%--placeholder="<fmt:message key="library.addBook.placeholder.second.author.surname" bundle="${msg}"/>"--%>
                                <%-->--%>
                                <%--</div>--%>

                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <input type="submit" name="register-submit" id="register-submit"
                                                   tabindex="4" class="form-control btn btn-register"
                                                   value="<fmt:message key="library.updateBook.submit" bundle="${msg}"/>">
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
