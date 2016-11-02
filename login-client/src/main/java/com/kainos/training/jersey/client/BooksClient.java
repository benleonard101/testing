package com.kainos.training.jersey.client;

import com.kainos.login.models.Book;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by benl on 01/11/2016.
 */
public class BooksClient {

    private final String BASE_URL = "http://localhost:8080";

    private final String REQUEST_ENCODING = "application/x-www-form-urlencoded";

    private final int SUCCESS_RESPONSE = 200;

    private WebTarget booksWebTarget;

    public BooksClient() {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(BASE_URL);
        booksWebTarget = webTarget.path("books");
    }

    public List<Book> getBooks() {

        Invocation.Builder invocationBuilder = booksWebTarget.request();
        Response response = invocationBuilder.get();

        return response.readEntity(new GenericType<List<Book>>() {
        });

    }

    public Book getBook(int id) {

        Invocation.Builder invocationBuilder = booksWebTarget.path(String.valueOf(id)).request();
        Response response = invocationBuilder.get();

        return response.readEntity(Book.class);

    }
}
