package ua.kiyv.training.library.service;

import ua.kiyv.training.library.service.Impl.ServiceFactoryImpl;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

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
