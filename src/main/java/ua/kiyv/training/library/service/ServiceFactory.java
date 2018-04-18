package ua.kiyv.training.library.service;

import ua.kiyv.training.library.dao.AuthorDao;
import ua.kiyv.training.library.service.Impl.ServiceFactoryImpl;

public abstract class ServiceFactory {
    private static ServiceFactory serviceFactory;

    public abstract UserService createUserService();
    public abstract BookService createBookService();

    public static ServiceFactory getInstance() {
        if(serviceFactory==null) {
            synchronized (ServiceFactory.class) {
                if (serviceFactory == null) {
                    ServiceFactory temp = new ServiceFactoryImpl();
                    serviceFactory = temp;
                }
            }
        }
        return serviceFactory;
    }
}
