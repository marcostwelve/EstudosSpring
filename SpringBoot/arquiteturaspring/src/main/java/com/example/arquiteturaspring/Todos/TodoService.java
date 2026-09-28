package com.example.arquiteturaspring.Todos;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository repository;
    private TodoValidator todoValidator;
    private MailSender mailSender;

    public TodoService(TodoRepository repository,  TodoValidator todoValidator, MailSender mailSender) {
        this.repository = repository;
        this.todoValidator = todoValidator;
        this.mailSender = mailSender;
    }

    public TodoEntity salvar(TodoEntity todo) {
        // Aqui você pode adicionar lógica de negócio antes de salvar
        todoValidator.validar(todo);
        String status  = todo.getConcluido() == Boolean.TRUE ? "concluido" : " não concuído";
        mailSender.sendMail("Novo TODO criado: " + todo.getDescricao() + " " + status);
        return repository.save(todo);
    }

    public void atualizar(TodoEntity todo) {
        repository.save(todo);
    }

    public TodoEntity buscarPorId(int id) {
        return repository.findById(id).orElse(null);
    }
}
