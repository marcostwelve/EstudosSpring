package com.example.arquiteturaspring;

import com.example.arquiteturaspring.Todos.TodoEntity;
import com.example.arquiteturaspring.Todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Lazy(false) // Indica que o bean será carregado de forma preguiçosa (lazy loading)
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON) // Define o escopo do bean como singleton
//@Scope("WebApplicationContext.SCOPE_APPLICATION") // Tipo de escopo por request (Escopo por requisição)
//@Scope("session") // Tipo de requisição por sessão
//@Scope("application") // Tipo de requisição por sessão a todos os usuários em aplicação web
public class BeanGerenciado {

    @Autowired // Injeção de dependência automática pelo Spring
    private TodoValidator todoValidator;

    public BeanGerenciado(TodoValidator todoValidator) {
        this.todoValidator = todoValidator;
    }

    public void utilizar() {
        var todo = new TodoEntity();
        todoValidator.validar(todo); // utilizando a injeção do Spring
    }

    // Outra forma de injeção
    @Autowired
    public void setTodoValidator(TodoValidator todoValidator) {
        this.todoValidator = todoValidator;
    }
}
