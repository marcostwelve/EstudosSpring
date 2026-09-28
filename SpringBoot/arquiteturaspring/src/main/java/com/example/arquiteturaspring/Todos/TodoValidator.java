package com.example.arquiteturaspring.Todos;

import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    private TodoRepository todoRepository;

    public TodoValidator(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void validar(TodoEntity todo) {
        if(existeTodoComDescricao(todo.getDescricao())) {
            throw new IllegalArgumentException("Já existe um TODO com a mesma descrição.");
        }
    }

    private boolean existeTodoComDescricao(String descricao) {
        var exists = todoRepository.existsByDescricao(descricao);
        return exists;
    }
}
