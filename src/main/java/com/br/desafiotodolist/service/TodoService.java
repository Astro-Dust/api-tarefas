package com.br.desafiotodolist.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.br.desafiotodolist.entity.Todo;
import com.br.desafiotodolist.repository.TodoRepository;

/* 
 * note que nos métodos criados, retorna sempre a lista de tarefas, isso pq
 * quero que ao criar, fazer update e deletar algo quero sempre mostrar as tarefas
*/

@Service
public class TodoService {

    // com o objeto criado e o construtor podemos usar os métodos pra manipular os dados do BD
    private TodoRepository todoRepository;

    // injeção de dependencias com construtor
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(Todo todo) {
        todoRepository.save(todo);
        return listAll();
    }

    // listando as tarefas em ordem de prioridade (maior pra menor) e por nome (de A-Z)
    public List<Todo> listAll() {
        Sort sort = Sort.by("prioridade").descending().and(
            Sort.by("nome").ascending()
        );
        return todoRepository.findAll(sort);
    }

    public List<Todo> update(Todo todo) {
        todoRepository.save(todo);
        return listAll();
    }

    public List<Todo> delete(Long id) {
        todoRepository.deleteById(id);
        return listAll();
    }

}
