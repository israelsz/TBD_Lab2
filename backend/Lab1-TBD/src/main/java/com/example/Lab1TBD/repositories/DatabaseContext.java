package com.example.Lab1TBD.repositories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;


@Configuration
public class DatabaseContext {
    //Datos de la base de datos
    @Value("${database.url}")
    private String url;

    @Value("${database.user}")
    private String username;

    @Value("${database.password}")
    private String password;

    @Bean
    public Sql2o sql2o(){
        return new Sql2o(url,username,password);
    }
}
