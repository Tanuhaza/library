package ua.kiyv.training.library.controller;


import ua.kiyv.training.library.dao.*;
import ua.kiyv.training.library.dao.connection.DaoConnection;
import ua.kiyv.training.library.dao.connection.Jdbc.JdbcTransactionHelper;
import ua.kiyv.training.library.exception.ServiceException;
import ua.kiyv.training.library.model.*;
import ua.kiyv.training.library.service.AuthorService;
import ua.kiyv.training.library.service.BookService;
import ua.kiyv.training.library.service.Impl.AuthorServiceImpl;
import ua.kiyv.training.library.service.Impl.BookServiceImpl;
import ua.kiyv.training.library.service.Impl.UserServiceImpl;
import ua.kiyv.training.library.service.UserService;
import ua.kiyv.training.library.utils.constants.MessageKeys;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * Created by Tanya on 17.04.2018.
 */
public class App {
    public  void meth() {
        synchronized (this.getClass()) {

        }
    }

    public static void meth2() {
        synchronized (App.class) {

        }
    }

    public static void main(String[] args) {
        System.out.println(new Book().getClass() == Book.class);


//        User user=new User("Tania","Zabolotko","wariushas@gmail","097394476","qwert", Role.USER);
//        UserService userService =  ServiceFactory.getInstance().createUserService();
////        userService.create(user);
////        System.out.println( userService.findById(2));
////       System.out.println( userService.findAll());
////        System.out.println(userService.getUserByEmailPassword("admin@gmail.com","java1love"));
        UserDao userDao = DaoFactory.getInstance().createUserDao();
//
//        AuthorDao authorDao =DaoFactory.getInstance().createAuthorDao();
//        System.out.println(authorDao.findByFirstLastName("Greate","Author"));
        BookDao bookDao =DaoFactory.getInstance().createBookDao();
        Book book =new Book(1,"Red Stars","Amazing","1",4,2000,true,2,"star",1);
        bookDao.update(book);

//       AuthorService authorService = AuthorServiceImpl.getInstance();
//        System.out.println(bookService.findAllBooks());
//       Optional<Book> book =
//              Book book = bookService.findById(1);
//        System.out.println(book);
//        String email="wariushas1@gmail.com";
//                String password="root";
//        Optional.of(userDao.findUserByEmail(email)).filter(person -> password.equals(person.getPassword()))
//                .orElseThrow(() -> new ServiceException(MessageKeys.WRONG_LOGIN_DATA));
//       if(book.isPresent()){
//           Book book1 =book.get();
//           System.out.println(book1);
//       }
//        System.out.println(bookService.findByAuthor("sco"));
////        AuthorService authorService = ServiceFactory.getInstance().createAuthorService();
////        Book book =new Book("tuiyi","hhhh","jhkj",4,true,3,1978,1,"hffj,hfhf");
////book.setId(1);
////book.setTitle("RED STARS");
////      bookService.create(book);
////bookService.update(book);
////        System.out.println(bookService.findAll());
////        System.out.println(bookService.findById(1));
//        bookService.delete(100);
//        System.out.println(bookService.findAllGenres());
//        DaoConnection connection = JdbcTransactionHelper.getInstance().getConnection();
//        try {
//            Statement statement = connection.createStatement();
//            statement.executeUpdate("DELETE FROM book_author WHERE book_id = 100");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        List<BorrowedBook> borrowedBooks =new ArrayList<>();
//        borrowedBooks=bookService.findAllBorrowedBooksByUserId(2);
//        System.out.println(bookService.findAllBorrowedBooksByUserId(2));
//        System.out.println(borrowedBooks.get(1).getId());
//        System.out.println(borrowedBooks.get(1).getTitle());
//        System.out.println(borrowedBooks.get(1).getStartDate());
//        System.out.println(borrowedBooks.get(1).getDueToReturnDate());
//        System.out.println( bookService.findByGenreId(1));
//        Parent parent=new Parent("green","white",30,180);

//        Child child =new Child("gambling","45");
//        System.out.println(child.getEyesColor());
//        Parent child1 =child;
//        Child child2=new Parent();
//        Date d =new Date();
//        System.out.println(d);
//        Calendar.getInstance().setTime(d);
////        c.setTime(d);
//        c.add(Calendar.MONTH,1);
//        Date d2=c.getTime();
//        System.out.println(d2);

//            String john = null;
//            Optional<String> name = Optional.of(john);
//            System.out.println(name); //output Optional.empty
//       if (name.isPresent())
//        System.out.println(name.get());


    }
}
