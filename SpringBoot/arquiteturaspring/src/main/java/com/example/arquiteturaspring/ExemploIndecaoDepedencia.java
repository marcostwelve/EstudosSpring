package com.example.arquiteturaspring;

import com.example.arquiteturaspring.Todos.MailSender;
import com.example.arquiteturaspring.Todos.TodoRepository;
import com.example.arquiteturaspring.Todos.TodoService;
import com.example.arquiteturaspring.Todos.TodoValidator;
import jakarta.persistence.EntityManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;

public class ExemploIndecaoDepedencia {
    public static void main(String[] args) {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        //Connection connection = dataSource.getConnection();

        EntityManager entitManager = null;

        TodoRepository repository = null;
        TodoValidator todoValidator = new TodoValidator(repository);
        MailSender mailSender = new MailSender();

        TodoService todoService = new TodoService(repository, todoValidator, mailSender);
    }
}
