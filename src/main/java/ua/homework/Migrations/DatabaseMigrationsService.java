package ua.homework.Migrations;

import org.flywaydb.core.Flyway;


import java.io.IOException;


public class DatabaseMigrationsService {


    public void initDbService(String connectionUrl) throws IOException {


        Flyway flyway = Flyway
                .configure()
                .dataSource(connectionUrl, null, null)
                .load();
        flyway.migrate();
    }

}


