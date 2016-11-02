package com.kainos.training.login.service.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
public class LoginResource {

    private final String requiredUsername;
    private String requiredPassword;


    public ArrayList<User> users = new ArrayList<>();


    public LoginResource(String requiredUsername, String requiredPassword) {
        this.requiredUsername = requiredUsername;
        this.requiredPassword = requiredPassword;

        users.add(new User("admin", "password", "Ben Leonard"));
        users.add(new User("admin", "password", "Ryan Smith"));
    }


    @PUT
    public Response passwordChange(@FormParam("password") String password) {
        requiredPassword = password;

        System.out.println(requiredPassword);

        //Boolean changedPassword = (requiredPassword == "password2");

        return Response
                .status(Response.Status.OK)
                //.entity(" " + changedPassword)
                .build();
    }


    @POST
    public Response login(@FormParam("username") String username,
                          @FormParam("password") String password) {

        if (requiredUsername.equals(username) && requiredPassword.equals(password)) {

            return Response
                    .status(Response.Status.OK)
                    .entity("Success!")
                    .build();
        } else if (requiredUsername.equalsIgnoreCase(username) && requiredPassword.equalsIgnoreCase(password)) {

            return Response
                    .status(Response.Status.OK)
                    .entity("Success!")
                    .build();

        } else if ((requiredUsername == username || requiredPassword == password)) {
            return Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity("Fail!")
                    .build();
        } else {

            return Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity("Fail!")
                    .build();


        }
    }

//    @GET
//    public Response users() {
//
//
//        return Response
//                .status(Response.Status.OK)
//                .entity(users.toString())
//                .build();
//    }


}
