package ua.kiyv.training.library.service;

import ua.kiyv.training.library.model.Book;
import ua.kiyv.training.library.model.User;

/**
 * Created by Tanya on 17.04.2018.
 */
public interface BookService {
    void create(Book book);
    void update(Book book);
}
