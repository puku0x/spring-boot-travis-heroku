package com.example.demo;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.controllers.TodoController;
import com.example.demo.entities.Todo;
import com.example.demo.services.TodoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(TodoController.class)
public class DemoApplicationTests {
	@Autowired
	MockMvc mvc;

	@MockBean
	private TodoService service;

	/**
	 * Todoを新規作成できるかのテスト
	 * @throws Exception
	 */
	@Test
	public void create() throws Exception {
		Todo todo = new Todo(null, "test", null, null, null);
		given(service.save(todo)).willReturn(todo);
		ObjectMapper objectMapper = new ObjectMapper();
		byte[] requestJson = objectMapper.writeValueAsBytes(todo);
		mvc.perform(post("/api/v1/todos")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestJson))
				.andExpect(status().isOk());
	}
}
