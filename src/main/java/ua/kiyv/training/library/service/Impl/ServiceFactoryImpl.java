package ua.kiyv.training.library.service.Impl;

import ua.kiyv.training.library.service.ServiceFactory;
import ua.kiyv.training.library.service.UserService;

public class ServiceFactoryImpl extends ServiceFactory {
    @Override
    public UserService createUserService() {
        return new UserServiceImpl();
    }
}
