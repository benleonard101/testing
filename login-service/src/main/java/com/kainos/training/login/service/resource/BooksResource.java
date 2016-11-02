package com.kainos.training.login.service.resource;

import com.kainos.training.login.service.BookDAO;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
public class BooksResource {


    // public List<Book> books = new ArrayList<>();

    private BookDAO dao;


    public BooksResource(BookDAO dao) {

        this.dao = dao;

//        Book book1 = new Book();
//        book1.setId(1);
//        book1.setAuthor("Ben");
//        book1.setTitle("Bens Book");
//        book1.setGenre(Genre.HORROR);
//        book1.setPublishDate(DateTime.now());
//
//        Book book2 = new Book();
//        book2.setId(2);
//        book2.setAuthor("Josh");
//        book2.setTitle("Josh Book");
//        book2.setGenre(Genre.HORROR);
//        book2.setPublishDate(DateTime.now());
//
//        Book book3 = new Book();
//        book3.setId(3);
//        book3.setAuthor("Ann");
//        book3.setTitle("Ann Book");
//        book3.setGenre(Genre.HORROR);
//        book3.setPublishDate(DateTime.now());
//
//
//        books.add(book1);
//        books.add(book2);
//        books.add(book3);

    }


    @GET
    @UnitOfWork
    public Response getBooks() {


        return Response
                .status(Response.Status.OK)
                .entity(dao.findAll())
                .build();
    }

// version 1
//    @GET
//    @Path("/{id}")
//    public Response getBook(@PathParam("id") int id) {
//
//
//        for (Book book:books) {
//            if(book.getId() == id){
//
//                return Response
//                        .status(Response.Status.OK)
//                        .entity(book)
//                        .build();
//            }
//
//        }
//
//        return Response
//                .status(Response.Status.NO_CONTENT)
//                .entity("Not found!")
//                .build();
//    }


    @GET
    @UnitOfWork
    @Path("/{id}")
    public Response getBook(@PathParam("id") int id) {


        return Response
                .status(Response.Status.OK)
                .entity(dao.findById(id))
                .build();
    }


}
