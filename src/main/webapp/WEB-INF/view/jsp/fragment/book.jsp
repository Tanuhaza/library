<div class="col-lg-4">
    <div class="book-box">
        <div class="book-title">
            <div class="book-id">${book.id}</div>
            ${book.title}</div>
        <div class="book-authors-box">
            <c:forEach var="author" items="${book.authors}">
                <div class="book-author">
                    <div class="book-author-name">${author.firstName}</div>
                    <div class="book-author-name">${author.lastName}</div>
                </div>
            </c:forEach>
        </div>
        <div class="info-bottom">
            <div class="detail-info"><a href="/library/user/book/${book.id}"><fmt:message
                    key="library.user.book.detail.info" bundle="${msg}"/></a></div>

            <div class="book-image"><img src="/icons/${book.pictureId}.jpg" alt="picture"></div>
            <div class="order">
                <c:choose>
                    <c:when test="${book.avaliable}">
                        <form action="/library/user/book/order" method="post"
                              class="navbar-form button">
                            <input type="hidden" name="command" value="openBook">
                            <input type="hidden" name="bookId" value="${book.id}">
                            <input type="submit" value="<fmt:message key="library.user.submit.order"/>"
                                   class="btn btn-success btn-lg">
                        </form>
                    </c:when>
                    <c:otherwise>
                        <div class="isAvaliable">
                            <fmt:message key="library.user.book.is.not.available"/>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</div>
