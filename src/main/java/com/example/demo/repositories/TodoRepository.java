package com.example.demo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Todo;

/**
 * リポジトリ
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
	public Page<Todo> findByOrderByIdAsc(Pageable pageable);
}