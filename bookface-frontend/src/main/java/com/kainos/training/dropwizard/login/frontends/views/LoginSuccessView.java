package com.kainos.training.dropwizard.login.frontends.views;

import io.dropwizard.views.View;

public class LoginSuccessView extends View {

	private String users;

	public String getUsers() {
		return users;
	}

	public LoginSuccessView(String users){
		super("/login_success.ftl");

		this.users = users;

	}


}
