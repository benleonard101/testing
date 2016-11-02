package com.kainos.training.dropwizard.login.frontends.views;

/**
 * Created by benl on 01/11/2016.
 */

import com.kainos.login.models.Book;
import io.dropwizard.views.View;

/**
 * Created by christopherg on 31/10/2016.
 */
public class BookDetailView extends View {

    private Book book;

    public BookDetailView(Book book) {
        super("/book_detail.ftl");
        this.book = book;
    }

    public Book getBook() {
        return book;
    }


}