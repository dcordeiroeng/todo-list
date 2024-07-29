package br.com.dcordeiro.todo_list.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.dcordeiro.todo_list.entity.Todo;
import br.com.dcordeiro.todo_list.exception.TodoNotFoundException;
import br.com.dcordeiro.todo_list.repository.TodoRepository;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(Todo todo) {
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> list() {
        Sort sort = Sort.by("priority").and(
                Sort.by("title"));
        return todoRepository.findAll(sort);
    }
    
    public Todo get(Long id) {
        return todoRepository.findById(id).orElseThrow(() -> new TodoNotFoundException(id));
    }

    public List<Todo> update(Todo todo) {
        return create(todo);
    }

    public List<Todo> delete(Long id) {
        if (!todoRepository.existsById(id)) {
            throw new TodoNotFoundException(id);
        }
        todoRepository.deleteById(id);
        return list();
    }
}
