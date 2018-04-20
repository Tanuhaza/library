package ua.kiyv.training.library.service.Impl;

import ua.kiyv.training.library.service.BookService;
import ua.kiyv.training.library.service.ServiceFactory;
import ua.kiyv.training.library.service.UserService;

public class ServiceFactoryImpl extends ServiceFactory {
//    private ServiceFactoryImpl(){};
    @Override
    public UserService createUserService() {
        return new UserServiceImpl();
    }

    @Override
    public BookService createBookService() {
        return new BookServiceImpl();
    }
}
