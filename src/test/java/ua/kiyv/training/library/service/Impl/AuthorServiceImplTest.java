package ua.kiyv.training.library.service.Impl;

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
import ua.kiyv.training.library.model.User;
import ua.kiyv.training.library.service.AuthorService;
import ua.kiyv.training.library.service.BookService;

import javax.xml.ws.Service;

import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by Tanya on 21.05.2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class AuthorServiceImplTest {

    @Mock
    private AuthorDao authorDao;

    @InjectMocks
    private AuthorService authorService = AuthorServiceImpl.getInstance();
    private static Author author;

    @BeforeClass
    public static void init() {
        author = new Author();
    }

    @Test
    public void testCreateAuthor() {
        doNothing().when(authorDao).create(author);
        authorService.create(author);
        verify(authorDao, times(1)).create(author);
    }

    @Test(expected = ServiceException.class)
    public void testAuthorWithExistingUnique_Ciper() {
        doThrow(new DaoException("Author with such first last name exists")).when(authorDao).create(author);
        authorService.create(author);
        verify(authorDao, times(1)).create(author);
    }
}
