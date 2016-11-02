package com.kainos.training.dropwizard.login.frontends.resources;

import com.codahale.metrics.annotation.Timed;
import com.kainos.login.models.Book;
import com.kainos.training.dropwizard.login.frontends.views.*;
import com.kainos.training.jersey.client.BooksClient;
import com.kainos.training.jersey.client.LoginClient;
import io.dropwizard.views.View;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/test")
public class ViewsResource {

    public LoginClient loginClient;
    public BooksClient booksClient;

    public ViewsResource(LoginClient loginClient, BooksClient booksClient) {
        this.loginClient = loginClient;
        this.booksClient = booksClient;
    }

    @GET
    @Timed
    @Path("/login")
    @Produces(MediaType.TEXT_HTML)
    public View login() {


        return new Index();
    }

    @POST
    @Timed
    @Path("login-details")
    @Produces(MediaType.TEXT_HTML)
    public View loginDetails(@FormParam("username") String username,
                             @FormParam("password") String password) {

        if (loginClient.getLogin(username, password)) {
            String listOfNames = loginClient.listOfUsersAsAString();

            // System.out.println(listOfNames);

            return new LoginSuccessView(listOfNames);
        }

        return new LoginFailureView();
    }

    @GET
    @Timed
    @Path("/books")
    @Produces(MediaType.TEXT_HTML)
    public View bookView() {

        List<Book> books = booksClient.getBooks();

        return new BookView(books);
    }

    @GET
    @Timed
    @Path("/books/{id}")
    @Produces(MediaType.TEXT_HTML)
    public View bookDetailView(@PathParam("id") int id) {

       Book book = booksClient.getBook(id);

        return new BookDetailView(book);
    }




}
