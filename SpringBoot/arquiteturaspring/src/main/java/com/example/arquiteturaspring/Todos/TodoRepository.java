package com.example.arquiteturaspring.Todos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Opcional
public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {

    boolean existsByDescricao(String id);
}
