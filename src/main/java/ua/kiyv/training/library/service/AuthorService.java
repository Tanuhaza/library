package ua.kiyv.training.library.service;

import ua.kiyv.training.library.model.Author;


/**
 * Author service
 */
public interface AuthorService {
    void create(Author author);

    void update(Author author);
}
