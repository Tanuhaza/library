package ua.kiyv.training.library.dao;

import ua.kiyv.training.library.model.Author;

public interface AuthorDao extends GenericDao<Author> {
    public Author findByFirstLastName(String firstName,String lastName);
}
