package ua.kiyv.training.library.service.Impl;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.kiyv.training.library.dao.UserDao;
import ua.kiyv.training.library.exception.ServiceException;
import ua.kiyv.training.library.model.User;
import ua.kiyv.training.library.service.UserService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

/**
 * Created by Tanya on 21.05.2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserService userService = UserServiceImpl.getInstance();

    private static User user;
    private static User user1;
    private static final String email = "taniushas@gmail.com";

    @BeforeClass
    public static void init() {
        user = new User();
        user1 = new User();
    }

    @Test
    public void testCreateUser() {
        doNothing().when(userDao).create(user);
        userService.create(user);
        verify(userDao, times(1)).create(user);
    }

    @Test
    public void testFindById() {
        int userId = 1;
        Optional<User> user = userService.findById(userId);
        Assert.assertNotNull(user.get());
        Assert.assertEquals(userId, user.get().getId());
        verify(userDao, times(1)).findById(1);
    }

    @Test(expected = ServiceException.class)
    public void testLoginWithWrongCredentials() {
        user.setPassword("tania");
        when(userDao.findUserByEmail(email)).thenReturn(user);
        String password = "some wrong password";
        userService.getUserByEmailPassword(email, password);
        verify(userDao, times(1)).findUserByEmail(email);
    }

    @Test
    public void testLoginWithCorrectCredentials() {
        user.setPassword("tania");
        when(userDao.findUserByEmail(email)).thenReturn(user);
        String password = "tania";
        userService.getUserByEmailPassword(email, password);
        verify(userDao, times(1)).findUserByEmail(email);
    }

    @Test(expected = ServiceException.class)
    public void testCreateUserWithExistingEmail() {
        doNothing().when(userDao).create(user);
        User user = new User.Builder().setEmail(email).build();
        userService.create(user);
        verify(userDao, times(1)).create(user);
    }

    @Test
    public void testFindAll() {
        when(userDao.findAll()).thenReturn(Arrays.asList(user1, user));
        List<User> users = userService.findAll();
        Assert.assertEquals(2, users.size());
        verify(userDao, times(1)).findAll();
    }
}


