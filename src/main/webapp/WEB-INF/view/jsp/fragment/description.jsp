<div class="book-description-box">
    <div class="book-description-main-info">
        <div class="book-title">Inventory number - ${book.id}</div>
        <div class="book-year">${book.title}</div>
        <div class="book-year">${book.year} year</div>
    </div>

    <div class="book-authors-box">
        <c:forEach var="author" items="${book.authors}">
            <div class="book-author">
                <div class="book-author-name">${author.firstName}</div>
                <div class="book-author-name">${author.lastName}</div>
            </div>
        </c:forEach>

        <div class="book-description">${book.description}</div>
    </div>
    <div class="book-image"><img src="/icons/${book.pictureId}.jpg" alt="picture"></div>
</div>
