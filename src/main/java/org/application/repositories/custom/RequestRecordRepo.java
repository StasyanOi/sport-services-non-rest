package org.application.repositories.custom;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.DriverManager;

@Repository
public class RequestRecordRepo {

    private String jdbcUrl = "jdbc:h2:mem:db";
    private String username = "sa";
    private String password = "";

    private DriverManager driverManager;

    @PostConstruct
    public void init(){
    }

    @PreDestroy
    public void destroy(){
    }

}
