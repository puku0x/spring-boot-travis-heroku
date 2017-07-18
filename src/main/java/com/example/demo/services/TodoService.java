package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Todo;
import com.example.demo.repositories.TodoRepository;

/**
 * サービス
 */
@Service
@Transactional
public class TodoService {
	@Autowired
	private TodoRepository todoRepository;

	/**
	 * 全件取得
	 * @param offset
	 * @param limit
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Todo> findAll(Integer offset, Integer limit) {
		return todoRepository.findAll(new PageRequest(offset, limit));
	}

	/**
	 * 1件取得
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Todo findById(Integer id) {
		return todoRepository.findOne(id);
	}

	/**
	 * 保存
	 * @param todo
	 * @return
	 */
	public Todo save(Todo todo) {
		return todoRepository.save(todo);
	}

	/**
	 * 削除
	 * @param todo
	 * @return
	 */
	public void delete(Todo todo) {
		todoRepository.delete(todo);
	}

}