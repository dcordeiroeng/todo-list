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
}
