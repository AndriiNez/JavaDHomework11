package ua.homework.Migrations;

import org.hibernate.cfg.Environment;

import java.io.IOException;
import java.util.Properties;

public class RiderHibernateUrl {

    public String hibernateUrl() throws IOException {
        Properties hibernateProperties = new Properties();
        hibernateProperties.load(DatabaseMigrationsService.class.getClassLoader().getResourceAsStream("hibernate.properties"));

        String hibernateUrl = hibernateProperties.getProperty(Environment.URL);
        return hibernateUrl;
    }
}
