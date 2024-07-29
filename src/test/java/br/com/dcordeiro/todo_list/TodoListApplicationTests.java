package br.com.dcordeiro.todo_list;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.dcordeiro.todo_list.entity.Todo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql("/remove.sql")
class TodoListApplicationTests {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateTodoSuccess() {
		var todo = new Todo("todo", "todo 1", false, 0);
		
		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isOk();
	}

	@Test
	void testCreateTodoFailure() {
		var todo = new Todo("", "todo 1", false, 0);

		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isBadRequest();
	}
	
	@Test
	void testNotFoundTodo() {
		webTestClient
				.get()
				.uri("/todos/1")
				.exchange()
				.expectStatus().isNotFound();
	}
	
	@Test
	@Sql("/import.sql")
	void testTodoListLength() {

		webTestClient
				.get()
				.uri("/todos")
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$.length()").isEqualTo(3);
	}
	
	@Test
	@Sql("/import.sql")
	void testIdFromTodoList() {

		webTestClient
				.get()
				.uri("/todos")
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$[1].id").isEqualTo(15);
	}
	
	@Test
	@Sql("/import.sql")
	void testDeleteTodo() {

		webTestClient
				.delete()
				.uri("/todos/99")
				.exchange()
				.expectStatus().isOk();
	}
	
	@Test
	@Sql("/import.sql")
	void testDeleteNotFoundTodo() {

		webTestClient
				.delete()
				.uri("/todos/2")
				.exchange()
				.expectStatus().isNotFound();
	}
	
	@Test
	@Sql("/import.sql")
	void testUpdateTodoSuccess() {
		Todo todo = new Todo();
		todo.setId(1L);
		todo.setTitle("Updated Title");
		todo.setDescription("Updated Description");
		todo.setFinished(true);
		todo.setPriority(1);

		webTestClient
				.put()
				.uri("/todos")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isOk();
	}
	
	@Test
	@Sql("/import.sql")
	void testUpdateTodoFailure() {
		Todo todo = new Todo();
		todo.setId(1L);
		todo.setTitle("");
		todo.setDescription("Updated Description");
		todo.setFinished(true);
		todo.setPriority(1);
		
		webTestClient
				.put()
				.uri("/todos")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isBadRequest();
	}
}
