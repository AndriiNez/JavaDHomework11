package ua.homework.migrations;

import org.flywaydb.core.Flyway;


import java.io.IOException;


public class DatabaseMigrationsService {

    public void initDbService(String connectionUrl) {
        Flyway flyway = Flyway
                .configure()
                .dataSource(connectionUrl, null, null)
                .load();
        flyway.migrate();
    }

}


