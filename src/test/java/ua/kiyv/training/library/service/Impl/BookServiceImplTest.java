package ua.kiyv.training.library.service.Impl;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.kiyv.training.library.dao.AuthorDao;
import ua.kiyv.training.library.dao.BookDao;
import ua.kiyv.training.library.exception.DaoException;
import ua.kiyv.training.library.exception.ServiceException;
import ua.kiyv.training.library.model.Author;
import ua.kiyv.training.library.model.Book;
import ua.kiyv.training.library.service.BookService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by Tanya on 21.05.2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class BookServiceImplTest {

    @Mock
    private BookDao bookDao;

    @Mock
    private AuthorDao authorDao;

    @InjectMocks
    private BookService bookService = BookServiceImpl.getInstance();

    private static Book book;
    private static Book book1;
    private static Author author;

    @BeforeClass
    public static void init() {
        book = new Book();
        book1 = new Book();
        author = new Author();
    }

    @Test
    public void testCreateBookWithExistingAuthor() {

        doNothing().when(bookDao).create(book);
        when(authorDao.findByFirstLastName(author.getFirstName(), author.getLastName()))
                .thenReturn(author);
        doNothing().when(bookDao).matchBookAuthor(book, author);

        bookService.createBookAuthor(book, author);
        verify(authorDao).findByFirstLastName(author.getFirstName(), author.getLastName());
        verify(authorDao, never()).create(author);
        verify(bookDao).matchBookAuthor(book, author);
    }

    @Test
    public void testCreateBookWithNewAuthor() {
        doNothing().when(bookDao).create(book);
        when(authorDao.findByFirstLastName(author.getFirstName(), author.getLastName()))
                .thenThrow(DaoException.class);
        doNothing().when(bookDao).matchBookAuthor(book, author);
        doNothing().when(authorDao).create(author);

        bookService.createBookAuthor(book, author);
        verify(bookDao).create(book);
        verify(authorDao).findByFirstLastName(author.getFirstName(), author.getLastName());
        verify(authorDao).create(author);
        verify(bookDao).matchBookAuthor(book, author);
    }

    @Test(expected = ServiceException.class)
    public void testBookWasNotCreated() {
        doThrow(new DaoException("Book wasn't create")).when(bookDao).create(book);
        bookService.createBookAuthor(book, author);
        verify(authorDao).create(author);
    }

    @Test
    public void testFindAllBooks() {
        when(bookDao.findAll()).thenReturn(Arrays.asList(book1, book));
        List<Book> books = bookService.findAllBooks();
        Assert.assertEquals(2, books.size());
        verify(bookDao, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        when(bookDao.findById(1)).thenReturn(book);
        bookService.findById(1);
        verify(bookDao, times(1)).findById(1);
    }

    @Test(expected = ServiceException.class)
    public void testBookByIdIsNotExist() {
        when(bookDao.findById(1)).thenReturn(null);
        bookService.findById(1);
        verify(bookDao, times(1)).findById(1);
    }
}

