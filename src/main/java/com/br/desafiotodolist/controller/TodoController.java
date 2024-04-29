package com.br.desafiotodolist.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.br.desafiotodolist.entity.Todo;
import com.br.desafiotodolist.service.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {

    TodoService todoService;

    // injeção de dependencias com construtor
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    
    @PostMapping // POST é usado para CRIAR um dado
    public List<Todo> create(@RequestBody Todo todo) {
        return todoService.create(todo);
    }

    @GetMapping
    public List<Todo> listAll() {
        return todoService.listAll();
    }

    @PutMapping // PUT é usado para ATUALIZAR algum dado existente
    public List<Todo> update(@RequestBody Todo todo) {
        return todoService.update(todo);
    }

    // Path variable seria assim: .../todos/1 . Esse "1" é o id passado para deletar
    @DeleteMapping("{id}")
    public List<Todo> delete(@PathVariable("id") Long id) {
        return todoService.delete(id);
    }

}
