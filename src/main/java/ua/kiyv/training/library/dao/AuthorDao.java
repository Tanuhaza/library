package ua.kiyv.training.library.dao;

import ua.kiyv.training.library.model.Author;

/**
 * DAO for Author entity
 */

public interface AuthorDao extends GenericDao<Author> {

    /**
     * find Author by their first and last name
     *
     * @param firstName
     * @param lastName
     * @return
     */
    Author findByFirstLastName(String firstName, String lastName);
}
