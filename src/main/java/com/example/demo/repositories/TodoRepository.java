package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Todo;

/**
 * リポジトリ
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

}