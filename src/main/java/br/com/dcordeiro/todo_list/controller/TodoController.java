package br.com.dcordeiro.todo_list.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dcordeiro.todo_list.entity.Todo;
import br.com.dcordeiro.todo_list.service.TodoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/todos")
@Validated
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping()
    public List<Todo> create(@Valid @RequestBody Todo todo) {
        return todoService.create(todo);
    }

    @GetMapping()
    public List<Todo> list() {
        return todoService.list();
    }

    @GetMapping("{id}")
    public Todo get(@PathVariable Long id) {
        return todoService.get(id);
    }

    @PutMapping()
    public List<Todo> update(@Valid @RequestBody Todo todo) {
        return todoService.update(todo);
    }

    @DeleteMapping("{id}")
    public List<Todo> delete(@PathVariable Long id) {
        return todoService.delete(id);
    }
}
