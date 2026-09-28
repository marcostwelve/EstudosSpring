package com.example.arquiteturaspring.Todos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService service;
    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity entity) {

        try {
            return this.service.salvar(entity);
        } catch (IllegalArgumentException e) {
            var messageError = e.getMessage();
            throw new ResponseStatusException(HttpStatus.CONFLICT, messageError);
        }

    }

    @PutMapping("{id}")
    public void atualizarStatus(@PathVariable String id, @RequestBody TodoEntity entity) {
        entity.setId(Integer.parseInt(id));
        this.service.atualizar(entity);
    }

    @GetMapping("{id}")
    public TodoEntity getTodoById(@PathVariable("id") String id) {
        return this.service.buscarPorId(Integer.parseInt(id));
    }
}
