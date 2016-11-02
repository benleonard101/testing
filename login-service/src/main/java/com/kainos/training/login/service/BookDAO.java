package com.kainos.training.login.service;

import com.kainos.login.models.Book;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by benl on 02/11/2016.
 */
public class BookDAO extends AbstractDAO<Book> {
    /**
     * Constructor.
     *
     * @param sessionFactory Hibernate session factory.
     */
    public BookDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    /**
     * Method returns all employees stored in the database.
     *
     * @return list of all employees stored in the database
     */
    public List<Book> findAll() {
        return list(namedQuery("com.kainos.login.models.Book.findAll"));
    }
    /**
     * Looks for employees whose first or last name contains the passed
     * parameter as a substring.
     *
     * @param id query parameter
     * @return list of employees whose first or last name contains the passed
     * parameter as a substring.
     */
    public Book findById(int id) {
//        StringBuilder builder = new StringBuilder("%");
//        builder.append(id).append("%");
        return
               uniqueResult(namedQuery("com.kainos.login.models.Book.findById")
                        .setParameter("id", id));
    }
//    /**
//     * Method looks for an employee by her id.
//     *
//     * @param id the id of an employee we are looking for.
//     * @return Optional containing the found employee or an empty Optional
//     * otherwise.
//     */
//    public Optional<Book> findById(long id) {
//        return Optional.fromNullable(get(id));
//    }
}