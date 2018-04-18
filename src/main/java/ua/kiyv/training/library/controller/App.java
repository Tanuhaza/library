package ua.kiyv.training.library.controller;

import ua.kiyv.training.library.model.Book;
import ua.kiyv.training.library.model.Role;
import ua.kiyv.training.library.model.User;
import ua.kiyv.training.library.service.BookService;
import ua.kiyv.training.library.service.Impl.UserServiceImpl;
import ua.kiyv.training.library.service.ServiceFactory;
import ua.kiyv.training.library.service.UserService;

import java.util.List;
import java.util.Optional;

/**
 * Created by Tanya on 17.04.2018.
 */
public class App {
    public static void main(String[] args) {
        User user=new User("Tania","Zabolotko","wariushas@gmail","097394476","qwert", Role.USER);
        UserService userService =  ServiceFactory.getInstance().createUserService();
//        userService.create(user);
//        System.out.println( userService.findById(1));
//        System.out.println( userService.findAll());

        BookService bookService = ServiceFactory.getInstance().createBookService();
        Book book =new Book("tuiyi","hhhh","jhkj",4,true,3,1978,1,"hffj,hfhf");
book.setId(1);
book.setTitle("RED STARS");
//       bookService.create(book);
bookService.update(book);
    }
}
