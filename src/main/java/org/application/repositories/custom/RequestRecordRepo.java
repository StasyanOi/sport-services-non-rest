package org.application.repositories.custom;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Repository
public class RequestRecordRepo {

    private String jdbcUrl = "jdbc:h2:mem:db";
    private String username = "sa";
    private String password = "";

    private DriverManager driverManager;

    @PostConstruct
    public void init() throws SQLException {
        Connection connection = driverManager.getConnection(jdbcUrl, username, password);
        System.out.println(connection);
    }

    @PreDestroy
    public void destroy(){
    }

}
