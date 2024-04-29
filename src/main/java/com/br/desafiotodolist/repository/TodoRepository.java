package com.br.desafiotodolist.repository;
import com.br.desafiotodolist.entity.Todo;

import org.springframework.data.jpa.repository.JpaRepository;

// repository permite a interação com o banco
public interface TodoRepository extends JpaRepository<Todo, Long> {
    
}
