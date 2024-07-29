package br.com.dcordeiro.todo_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dcordeiro.todo_list.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    
}
