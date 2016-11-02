package com.kainos.login.models;

import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by christopherg on 31/10/2016.
 */

@Entity
@Table(name = "Book")
@NamedQueries({
        @NamedQuery(name = "com.kainos.login.models.Book.findAll",
                query = "select b from Book b"),
        @NamedQuery(name = "com.kainos.login.models.Book.findById",
                query = "select b from Book b "
                        + "where b.id like :id")
})
public class Book {

    @Column(name = "author")
    private String author;

    @Column(name = "title")
    private String title;

    @Column(name = "publishDate")
    private DateTime publishDate;

    @Column(name="genre")
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Book(){}

    public Book(String author, String title, DateTime publishDate, Genre genre) {
        this.author = author;
        this.title = title;
        this.publishDate = publishDate;
        this.genre = genre;

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(DateTime publishDate) {
        this.publishDate = publishDate;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
