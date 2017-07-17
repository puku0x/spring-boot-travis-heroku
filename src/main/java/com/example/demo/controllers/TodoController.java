package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Todo;
import com.example.demo.forms.TodoForm;
import com.example.demo.services.TodoService;


@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
	@Autowired
	private TodoService todoService;

	/**
	 * 全件取得
	 * @param offset
	 * @param limit
	 * @return
	 */
	@GetMapping
	public Page<Todo> findAll(
			@RequestParam(name="offset", defaultValue="0") Integer offset,
			@RequestParam(name="limit", defaultValue="100") Integer limit) {
		return todoService.findAll(offset, limit);
	}

	/**
	 * 登録
	 * @param form
	 * @return
	 */
	@PostMapping
	public Todo create(@Valid @RequestBody TodoForm form) {
		Todo todo = new Todo();
		BeanUtils.copyProperties(form, todo);
		return todoService.save(todo);
	}

	/**
	 * 更新
	 * @param id
	 * @param form
	 * @return
	 */
	@PutMapping("/{id}")
	public Todo update(@PathVariable("id") Integer id, @Valid @RequestBody TodoForm form) {
		Todo todo = todoService.findById(id);
		todo.setContent(form.getContent());
		return todoService.save(todo);
	}

	/**
	 * 削除
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		Todo todo = todoService.findById(id);
		todoService.delete(todo);
	}
}