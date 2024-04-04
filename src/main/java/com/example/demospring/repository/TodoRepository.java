package com.example.demospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demospring.model.Todo;

import jakarta.transaction.Transactional;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

	@Query(value = "SELECT todos.id, users.id AS user_id, username, email, todo, status FROM users, todos \n" + //
			"WHERE users.id = todos.user_id ", nativeQuery = true)
	List<Todo> findAllTodos();

	@Query(value = "SELECT todos.id, users.id AS user_id, username, email, todo, status FROM users, todos \n" + //
			"WHERE users.id = todos.user_id and todos.id = :id", nativeQuery = true)
	Todo findByID(@Param("id") Integer id);

	@Query(value = "SELECT todos.id, users.id AS user_id, username, email, todo, status FROM users, todos \n" + //
			"WHERE users.id = todos.user_id and todos.user_id = :user_id LIMIT :item_per_page OFFSET :page", nativeQuery = true)
	List<Todo> findTodosByUserID(@Param("user_id") Integer user_id, @Param("page") Integer page,
			@Param("item_per_page") Integer item_per_page);

	@Query(value = "SELECT COUNT(todos.id) FROM todos WHERE todos.user_id = :user_id", nativeQuery = true)
	Integer findTodosTotalByUserID(@Param("user_id") Integer user_id);

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO todos(user_id, todo, status) VALUES (:user_id, :todo, :status)", nativeQuery = true)
	int insertTodo(String user_id, String todo, String status);

	@Modifying
	@Transactional
	@Query(value = "UPDATE todos SET todo = :todo, status = :status WHERE todos.id = :id", nativeQuery = true)
	int updateTodo(Integer id, String todo, String status);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM todos WHERE todos.id = :id", nativeQuery = true)
	int deleteTodoByID(@Param("id") Integer id);

}
