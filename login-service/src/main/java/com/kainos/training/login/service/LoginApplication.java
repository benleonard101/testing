package com.kainos.training.login.service;

import com.kainos.login.models.Book;
import com.kainos.training.login.service.configuration.LoginConfiguration;
import com.kainos.training.login.service.resource.BooksResource;
import com.kainos.training.login.service.resource.LoginResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class LoginApplication extends Application<LoginConfiguration> {
    public static void main(String[] args) throws Exception {
        new LoginApplication().run(args);
    }

    private final HibernateBundle<LoginConfiguration> hibernate = new HibernateBundle<LoginConfiguration>(Book.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(LoginConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    @Override
    public void initialize(Bootstrap<LoginConfiguration> bootstrap) {
        super.initialize(bootstrap);
        bootstrap.addBundle(hibernate);
    }

    @Override
    public String getName() {
        return "login";
    }

    @Override
    public void run(LoginConfiguration configuration,
            Environment environment) {

        final BookDAO dao = new BookDAO(hibernate.getSessionFactory());

        final LoginResource resource = new LoginResource(
                configuration.getUserName(),
                configuration.getPassword()
        );
        environment.jersey().register(resource);

        final BooksResource resourceBook = new BooksResource(dao);
        environment.jersey().register(resourceBook);




    }

}
