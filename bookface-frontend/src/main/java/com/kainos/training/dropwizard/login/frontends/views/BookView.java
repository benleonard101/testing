package com.kainos.training.dropwizard.login.frontends.views;

/**
 * Created by benl on 01/11/2016.
 */

import com.kainos.login.models.Book;
import io.dropwizard.views.View;

import java.util.List;

/**
 * Created by christopherg on 31/10/2016.
 */
public class BookView extends View {

    private final List<Book> books;

    private int bookCount;

    public BookView(List<Book> books) {
        super("/list.ftl");
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public int getBookCount() {
        return books.size();
    }
}