package ua.kiyv.training.library.controller.command.search;

import ua.kiyv.training.library.dao.By;
import ua.kiyv.training.library.dao.DaoFactory;
import ua.kiyv.training.library.model.Book;

import java.util.List;

public interface FindByService {

    List<Book> findBy(String searchValue, By query);


    static FindByService getInstance(){
        return DaoFactory.getInstance().createBookDao()::findBy;
    }

    static FindByService getInstanc(){
        return new FindByService(){
            @Override
            public List<Book> findBy(String searchValue, By query) {
                return DaoFactory.getInstance().createBookDao().findBy(searchValue, query);
            }
        };
    }
}
