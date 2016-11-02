package com.kainos.training.login.service.resource;

import com.kainos.login.models.Book;
import com.kainos.login.models.Genre;
import org.joda.time.DateTime;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
public class BooksResource {


    public List<Book> books = new ArrayList<>();


    public BooksResource() {

        Book book1 = new Book();
        book1.setId(1);
        book1.setAuthor("Ben");
        book1.setTitle("Bens Book");
        book1.setGenre(Genre.HORROR);
        book1.setPublishDate(DateTime.now());

        Book book2 = new Book();
        book2.setId(2);
        book2.setAuthor("Josh");
        book2.setTitle("Josh Book");
        book2.setGenre(Genre.HORROR);
        book2.setPublishDate(DateTime.now());

        Book book3 = new Book();
        book3.setId(3);
        book3.setAuthor("Ann");
        book3.setTitle("Ann Book");
        book3.setGenre(Genre.HORROR);
        book3.setPublishDate(DateTime.now());


        books.add(book1);
        books.add(book2);
        books.add(book3);

    }


    @GET
    public Response getBooks() {


        return Response
                .status(Response.Status.OK)
                .entity(books)
                .build();
    }


    @GET
    @Path("/{id}")
    public Response getBook(@PathParam("id") int id) {


        for (Book book:books) {
            if(book.getId() == id){

                return Response
                        .status(Response.Status.OK)
                        .entity(book)
                        .build();
            }

        }

        return Response
                .status(Response.Status.NO_CONTENT)
                .entity("Not found!")
                .build();
    }





}
