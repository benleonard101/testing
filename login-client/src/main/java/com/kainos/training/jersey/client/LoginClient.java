package com.kainos.training.jersey.client;

import javax.ws.rs.client.*;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;


public class LoginClient
{

		private final String BASE_URL = "http://localhost:8080";
		private final String LOGIN_PATH = "login";
		private final String USERNAME_FORM_PARAM = "username";
		private final String PASSWORD_FORM_PARAM = "password";
		private final String REQUEST_ENCODING = "application/x-www-form-urlencoded";

		private final int SUCCESS_RESPONSE = 200;

		private WebTarget loginWebTarget;

		public LoginClient() {
			Client client = ClientBuilder.newClient();
			WebTarget webTarget = client.target(BASE_URL);
			loginWebTarget = webTarget.path(LOGIN_PATH);
		}

		public Boolean getLogin(String username, String password) {
			Form form = new Form();
			form.param(USERNAME_FORM_PARAM, username);
			form.param(PASSWORD_FORM_PARAM, password);

			Invocation.Builder invocationBuilder = loginWebTarget.request();
			Response response = invocationBuilder.post(Entity.entity(form, REQUEST_ENCODING));

			if (response.getStatus() == SUCCESS_RESPONSE) {
				return true;
			}
			return false;
		}


//	public Response getLogin(String username, String password) {
//		Form form = new Form();
//		form.param(USERNAME_FORM_PARAM, username);
//		form.param(PASSWORD_FORM_PARAM, password);
//
//		Invocation.Builder invocationBuilder = loginWebTarget.request();
//		Response response = invocationBuilder.post(Entity.entity(form, REQUEST_ENCODING));
//
//		if (response.getStatus() == SUCCESS_RESPONSE) {
//			String redurl = "http://localhost:8900/test/users";
//
//			URI uri = UriBuilder.fromUri(redurl).build();
//
//
//			return Response.seeOther(uri).build();
//		}
//		String redurl = "http://localhost:8900/test/users";
//
//		URI uri = UriBuilder.fromUri(redurl).build();
//
//
//		return Response.seeOther(uri).build();
//	}

	public boolean changeLoginPassword(String password) {
		Form form = new Form();
		form.param(PASSWORD_FORM_PARAM, password);

		Invocation.Builder invocationBuilder = loginWebTarget.request();
		Response response = invocationBuilder.put(Entity.entity(form, REQUEST_ENCODING));
		System.out.println(response.getEntity().toString());

		if (response.getStatus() == SUCCESS_RESPONSE) {
			return true;
		}
		return false;
	}

	public String listOfUsersAsAString() {


		Invocation.Builder invocationBuilder = loginWebTarget.request();
		Response response = invocationBuilder.get();

		//return response.readEntity(String.class);

		return response.readEntity(String.class);

	}




}
