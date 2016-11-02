package com.kainos.training.dropwizard.login.frontends.resources;

import com.kainos.training.jersey.client.BooksClient;
import com.kainos.training.jersey.client.LoginClient;
import io.dropwizard.views.View;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class ViewsResourceTest {
    private LoginClient client;
    private BooksClient booksClient;
    private ViewsResource viewsResource;

    @Test
    public void checkTheIndexReturnsAView() {
        // arrange


        // act
        View response = viewsResource.login();

        // assert
        Assert.assertEquals(response.getTemplateName(), "/index.ftl");

    }


    @Before
    public void setup() {
        client = mock(LoginClient.class);
        booksClient = mock(BooksClient.class);


        viewsResource = new ViewsResource(client, booksClient);



//        when(client.getLogin("adminuser","password12")).thenReturn(false);

    }

//
//    @Test
//    public void testIncorrectPassword(){
//
//
//        when(client.getLogin("mrFake","madeuppassword")).thenReturn(false);
//
//        // act
//        View response = viewsResource.loginDetails("mrFake", "madeuppassword");
//
//        // assert
//        Assert.assertEquals(response.getTemplateName(), "/login_failure.ftl");
//
//    }
//
//
//
//    @Test
//    public void testCorrectPassword(){
//
//
//        when(client.getLogin("mrFake","madeuppassword")).thenReturn(true);
//
//        // act
//        View response = viewsResource.loginDetails("mrFake", "madeuppassword");
//
//        // assert
//        Assert.assertEquals(response.getTemplateName(), "/login_success.ftl");
//
//
//    }



}
